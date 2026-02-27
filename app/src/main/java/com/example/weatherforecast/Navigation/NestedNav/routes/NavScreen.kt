package com.example.weatherforecast.Navigation.NestedNav.routes

const val argument1 = "id"
const val argument2 = "name"
const val rootRoute = "root_route"
const val homeRoute = "home_route"
const val authRoute = "auth_route"
sealed class NavScreen(val route : String) {
    object Home : NavScreen("home_screen")
    object SecondScreen : NavScreen("second_screen/{$argument1}/{$argument2}"){
        fun addNameAndId(
            id : Int,
            name : String
        ) : String{
            return this.route.replace(oldValue = "{$argument1}", newValue = id.toString()).replace(oldValue = "{$argument2", newValue = name.toString())
        }
    }
    object Auth : NavScreen("auth_screen")
}