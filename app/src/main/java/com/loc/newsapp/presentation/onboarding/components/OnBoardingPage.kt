package com.loc.newsapp.presentation.onboarding.components


import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.loc.newsapp.R
import com.loc.newsapp.presentation.Dimens
import com.loc.newsapp.presentation.Page
import com.loc.newsapp.presentation.pages
import com.loc.newsapp.ui.theme.NewsAppTheme


@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page:Page
) {
    Column( modifier = modifier) {
        Image(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(fraction = 0.6f)
            ,painter = painterResource(id = page.image)
            ,contentScale = ContentScale.Crop
            ,contentDescription = page.title)

        Spacer(modifier= Modifier.height(Dimens.MediumPadding))

        Text(text = page.title
            ,modifier = Modifier.padding(horizontal = Dimens.MediumPadding2)
            ,style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold)
            ,color = colorResource(id = R.color.display_small))

        Text(text = page.description,
            modifier = Modifier.padding(horizontal = Dimens.MediumPadding2),
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.text_medium))
    }
}
