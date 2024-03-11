package com.example.ngampusyuk.feature.main.components.peluangComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ngampusyuk.model.jurusan.JurusanModel
import com.example.ngampusyuk.model.kampus.KampusModel

@Composable
fun RekomendasiJurusan(navController: NavController, kampus: KampusModel, jurusan: JurusanModel, modifier: Modifier = Modifier) {
    Column {
        Text(text = kampus.nama)
        Text(text = jurusan.nama_jurusan)
        Text(text = jurusan.snbt.toString())
    }
    Spacer(modifier = Modifier.height(10.dp))
}