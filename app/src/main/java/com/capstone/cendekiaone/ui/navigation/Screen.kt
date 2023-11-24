package com.capstone.cendekiaone.ui.navigation

sealed class Screen(val route: String) {
    object Intro : Screen("intro")
    object Login : Screen("login")
    object Register : Screen("register")
    object Home : Screen("home")
    object Create : Screen("create")
    object Profile : Screen("profile")
}