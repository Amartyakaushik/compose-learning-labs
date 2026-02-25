package com.example.weatherforecast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherforecast.WeatherApp.ui.WeatherScreen
import com.example.weatherforecast.noteUi.NoteScreen
import com.example.weatherforecast.ui.theme.Typography
import com.example.weatherforecast.ui.theme.WeatherForeCastTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherForeCastTheme {
//                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
////                        Greeting(
////                            name = "Android",
////                            modifier = Modifier.padding(innerPadding)
////                        )
////                        customText(text = "Amartya")
////                        RowAndColumns(
////                            modifier = Modifier.padding(innerPadding)
////                        )
//                    }

                Surface(
                    modifier = Modifier
//                        .width(700.dp)
//                        .height(300.dp)
                        .fillMaxSize()
                        .background(
//                    color = MaterialTheme.colorScheme.primary
                            color = Color.Black
                        ),
//                        .padding(16.dp),

                    color = Color.White

                ) {
                    Box(modifier = Modifier
                        .height(300.dp)
                        .padding(horizontal = 15.dp)
                        .padding(top = 55.dp)
                        .background(
                            color = Color.White
                        ),
//                        contentAlignment = Alignment.TopStart

                        contentAlignment = Alignment.Center
                        ){
                        //            RowAndColumns()
                        //            Boxx()
                        //                    customText()
                        //                    textSelection()
//                        ExpandableCard()
//                        SignUpWithGoogle()
//                          PasswordEditText()
////                        LazyColumnn()
//                        NoteScreen()
                        WeatherScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Composable
//fun customText(text : String) {
//    Text(
//        text = text,
////        modifier = Modifier
//          style = Typography.bodyMedium
//
//    )
//
//}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherForeCastTheme {
//        Greeting("Android")
        Surface(
            modifier = Modifier
                .width(700.dp)
                .background(
//                    color = MaterialTheme.colorScheme.primary
                    color = Color.White
                ),
//                .padding(16.dp),
            color = MaterialTheme.colorScheme.onSurface

        ) {
//            RowAndColumns()
//            Boxx()
//            customText()
//            textSelection()
//            PasswordEditText()
//            ExpandableCard()
//            SignUpWithGoogle()
//            LazyColumnn()

            NoteScreen()
        }
    }
}