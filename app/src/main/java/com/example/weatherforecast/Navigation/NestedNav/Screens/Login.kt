package com.example.weatherforecast.Navigation.NestedNav.Screens

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.weatherforecast.Navigation.NestedNav.routes.NavScreen

@Composable
fun Login(
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                color = Color.Black,
                modifier = Modifier.background(color = Color.Gray),
                text = "Login",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(
                modifier = Modifier.height(40.dp)
            )
            Button(
                modifier = Modifier.fillMaxWidth()
                    .height(40.dp)
                    .padding(horizontal = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White
                ),
                onClick = {
                    navController.navigate(NavScreen.Home.route){
                        popUpTo(
                            NavScreen.Home.route
                        ){
                            inclusive = true
                        }
                    }
                },
            )  {
                Text(text = "Go Home")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview(){
    Login(navController = rememberNavController())
}
