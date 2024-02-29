package com.example.ngampusyuk.feature.main.route

sealed class Screen(val route: String){
    object Splash : Screen("splash")
    object Home : Screen("home")
    object Tes : Screen("tes")
    object Banding : Screen("banding")
    object Profil : Screen("profil")
}