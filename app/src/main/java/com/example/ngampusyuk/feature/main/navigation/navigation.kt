package com.example.ngampusyuk.feature.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ngampusyuk.feature.home.HomeScreen
import com.example.ngampusyuk.feature.main.route.Screen
import com.example.ngampusyuk.feature.splash.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Splash.route) {

        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
    }
}