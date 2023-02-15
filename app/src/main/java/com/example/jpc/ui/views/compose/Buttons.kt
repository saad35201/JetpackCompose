package com.example.jpc.ui.views.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

object Buttons {

    @Composable
    fun BtnBlackRoundCorner(text: String, onClick: () -> Unit) {
        Button(
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            onClick = onClick,
            shape = RoundedCornerShape(10.dp)
        ) {
            Texts.TextBody(text = text, color = Color.White)
        }
    }

}