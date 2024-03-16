package com.example.ngampusyuk.feature.main.route

sealed class Screen(val route: String){
    object Splash : Screen("splash")
    object Home : Screen("home")
    object Tes : Screen("tes")
    object Banding : Screen("banding")
    object Profil : Screen("profil")
    object SignIn : Screen("signin")
    object SignUp : Screen("signup")
    object EditProfile : Screen("editprofile")
    object Universitas : Screen("universitas")
    object Berita : Screen("berita")
    object PilihBanding : Screen("pilihbanding")
    object PilihUniv : Screen("pilihuniv")
    object PilihJurusan : Screen("pilihjurusan")
    object HasilBanding : Screen("hasilbanding")

}