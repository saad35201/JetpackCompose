package com.example.jpc.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jpc.ui.theme.Typography
import kotlinx.coroutines.launch

class ActivityForgotPassword : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // Declaring a Boolean value to
            // store bottom sheet collapsed state
            val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
                bottomSheetState =
                BottomSheetState(BottomSheetValue.Collapsed)
            )

            // Declaring Coroutine scope
            val coroutineScope = rememberCoroutineScope()
            // Creating a Bottom Sheet
            BottomSheetScaffold(
                scaffoldState = bottomSheetScaffoldState,
                sheetContent = {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(400.dp)
                            .background(Color(0XFF0F9D58))) {
                        Column(
                            Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "Hello Geek!", fontSize = 20.sp, color = Color.White)
                        }
                    }
                },
                sheetPeekHeight = 0.dp
            ) {}

            Column(
                modifier = Modifier
                    .padding(vertical = 50.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Forgot Password?", style = Typography.h4)
                Text(
                    textAlign = TextAlign.Center,
                    text = "Enter your email address\n to receive OTP!",
                    style = Typography.body1
                )
                Spacer(modifier = Modifier.height(100.dp))
                TextField("Enter email address")
                Spacer(modifier = Modifier.height(200.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                    onClick = {
                        coroutineScope.launch {
                            if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                bottomSheetScaffoldState.bottomSheetState.expand()
                            } else {
                                bottomSheetScaffoldState.bottomSheetState.collapse()
                            }
                        }
                    },
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = "Get OTP", color = Color.White)
                }
            }
        }
    }
}

