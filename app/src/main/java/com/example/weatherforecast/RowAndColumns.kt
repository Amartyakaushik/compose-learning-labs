package com.example.weatherforecast

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherforecast.ui.theme.WeatherForeCastTheme

@Composable
fun RowAndColumns(modifier: Modifier = Modifier) {
//    Col(modifier)
    Roww()
}

@Composable
fun ColumnScope.CustomCol(
    color: androidx.compose.ui.graphics.Color,
    weight: Float = 1f
) {
    Surface(
        modifier = Modifier
            .width(300.dp)
            .height(70.dp)
            .weight(weight),
        color = color
    ) {}
}

@Composable
fun Col(modifier: Modifier = Modifier) {
    WeatherForeCastTheme {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            CustomCol(MaterialTheme.colorScheme.secondary, 3f)
            CustomCol(MaterialTheme.colorScheme.error)
        }
    }
}

@Composable
fun RowScope.CustomRoww
(
    color: androidx.compose.ui.graphics.Color,
    weight: Float = 1f
) {
    Surface(
        modifier = Modifier
            .width(300.dp)
            .height(70.dp)
            .weight(weight),
        color = color
    ) {}
}
@Composable
fun Roww
(modifier: Modifier = Modifier) {
    WeatherForeCastTheme {
        Row (
            modifier = modifier.fillMaxSize(),
//            horizontalArrangement = Arrangement.Start,
//            verticalArrangement = Arrangement.Top
        ) {
            CustomRoww(MaterialTheme.colorScheme.secondary, 3f)
            CustomRoww(MaterialTheme.colorScheme.error)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RowAndColumnsPreview() {
    WeatherForeCastTheme{
//        Col()
        Roww()
    }
}