package com.example.jpc.ui.views.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object TextFields {

    @Composable
    fun OutLinedTextField(hint: String) {
        var textstate by remember { mutableStateOf("") }

        OutlinedTextField(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(0.8f),
            value = textstate,
            onValueChange = { textstate = it },
            placeholder = {
                Text(text = hint, fontSize = 14.sp)
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color.Black)
        )
    }


}