package com.example.jpc.ui.views.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

object Images {

    @Composable
    fun CircleImgSmall(painter: Painter,contentDescription: String) {
        Image(
            modifier = Modifier
                .clip(CircleShape)
                .size(40.dp),
            painter = painter,
            contentDescription = contentDescription
        )
    }

}