package com.example.weatherforecast.Navigation.NestedNav.navGraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.weatherforecast.Navigation.NestedNav.Screens.Login
import com.example.weatherforecast.Navigation.NestedNav.routes.NavScreen
import com.example.weatherforecast.Navigation.NestedNav.routes.authRoute

fun NavGraphBuilder.AuthNav(
    navController: NavController
){
    navigation(
        startDestination = NavScreen.Auth.route,
        route = authRoute
    ){
        composable (
            route = NavScreen.Auth.route
            ){
            Login(
                navController = navController
            )
        }
    }
}