package com.loc.newsapp.domain.usecases.news

import androidx.paging.PagingData
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.repository.NewsRepository

class GetNews(
    private val  newsRepository: NewsRepository
) {

    operator fun invoke(sources:List<String>):kotlinx.coroutines.flow.Flow<PagingData<Article>>{
        return newsRepository.getNews(sources = sources)
    }
}