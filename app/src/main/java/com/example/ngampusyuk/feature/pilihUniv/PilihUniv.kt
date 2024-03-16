package com.example.ngampusyuk.feature.pilihUniv

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.ngampusyuk.R
import com.example.ngampusyuk.feature.main.components.homeComponents.BeritaCard
import com.example.ngampusyuk.feature.main.route.Screen
import com.example.ngampusyuk.ui.theme.CustBlue

@Composable
fun PilihUniv(navController: NavController, urutan : String, modifier : Modifier = Modifier) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val viewModel : PilihUnivViewModel = viewModel()
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(
            Brush.verticalGradient(
                colors = listOf(
                    CustBlue,
                    Color.White
                ),
                startY = 200f
            )
        )
        .padding(15.dp)
    ){
        item {
            Box(
                modifier
                    .fillMaxWidth()
                    .background(color = Color.White, shape = RoundedCornerShape(30))
                    .padding(vertical = 8.dp)
            ){
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = {
                        navController.navigate(Screen.PilihBanding.route) {
                            popUpTo(Screen.PilihUniv.route) {
                                inclusive = true
                            }
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    if (urutan == "satu"){
                        Text(text = "Pilih Universitas Pertama", style = MaterialTheme.typography.labelLarge)
                    }else{
                        Text(text = "Pilih Universitas Kedua", style = MaterialTheme.typography.labelLarge)
                    }
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
        }
        val chunks = viewModel.kampus.chunked(2)
        items(chunks.size){index ->
            Row(Modifier.fillMaxWidth() ,horizontalArrangement = Arrangement.SpaceBetween) {
                chunks[index].forEach{item->
                    Box(modifier = Modifier
                        .width(screenWidth * 0.44f)
                        .clickable {
                            navController.navigate("${Screen.PilihJurusan.route}/${item.id}/${urutan}") {
                                popUpTo(Screen.PilihUniv.route) {
                                    inclusive = true
                                }
                            }
                        }
                        ){
                        UnivCard(
                            item.gambar_gedung,
                            item.singkatan
                        )
                    }
                }
            }
            if (index < chunks.size - 1) {
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
fun UnivCard(
    gambar : String,
    title : String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Box(modifier.height(180.dp)){
            AsyncImage(modifier = Modifier.fillMaxSize(), model = gambar, contentDescription = "gambar_gedung", contentScale = ContentScale.Crop)
            Box(
                modifier
                    .fillMaxSize()
                    .padding(15.dp),
                contentAlignment = Alignment.TopEnd
            ){
                Text(text = title, style = MaterialTheme.typography.titleSmall)
            }
        }
    }
}