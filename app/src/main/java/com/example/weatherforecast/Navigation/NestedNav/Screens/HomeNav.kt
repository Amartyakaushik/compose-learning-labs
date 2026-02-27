package com.example.weatherforecast.Navigation.NestedNav.Screens

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.weatherforecast.Navigation.NestedNav.routes.NavScreen
import com.example.weatherforecast.Navigation.NestedNav.routes.homeRoute

fun NavGraphBuilder.HomeNav(
    navController: NavController
){
    navigation(
        startDestination = NavScreen.Home.route,
        route = homeRoute
    ){
        composable(
            route = NavScreen.Home.route
        ){
            HomeScreen(navController = navController)
        }
        composable(
            route = NavScreen.SecondScreen.route
        ) {
            SecondScreen(navController = navController)
        }
    }
}