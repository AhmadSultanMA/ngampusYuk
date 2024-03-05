package com.example.ngampusyuk.feature.main.components.profileComponent

import com.example.ngampusyuk.R

sealed class ProfileItem(
    val icon: Int,
    val label: String
){
    object Pengaturan: ProfileItem(icon = R.drawable.ic_pengaturan, label = "Pengaturan")
    object Info: ProfileItem(icon = R.drawable.ic_info, label = "Info Aplikasi")
    object Pusat: ProfileItem(icon = R.drawable.ic_pusat, label = "Pusat Bantuan")
    object Tentang: ProfileItem(icon = R.drawable.ic_tentang, label = "Tentang Kami")
    object Hapus: ProfileItem(icon = R.drawable.ic_hapus, label = "Hapus Akun")
    object Keluar: ProfileItem(icon = R.drawable.ic_keluar, label = "Keluar")
}