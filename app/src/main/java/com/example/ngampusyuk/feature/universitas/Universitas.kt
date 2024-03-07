package com.example.ngampusyuk.feature.universitas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ngampusyuk.feature.main.components.universitasComponent.AppBar
import com.example.ngampusyuk.feature.main.components.universitasComponent.InformasiJurusan
import com.example.ngampusyuk.feature.main.components.universitasComponent.Kontak
import com.example.ngampusyuk.feature.main.navigation.BottomNavigationBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UniversitasScreen(navController: NavController) {
    Scaffold(
        bottomBar =  {
            BottomAppBar(
                tonalElevation = 8.dp,
                containerColor = Color.White,
            ) {
                BottomNavigationBar(navController = navController)
            }
        }) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                AppBar()
                Kontak()
                InformasiJurusan()
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }

}