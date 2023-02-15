package com.example.jpc.ui.views.compose

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.jpc.ui.theme.Typography

object Texts {

    @Composable
    fun TextHeading(text: String, textAlign: TextAlign? = null, color: Color = Color.Black) {
        Text(text = text, style = Typography.h4, textAlign = textAlign, color = color)
    }

    @Composable
    fun TextBody(text: String, textAlign: TextAlign? = null, color: Color = Color.Black) {
        Text(text = text, style = Typography.body1, textAlign = textAlign, color = color)
    }

    @Composable
    fun TextSmall(text: String, textAlign: TextAlign? = null, color: Color = Color.Black) {
        Text(text = text, style = Typography.body2, textAlign = textAlign, color = color)
    }

    @Composable
    fun ClickAbleText(msg1: String, msg2: String = "", onClick: (Int) -> Unit) {
        ClickableText(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Black)) {
                    append(
                        msg1
                    )
                }
                withStyle(
                    style = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append(
                        msg2
                    )
                }
            },
            onClick = onClick
        )
    }

}