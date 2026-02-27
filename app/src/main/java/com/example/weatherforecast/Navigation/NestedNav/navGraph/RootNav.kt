package com.example.weatherforecast.Navigation.NestedNav.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.weatherforecast.Navigation.NestedNav.Screens.HomeNav
import com.example.weatherforecast.Navigation.NestedNav.routes.homeRoute
import com.example.weatherforecast.Navigation.NestedNav.routes.rootRoute

@Composable
fun RootNav(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = homeRoute,
        route = rootRoute
    ){
        HomeNav(navController = navController)
        AuthNav(navController = navController)

    }
}