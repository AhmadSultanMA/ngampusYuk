package com.example.ngampusyuk.feature.mandiri

import androidx.compose.foundation.background
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ngampusyuk.feature.main.components.homeComponents.BeritaCard
import com.example.ngampusyuk.feature.main.components.mandiriComponents.AppBar
import com.example.ngampusyuk.feature.main.components.mandiriComponents.KampusCard
import com.example.ngampusyuk.feature.main.route.Screen

@Composable
fun Mandiri(navController: NavController) {
    val viewModel : MandiriViewModel = viewModel()
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    LazyColumn(
        Modifier
            .fillMaxSize()
            .background(color = Color.White))
    {
        item {
            AppBar(navController)
            Spacer(modifier = Modifier.height(10.dp))
            Text(modifier = Modifier.padding(horizontal = 10.dp),text = "Info Mandiri Kampus", style = MaterialTheme.typography.bodyMedium)
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = "Telusuri PTN favoritmu dan dapatkan informasinya !",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
        val chunks = viewModel.kampus.chunked(2)
        items(chunks.size){index ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp) ,horizontalArrangement = Arrangement.SpaceBetween) {
                chunks[index].forEach{item->
                    Box(modifier = Modifier
                        .width(screenWidth * 0.46f)
                        .clickable {
//                            navController.navigate("${Screen.Berita.route}/${item.id}") {
//                                popUpTo(Screen.Home.route) {
//                                    inclusive = true
//                                }
//                            }
                        },){
                        KampusCard(item)
                    }
                }
            }
            if (index < chunks.size - 1) {
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
    
}