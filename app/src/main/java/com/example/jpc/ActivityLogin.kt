package com.example.jpc

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jpc.ui.theme.Typography

class ActivityLogin : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(
                modifier = Modifier
                    .padding(vertical = 50.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Hello Again!", style = Typography.h4)
                Text(
                    textAlign = TextAlign.Center,
                    text = "Welcome back you've\nbeen missed!",
                    style = Typography.body1
                )
                Column(
                    modifier = Modifier
                        .padding(top = 60.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField("Enter username")
                    Spacer(modifier = Modifier.height(15.dp))
                    TextField("Enter password")
                    Spacer(modifier = Modifier.height(5.dp))
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "Forgot password?",
                        style = Typography.body2
                    )
                }
                Spacer(modifier = Modifier.height(80.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = "Login", color = Color.White)
                }
                Spacer(modifier = Modifier.height(30.dp))
                Divider(
                    color = Color.Black,
                    thickness = 1.dp,
                    modifier = Modifier.fillMaxWidth(0.8f)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(0.8f),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(40.dp),
                            painter = painterResource(id = R.drawable.ic_facebook),
                            contentDescription = "facebook"
                        )
                        Text(text = "facebook", fontSize = 12.sp)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(40.dp),
                            painter = painterResource(id = R.drawable.ic_google),
                            contentDescription = "google"
                        )
                        Text(text = "google", fontSize = 12.sp)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(40.dp),
                            painter = painterResource(id = R.drawable.ic_twitter),
                            contentDescription = "twitter"
                        )
                        Text(text = "twitter", fontSize = 12.sp)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(40.dp),
                            painter = painterResource(id = R.drawable.ic_linkedin),
                            contentDescription = "linkedIn"
                        )
                        Text(text = "linkedIn", fontSize = 12.sp)
                    }
                }
                Spacer(modifier = Modifier.height(80.dp))
                val context = LocalContext.current
                ClickableText(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.Black)) {
                            append(
                                "Not a member?"
                            )
                        }
                        withStyle(
                            style = SpanStyle(
                                color = Color.Black,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append(
                                " Register now"
                            )
                        }
                    },
                    onClick = {
                        startActivity(
                            Intent(
                                this@ActivityLogin,
                                ActivityRegister::class.java
                            )
                        )
                    })

            }

        }

    }

}


@Composable
fun TextField(text_tittle: String) {
    var textstate by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(0.8f),
        value = textstate,
        onValueChange = { textstate = it },
        placeholder = {
            Text(text = text_tittle, fontSize = 14.sp)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color.Black)
    )
}
