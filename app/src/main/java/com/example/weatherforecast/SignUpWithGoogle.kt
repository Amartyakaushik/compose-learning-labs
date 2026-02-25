package com.example.weatherforecast

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignUpWithGoogle(
    text : String = "Sign up with Google",
    loadingText : String = "Signing up..."
) {
    var clicked by remember {
        mutableStateOf(false)
    }
    Surface(
//        modifier = Modifier
//        .fillMaxSize(),
        shape = shapes.medium,
        onClick = {
            clicked = !clicked
        },
        border = BorderStroke(color = Color.LightGray, width = 1.dp),
        color =  Color.White
    ) {
        Row (
            modifier = Modifier
                .padding(top = 12.dp,
                    bottom = 12.dp,
                    start = 12.dp,
                    end = 16.dp)
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
//            horizontalArrangement = Arrangement.ce
        ){
            Icon(
                painter = painterResource(id = R.drawable.google_icon),
                tint = Color.Unspecified,
                contentDescription = "Google Icon",
                modifier = Modifier
                    .width(22.dp)
                    .height(22.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = if(clicked) loadingText else text,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.width(16.dp))
            if(clicked){
                CircularProgressIndicator(modifier = Modifier
                    .width(16.dp)
                    .height(16.dp),
                    strokeWidth = 2.dp,
                    color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpWithGooglePreview() {
    SignUpWithGoogle()
}