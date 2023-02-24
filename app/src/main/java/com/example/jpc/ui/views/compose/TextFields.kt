package com.example.jpc.ui.views.compose

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.text.Typography

object TextFields {

    @Composable
    fun OutLinedTextField(value: String,
                          onValueChange: (String) -> Unit,
                          modifier: Modifier = Modifier,
                          enabled: Boolean = true,
                          readOnly: Boolean = false,
                          textStyle: TextStyle = LocalTextStyle.current,
                          label: @Composable (() -> Unit)? = null,
                          placeholder: @Composable (() -> Unit)? = null,
                          leadingIcon: @Composable (() -> Unit)? = null,
                          trailingIcon: @Composable (() -> Unit)? = null,
                          isError: Boolean = false,
                          visualTransformation: VisualTransformation = VisualTransformation.None,
                          keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
                          keyboardActions: KeyboardActions = KeyboardActions.Default,
                          singleLine: Boolean = false,
                          maxLines: Int = Int.MAX_VALUE,
                          interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
                          shape: Shape = MaterialTheme.shapes.small,
                          colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors()) {
        var textstate by remember { mutableStateOf("") }

        OutlinedTextField(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(0.8f),
            value = textstate,
            onValueChange = { textstate = it },
            placeholder = {
                Text(text = value, fontSize = 14.sp)
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color.Black)
        )
    }


}