package com.example.ngampusyuk.feature.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ngampusyuk.feature.main.components.homeComponents.AppBar
import com.example.ngampusyuk.feature.main.components.homeComponents.Berita
import com.example.ngampusyuk.feature.main.components.homeComponents.FilterList
import com.example.ngampusyuk.feature.main.components.homeComponents.Fitur
import com.example.ngampusyuk.feature.main.components.homeComponents.Iklan
import com.example.ngampusyuk.feature.main.components.homeComponents.InfoKampus
import com.example.ngampusyuk.feature.main.components.homeComponents.RekomendasiKampus
import com.example.ngampusyuk.feature.main.navigation.BottomNavigationBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val viewModel : HomeViewModel = viewModel()

    Scaffold(
        bottomBar =  {
        BottomAppBar(
            tonalElevation = 8.dp,
            containerColor = Color.White,
        ) {
            BottomNavigationBar(navController = navController)
        }
    }) {
        Box {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    AppBar(name = "irza", viewModel.kampus, viewModel, modifier = Modifier.height(190.dp))
                    Spacer(modifier = Modifier.height(10.dp))
                    Iklan()
                    Spacer(modifier = Modifier.height(10.dp))
                    InfoKampus()
                    Spacer(modifier = Modifier.height(10.dp))
                    Fitur()
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Rekomendasi Kampus",
                        color = Color.Black,
                        style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Medium),
                        modifier = Modifier.padding(start = 15.dp, end = 15.dp)
                    )
                    Text(
                        text = "Top 10 Universitas terbaik menurut Kemendikbud",
                        color = Color.Gray,
                        style = TextStyle(fontSize = 12.sp),
                        modifier = Modifier.padding(start = 15.dp, end = 15.dp)
                    )
                    viewModel.kampus.forEach{ kampus ->
                        RekomendasiKampus(navController, kampus)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Berita(navController)
                    Spacer(modifier = Modifier.height(100.dp))
                }
            }
            FilterList(viewModel.filteredList.value, navController)
        }

    }

}