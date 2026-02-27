package com.example.weatherforecast.Navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.weatherforecast.Navigation.NestedNav.Screens.HomeScreen
import com.example.weatherforecast.Navigation.NestedNav.routes.NavScreen
import com.example.weatherforecast.Navigation.NestedNav.Screens.SecondScreen
import com.example.weatherforecast.Navigation.NestedNav.routes.argument1
import com.example.weatherforecast.Navigation.NestedNav.routes.argument2

@Composable
fun SetUpNavGraph(
    navController : NavHostController
){
    NavHost(
        navController = navController,
        startDestination = NavScreen.Home.route
    ){
        composable(
            route = NavScreen.Home.route
        ){
            HomeScreen(navController = navController)
        }

        composable(
            route = NavScreen.SecondScreen.route,
            arguments = listOf(
                navArgument(argument1){
                    type = NavType.StringType
//                    defaultValue = 0
                },
                navArgument(argument2){
                    type = NavType.StringType
                }
            )
        ){
            Log.d("Args", it.arguments?.getString("$argument1").toString())
            Log.d("Args", it.arguments?.getString("$argument2").toString())
            SecondScreen(navController = navController)
        }
    }
}