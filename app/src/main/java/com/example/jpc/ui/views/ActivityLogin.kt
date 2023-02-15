package com.example.jpc.ui.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.jpc.R
import com.example.jpc.ui.views.compose.Buttons
import com.example.jpc.ui.views.compose.Images
import com.example.jpc.ui.views.compose.TextFields
import com.example.jpc.ui.views.compose.Texts

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
                Texts.TextHeading(text = "Hello Again!")
                Texts.TextBody(
                    text = "Welcome back you've\nbeen missed!",
                    textAlign = TextAlign.Center
                )
                Column(
                    modifier = Modifier
                        .padding(top = 60.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextFields.OutLinedTextField("Enter username")
                    Spacer(modifier = Modifier.height(15.dp))
                    TextFields.OutLinedTextField("Enter password")
                    Spacer(modifier = Modifier.height(5.dp))
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    horizontalAlignment = Alignment.End
                ) {
                    Texts.ClickAbleText(msg1 = "Forgot password?", onClick = {
                        startActivity(
                            Intent(
                                this@ActivityLogin,
                                ActivityForgotPassword::class.java
                            )
                        )
                    })
                }
                Spacer(modifier = Modifier.height(80.dp))
                Buttons.BtnBlackRoundCorner(text = "Login", onClick = {
                    Log.e("TAG", "onCreate: " )
                })
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
                        Images.CircleImgSmall(
                            painter = painterResource(id = R.drawable.ic_facebook),
                            contentDescription = "facebook"
                        )
                        Texts.TextSmall(text = "facebook")
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Images.CircleImgSmall(
                            painter = painterResource(id = R.drawable.ic_google),
                            contentDescription = "google"
                        )
                        Texts.TextSmall(text = "google")
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Images.CircleImgSmall(
                            painter = painterResource(id = R.drawable.ic_twitter),
                            contentDescription = "twitter"
                        )
                        Texts.TextSmall(text = "twitter")
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Images.CircleImgSmall(
                            painter = painterResource(id = R.drawable.ic_linkedin),
                            contentDescription = "linkedIn"
                        )
                        Texts.TextSmall(text = "linkedIn")
                    }
                }
                Spacer(modifier = Modifier.height(80.dp))
                Texts.ClickAbleText(msg1 = "Not a member?", msg2 = " Register now", onClick = {
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
