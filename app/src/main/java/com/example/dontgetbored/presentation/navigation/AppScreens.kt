package com.example.dontgetbored.presentation.navigation

sealed class AppScreens (val route: String) {
    object HomeScreen: AppScreens("home_screen")
}