package com.example.ngampusyuk.feature.main.components.peluangComponents

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.ngampusyuk.feature.main.route.Screen
import com.example.ngampusyuk.model.jurusan.JurusanModel
import com.example.ngampusyuk.model.kampus.KampusModel

@Composable
fun RekomendasiJurusan(navController: NavController, kampus: KampusModel, jurusan: JurusanModel, modifier: Modifier = Modifier) {
    Box(modifier
        .height(120.dp)
        .fillMaxWidth()
        .padding(horizontal = 15.dp, vertical = 5.dp)
        .clip(shape = RoundedCornerShape(10))
        .clickable {
            navController.navigate("${Screen.Universitas.route}/${kampus.id}") {
                popUpTo(Screen.Tes.route) {
                    inclusive = true
                }
            }
        }
    ){
        AsyncImage(
            model = kampus?.gambar_appbar ?: "",
            contentDescription = "gambar_appbar",
            contentScale = ContentScale.Crop,
            )
        Box(modifier
            .fillMaxSize()
            .background(color = Color.White.copy(alpha = 0.6f))
        )
        Box(
            modifier
                .fillMaxSize()
                .padding(15.dp)){
            Row(modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column {
                    Text(text = kampus.nama, style = MaterialTheme.typography.labelLarge)
                    Text(text = jurusan.nama_jurusan, style = MaterialTheme.typography.labelSmall)
                }
                Text(text = jurusan.snbt.toString(), style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp))
            }
        }
    }
}