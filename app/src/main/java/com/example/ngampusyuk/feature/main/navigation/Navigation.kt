package com.example.ngampusyuk.feature.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ngampusyuk.feature.banding.Banding
import com.example.ngampusyuk.feature.berita.Berita
import com.example.ngampusyuk.feature.editProfile.EditProfile
import com.example.ngampusyuk.feature.home.HomeScreen
import com.example.ngampusyuk.feature.main.route.Screen
import com.example.ngampusyuk.feature.peluang.Peluang
import com.example.ngampusyuk.feature.pilihBanding.PilihBanding
import com.example.ngampusyuk.feature.pilihUniv.PilihUniv
import com.example.ngampusyuk.feature.profile.Profile
import com.example.ngampusyuk.feature.signIn.SignIn
import com.example.ngampusyuk.feature.signUp.SignUp
import com.example.ngampusyuk.feature.splash.SplashScreen
import com.example.ngampusyuk.feature.universitas.UniversitasScreen

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

        composable(route = Screen.Banding.route) {
            Banding(navController = navController)
        }

        composable(route = Screen.SignIn.route) {
            SignIn(navController = navController)
        }

        composable(route = Screen.SignUp.route) {
            SignUp(navController = navController)
        }

        composable(route = Screen.Profil.route) {
            Profile(navController = navController)
        }

        composable(route = Screen.EditProfile.route) {
            EditProfile(navController = navController)
        }

        composable(route = "${Screen.Universitas.route}/{kampus_id}",
            arguments = listOf(
                navArgument("kampus_id") {
                    type = NavType.StringType
                }
            )
        )
        {
            val kampus_id = it.arguments?.getString("kampus_id") ?: ""
            UniversitasScreen(navController = navController, kampus_id)
        }

        composable(route = Screen.Berita.route) {
            Berita(navController = navController)
        }

        composable(route = Screen.PilihBanding.route) {
            PilihBanding(navController = navController)
        }

        composable(route = Screen.PilihUniv.route) {
            PilihUniv(navController = navController)
        }

        composable(route = Screen.Tes.route) {
            Peluang(navController = navController)
        }
    }
}