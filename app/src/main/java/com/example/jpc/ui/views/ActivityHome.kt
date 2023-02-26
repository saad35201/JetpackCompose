package com.example.jpc.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

class ActivityHome : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Slider(images = DataProvider.posterList)
        }
    }
}

data class Poster(
    val id: Int,
    val title: String,
    val imageUrl: String
)

object DataProvider {
    val posterList = listOf(
        Poster(1, "Poster 1", "https://picsum.photos/200/300?grayscale"),
        Poster(2, "Poster 2", "https://picsum.photos/200/300?grayscale"),
        Poster(3, "Poster 3", "https://picsum.photos/200/300?grayscale"),
        Poster(4, "Poster 4", "https://picsum.photos/200/300?grayscale"),
        Poster(5, "Poster 5", "https://picsum.photos/200/300?grayscale"),
        Poster(6, "Poster 6", "https://picsum.photos/200/300?grayscale"),
        Poster(7, "Poster 7", "https://picsum.photos/200/300?grayscale"),
        Poster(8, "Poster 8", "https://picsum.photos/200/300?grayscale"),
        Poster(9, "Poster 9", "https://picsum.photos/200/300?grayscale"),
        Poster(10, "Poster 10", "https://picsum.photos/200/300?grayscale")
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Slider(images: List<Poster>) {
    val pagerState = rememberPagerState(initialPage = 0)

    Box(
        modifier = Modifier
            .padding(20.dp)
            .height(180.dp)
            .background(Color.LightGray, RoundedCornerShape(10.dp))
    ) {
        HorizontalPager(
            count = images.size,
            state = pagerState,
            modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(10.dp))
        ) {
            val image = images[it]
            Image(
                painter = rememberImagePainter(image.imageUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp))
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = image.title,
                    style = MaterialTheme.typography.body1,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
    }
}

