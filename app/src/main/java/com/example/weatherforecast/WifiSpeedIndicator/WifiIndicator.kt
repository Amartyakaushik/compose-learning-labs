package com.example.weatherforecast.WifiSpeedIndicator

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun WifiIndicator(
    canvasSize : Dp = 300.dp,
    indicatorVal : Int = 9,
    maxIndicatorVal : Int = 100,
    backgroundIndicatorColor: Color = Color.LightGray.copy(alpha = 0.4f),
//    colors.onSurface.copy(alpha = 0.1f),
    backgroundIndicatorStrokeWidth: Float = 100f,
    foregroundIndicatorColor: Color = Color.Green,
    foregroundIndicatorStrokeWidth: Float = 100f,
//    indicatorStrokeCap: StrokeCap = StrokeCap.Round,
    bigTextFontSize: TextUnit = MaterialTheme.typography.bodyLarge.fontSize,
    bigTextColor: Color = Color.Black,
    bigTextSuffix: String = "GB",
    smallText: String = "Remaining",
    smallTextFontSize: TextUnit = MaterialTheme.typography.bodySmall.fontSize,
    smallTextColor: Color = Color.Gray
){
    var allowedIndicatorVal by remember { mutableStateOf(maxIndicatorVal) }
    allowedIndicatorVal = if(indicatorVal <= maxIndicatorVal) indicatorVal else maxIndicatorVal
    val percentage = allowedIndicatorVal.toFloat() / maxIndicatorVal.toFloat() * 100
    val sweepAngle by animateFloatAsState(
        targetValue = (percentage * 2.4f),
        animationSpec = tween(1000))
    var animatedIndicatorValue by remember { mutableStateOf(0f) }
    LaunchedEffect(key1 = allowedIndicatorVal) {
        animatedIndicatorValue = allowedIndicatorVal.toFloat()
    }

    val receivedValue by animateIntAsState(
        targetValue = allowedIndicatorVal,
        animationSpec = tween(1000)
    )

    val animatedBigTextColor by animateColorAsState(
        targetValue = if (allowedIndicatorVal == 0)
            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
        else
            bigTextColor,
        animationSpec = tween(1000)
    )

    Column(
        modifier = Modifier
            .size(canvasSize)
            .drawBehind {
                val componentSize = size / 1.25f
                backgroundIndicator(
                    componentSize = componentSize,
                    indicatorColor = backgroundIndicatorColor,
                    indicatorStrokeWidth = backgroundIndicatorStrokeWidth,

                )
                foregroundIndicator(
                    componentSize = componentSize,
                    color =  foregroundIndicatorColor,
                    indicatorStrokeWidth = foregroundIndicatorStrokeWidth,
                    sweepAngle = sweepAngle,
                )
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        EmbeddedText(
            bigText = receivedValue,
            bigTextFontSize = bigTextFontSize,
            smallTextFontSize = smallTextFontSize,
            bigTextColor = animatedBigTextColor,
            smallTextColor = smallTextColor,
            bigTextSuffix = bigTextSuffix,
            smallText = smallText
        )
    }
}
fun DrawScope.backgroundIndicator(
    componentSize: Size,
    indicatorColor: Color,
    indicatorStrokeWidth: Float,
//    indicatorStokeCap: StrokeCap
) {
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 150f,
        sweepAngle = 240f,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )
}

fun DrawScope.foregroundIndicator(
    componentSize : Size,
    color: Color,
    indicatorStrokeWidth : Float,
    sweepAngle : Float,
){
    drawArc(
        size = componentSize,
        color = color,
        startAngle = 150f,
        sweepAngle = sweepAngle,
        useCenter = false,
        style = Stroke(indicatorStrokeWidth, cap = StrokeCap.Round),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )

    )
}

@Composable
fun EmbeddedText(
    bigText: Int,
    bigTextFontSize: TextUnit,
    smallTextFontSize: TextUnit,
    bigTextColor: Color,
    smallTextColor: Color,
    bigTextSuffix: String = "GB",
    smallText: String = "Remaining"
) {
    Text(
        text = smallText,
        fontSize = smallTextFontSize,
        color = smallTextColor,
        textAlign = TextAlign.Center
    )
    Text(
        text = "$bigText $bigTextSuffix",
        fontSize = bigTextFontSize,
        fontWeight = FontWeight.Bold,
        color = bigTextColor,
        textAlign = TextAlign.Center
    )
}
@Preview(showBackground = true)
@Composable
fun WifiIndicatorPreview(){
    WifiIndicator()
}
