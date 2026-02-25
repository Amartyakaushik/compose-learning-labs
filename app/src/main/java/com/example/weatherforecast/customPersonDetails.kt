package com.example.weatherforecast

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherforecast.model.person

@Composable
fun customPersonDetails(person: person) {
    Row (
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Text(text = "Age: ${person.age}",
            color = Color.Black,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.padding(5.dp))
        Text(text = "Name: ${person.firstname}",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal)
        Text(text = " ${person.lastname}",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal)
    }
}