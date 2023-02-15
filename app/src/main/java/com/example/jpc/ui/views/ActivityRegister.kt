package com.example.jpc.ui.views

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jpc.ui.theme.Typography
import com.example.jpc.ui.views.compose.TextFields
import com.example.jpc.ui.views.compose.Texts
import com.togitech.ccp.component.TogiCountryCodePicker

class ActivityRegister : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(
                modifier = Modifier
                    .padding(vertical = 50.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Sign Up!", style = Typography.h4)
                Text(
                    textAlign = TextAlign.Center,
                    text = "Register your self to enjoy!!",
                    style = Typography.body1
                )

                Spacer(modifier = Modifier.height(60.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(0.8f),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextFieldLessWidth("First name")
                    TextFieldLessWidth("Last name")
                }
                Column(
                    modifier = Modifier
                        .padding(top = 15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextFields.OutLinedTextField("Username")
                    CCP()
                    TextFields.OutLinedTextField("Password")
                    Spacer(modifier = Modifier.height(15.dp))
                    TextFields.OutLinedTextField("Confirm password")
                }
                Spacer(modifier = Modifier.height(50.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = "SignUp", color = Color.White)
                }
                Spacer(modifier = Modifier.height(30.dp))
                Texts.ClickAbleText(msg1 =  "Already have an account? ", msg2 = "Login now", onClick = {
                    this@ActivityRegister.finish()
                })
            }

        }
    }
}

@Composable
fun CCP() {
    val phoneNumber = rememberSaveable { mutableStateOf("") }
    TogiCountryCodePicker(
        modifier = Modifier.fillMaxWidth(0.87f),
        text = phoneNumber.value,
        color = Color.Transparent,
        onValueChange = { phoneNumber.value = it },
        unfocusedBorderColor = Color.Gray,
        focusedBorderColor = Color.Black,
        bottomStyle = false, //  if true the text-field is below the country code selector at the top.
        shape = RoundedCornerShape(5.dp)
    )
}

@Composable
fun TextFieldLessWidth(text_tittle: String) {
    var textstate by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .height(50.dp)
            .requiredWidth(LocalConfiguration.current.screenWidthDp.dp / 2.8f),
        value = textstate,
        maxLines = 1,
        singleLine = true,
        onValueChange = { textstate = it },
        placeholder = {
            Text(text = text_tittle, fontSize = 14.sp)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color.Black)
    )
}