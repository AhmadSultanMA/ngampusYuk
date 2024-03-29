package com.example.ngampusyuk.feature.universitas

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ngampusyuk.feature.main.components.universitasComponents.AppBar
import com.example.ngampusyuk.feature.main.components.universitasComponents.InformasiJurusan
import com.example.ngampusyuk.feature.main.components.universitasComponents.Kontak
import com.example.ngampusyuk.feature.main.navigation.BottomNavigationBar
import com.example.ngampusyuk.feature.main.route.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UniversitasScreen(navController: NavController, kampus_id : String) {
    val viewModel : UniversitasViewModel = viewModel()
    
    LaunchedEffect(key1 = true){
        viewModel.getAllJurusan(kampus_id)
        viewModel.getKampusById(kampus_id)
    }

    Scaffold(
        bottomBar =  {
            BottomAppBar(
                tonalElevation = 8.dp,
                containerColor = Color.White,
            ) {
                BottomNavigationBar(navController = navController)
            }
        }) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)) {
            item {
                AppBar(viewModel.kampus.value, navController)
                Kontak(viewModel.kampus.value)
                InformasiJurusan(viewModel.jurusan)
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }

}