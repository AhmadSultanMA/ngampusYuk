package com.example.ngampusyuk.feature.main.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ngampusyuk.feature.banding.Banding
import com.example.ngampusyuk.feature.berita.Berita
import com.example.ngampusyuk.feature.editProfile.EditProfile
import com.example.ngampusyuk.feature.hasilBanding.HasilBanding
import com.example.ngampusyuk.feature.home.HomeScreen
import com.example.ngampusyuk.feature.main.route.Screen
import com.example.ngampusyuk.feature.peluang.Peluang
import com.example.ngampusyuk.feature.pilihBanding.PilihBanding
import com.example.ngampusyuk.feature.pilihBanding.PilihBandingViewModel
import com.example.ngampusyuk.feature.pilihJurusan.PilihJurusan
import com.example.ngampusyuk.feature.pilihUniv.PilihUniv
import com.example.ngampusyuk.feature.profile.Profile
import com.example.ngampusyuk.feature.signIn.SignIn
import com.example.ngampusyuk.feature.signUp.SignUp
import com.example.ngampusyuk.feature.splash.SplashScreen
import com.example.ngampusyuk.feature.universitas.UniversitasScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val bandingViewModel : PilihBandingViewModel = viewModel()

    NavHost(navController = navController, startDestination = Screen.Splash.route) {

        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.Banding.route) {
            Banding(navController = navController, bandingViewModel)
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

        composable(route = "${Screen.Berita.route}/{berita_id}",
            arguments = listOf(
                navArgument("berita_id") {
                    type = NavType.StringType
                }
            ))
        {
            val berita_id = it.arguments?.getString("berita_id") ?: ""
            Berita(navController = navController, berita_id)
        }

        composable(route = "${Screen.PilihUniv.route}/{urutan}",
            arguments = listOf(
                navArgument("urutan") {
                    type = NavType.StringType
                }
            )) {
            val urutan = it.arguments?.getString("urutan") ?: ""
            PilihUniv(navController = navController, urutan)
        }

        composable(route = "${Screen.PilihJurusan.route}/{kampus_id}/{urutan}",
            arguments = listOf(
                navArgument("kampus_id") {
                    type = NavType.StringType
                },
                navArgument("urutan") {
                    type = NavType.StringType
                }
            )) {
            val kampus_id = it.arguments?.getString("kampus_id") ?: ""
            val urutan = it.arguments?.getString("urutan") ?: ""
            PilihJurusan(navController = navController, kampus_id, urutan, bandingViewModel)
        }

        composable(route = Screen.PilihBanding.route) {
            PilihBanding(navController = navController, bandingViewModel)
        }

        composable(route = Screen.HasilBanding.route) {
            HasilBanding(navController = navController, bandingViewModel)
        }

        composable(route = Screen.Tes.route) {
            Peluang(navController = navController)
        }
    }
}