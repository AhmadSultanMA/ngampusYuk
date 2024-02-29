package com.example.ngampusyuk.feature.main.navigation

import com.example.ngampusyuk.R
import com.example.ngampusyuk.feature.main.route.Screen

sealed class BottomNavigationItem(
    val route: String,
    val icon: Int,
    val label: String
) {
    object Home: BottomNavigationItem(route = Screen.Home.route, icon = R.drawable.ic_home, label = "Beranda")
    object Activity: BottomNavigationItem(route = Screen.Tes.route, icon = R.drawable.ic_test, label = "Tes")
    object Faq: BottomNavigationItem(route = Screen.Banding.route, icon = R.drawable.ic_banding, label = "Banding")
    object Profile: BottomNavigationItem(route = Screen.Profil.route, icon = R.drawable.ic_profil, label = "Profil")
}
