package com.example.retrofitapp.Navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.retrofitapp.MainViewModel
import com.example.retrofitapp.Navigation.Screens.HomeScreen

@Composable
fun Navigation(
    navController: NavHostController
){
    val myViewModel = hiltViewModel<MainViewModel>()

    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ){
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController)
        }
    }
}