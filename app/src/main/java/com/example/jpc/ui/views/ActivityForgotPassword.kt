package com.example.jpc.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.jpc.ui.theme.Typography
import kotlinx.coroutines.launch

class ActivityForgotPassword : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            //bottom sheet state
            val sheetState = rememberModalBottomSheetState(
                initialValue = ModalBottomSheetValue.Hidden,
                confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded }
            )
            val coroutineScope = rememberCoroutineScope()

            //back press listener
            BackHandler(sheetState.isVisible) {
                coroutineScope.launch { sheetState.hide() }
            }

            //--------------------------------------------------------------------//

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
                            if (sheetState.isVisible) sheetState.hide()
                            else sheetState.show()
                        }
                    },
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = "Get OTP", color = Color.White)
                }
            }

            //bottom sheet
            ModalBottomSheetLayout(
                sheetState = sheetState,
                sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
                sheetContent = { BottomSheet() },
                modifier = Modifier.fillMaxSize()
            ) {}

        }
    }
}

@Composable
fun BottomSheet() {
    Column(modifier = Modifier.fillMaxHeight(0.6f), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Bottom sheet",
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Click outside the bottom sheet to hide it",
            style = MaterialTheme.typography.body1
        )
    }
}