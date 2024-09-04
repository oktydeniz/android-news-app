package com.loc.newsapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.loc.newsapp.domain.model.Article

class SearchNewPagingSource (
    private val newsApi:NewsApi,
    private val searchQuery:String,
    private val sources:String
): PagingSource<Int,Article>() {

    private var totalCount = 0;

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { p->
            val anchorPage = state.closestPageToPosition(p)
            anchorPage?.prevKey?.plus(1) ?:anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?:1
        return try {
            val newsResponse = newsApi.searchNews(searchQuery= searchQuery,sources = sources, page = page)
            totalCount += newsResponse.articles.size
            val articles = newsResponse.articles.distinctBy { it.title }
            LoadResult.Page(data = articles, nextKey = if (totalCount == newsResponse.totalResults) null else page +1, prevKey = null)
        }catch (e:Exception){
            e.printStackTrace()
            LoadResult.Error(throwable = e)
        }
    }
}