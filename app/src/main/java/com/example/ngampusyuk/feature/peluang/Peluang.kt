package com.example.ngampusyuk.feature.peluang

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ngampusyuk.feature.main.components.peluangComponents.AppBar
import com.example.ngampusyuk.feature.main.components.peluangComponents.FilteredList
import com.example.ngampusyuk.feature.main.components.peluangComponents.Input
import com.example.ngampusyuk.feature.main.components.peluangComponents.RekomendasiJurusan
import com.example.ngampusyuk.feature.main.navigation.BottomNavigationBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Peluang(navController: NavController) {
    val viewModel : PeluangViewModel = viewModel()
    Scaffold(
        bottomBar = {
            BottomAppBar(
                tonalElevation = 8.dp,
                containerColor = Color.White,
            ) {
                BottomNavigationBar(navController = navController)
            }
        }) {
        Box(Modifier.background(color = Color.White)) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item{
                    AppBar()
                    Input(viewModel)
                    Text(
                        text = "Rekomendasi", style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(horizontal = 15.dp)
                    )
                }
                if(viewModel.jurusanAllByTes.size == viewModel.kampus.size){
                    items(viewModel.jurusanAllByTes.size) { index ->
                        RekomendasiJurusan(navController, viewModel.kampus[index], viewModel.jurusanAllByTes[index] )
                    }
                }
            }
            FilteredList(viewModel)
        }
    }
}