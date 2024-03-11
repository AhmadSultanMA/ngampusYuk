package com.example.ngampusyuk.feature.home

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ngampusyuk.feature.main.components.homeComponents.AppBar
import com.example.ngampusyuk.feature.main.components.homeComponents.BeritaCard
import com.example.ngampusyuk.feature.main.components.homeComponents.FilterList
import com.example.ngampusyuk.feature.main.components.homeComponents.Fitur
import com.example.ngampusyuk.feature.main.components.homeComponents.Iklan
import com.example.ngampusyuk.feature.main.components.homeComponents.InfoKampus
import com.example.ngampusyuk.feature.main.components.homeComponents.RekomendasiKampus
import com.example.ngampusyuk.feature.main.navigation.BottomNavigationBar
import com.example.ngampusyuk.feature.main.route.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val viewModel : HomeViewModel = viewModel()
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
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
                    Text(
                        text = "Berita Kampus",
                        color = Color.Black,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(horizontal = 15.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
                val chunks = viewModel.berita.chunked(2)
                items(chunks.size){index ->
                    Row(Modifier.fillMaxWidth().padding(horizontal = 15.dp) ,horizontalArrangement = Arrangement.SpaceBetween) {
                        chunks[index].forEach{item->
                           Box(modifier = Modifier
                               .width(screenWidth * 0.44f)
                               .clickable {
                               navController.navigate("${Screen.Berita.route}/${item.id}") {
                                   popUpTo(Screen.Home.route) {
                                       inclusive = true
                                   }
                               }
                           },){
                               BeritaCard(
                                   item.gambar_berita,
                                   "beritaGambar",
                                   item.judul_berita
                               )
                           }
                        }
                    }
                    if (index < chunks.size - 1) {
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(100.dp))
                }
            }
            FilterList(viewModel.filteredList.value, navController)
        }

    }

}