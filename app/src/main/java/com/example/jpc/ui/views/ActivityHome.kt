package com.example.jpc.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

class ActivityHome : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AutoImageSlider()
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
fun AutoImageSlider() {

    val posterList = DataProvider.posterList
    val state = rememberPagerState()
    val imageUrl = remember { mutableStateOf("") }

    LaunchedEffect(key1 = state.currentPage) {
        delay(3000)
        var newPosition = state.currentPage + 1
        if (newPosition > posterList.size - 1) newPosition = 0
        // scrolling to the new position.
        state.animateScrollToPage(newPosition)
    }

    HorizontalPager(
        state = state,
        count = posterList.size,
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .padding(10.dp, 20.dp, 10.dp)
    ) { page ->

        imageUrl.value = posterList[page].imageUrl

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(contentAlignment = Alignment.BottomCenter) {

                val painter = rememberImagePainter(data = imageUrl.value, builder = {
                    //placeholder(R.drawable.placeholder)
                    scale(Scale.FILL)
                })
                Image(
                    painter = painter, contentDescription = "", Modifier
                        .padding(8.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxSize(), contentScale = ContentScale.Crop
                )
                Text(
                    text = posterList[page].title,
                    Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(8.dp)
                        .background(
                            color = Color.LightGray,
                            shape = RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp)
                        )
                        .padding(8.dp),
                    textAlign = TextAlign.Start,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }

    }

}
