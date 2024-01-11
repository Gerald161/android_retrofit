package com.example.retrofitapp.Navigation

sealed class Screen (val route: String) {
    object HomeScreen : Screen("home")
}