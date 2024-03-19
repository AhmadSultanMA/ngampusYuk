package com.example.ngampusyuk.feature.main.components.pilihTOComponents

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.ngampusyuk.R
import com.example.ngampusyuk.feature.main.route.Screen
import com.example.ngampusyuk.model.tryout.TryOutModel

@Composable
fun TryOutCard(navController: NavController, data : TryOutModel, modifier: Modifier = Modifier) {
    Card(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
            .clickable {
                if(data.status.value){
                    navController.navigate(Screen.Nilai.route) {
                        popUpTo(Screen.PilihTO.route) {
                            inclusive = true
                        }
                    }
                }else{
                    navController.navigate("${Screen.Peraturan.route}/${data.id}") {
                        popUpTo(Screen.PilihTO.route) {
                            inclusive = true
                        }
                    }
                }
            },
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Column(Modifier.fillMaxSize()) {
            AsyncImage(model = data.gambar, contentDescription = "gambar", contentScale = ContentScale.Crop)
            Box(
                modifier
                    .background(color = Color.White)
                    .padding(horizontal = 15.dp, vertical = 10.dp)){
                Row(
                    Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(text = data.judul, style = MaterialTheme.typography.labelMedium)
                        Spacer(modifier = Modifier.height(5.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(painter = painterResource(id = R.drawable.ic_calendar), contentDescription = "icon", Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "${data.tanggal_start} - ${data.tanggal_end}",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.Gray
                            )
                        }
                    }
                    if (data.status.value){
                        Card(
                            shape = RoundedCornerShape(15.dp),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 8.dp
                            )
                        ) {
                            Row(
                                modifier
                                    .background(color = Color.White, shape = RoundedCornerShape(50))
                                    .padding(horizontal = 8.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = "Selesai", style = MaterialTheme.typography.bodySmall)
                                Spacer(modifier = Modifier.width(3.dp))
                                Image(painter = painterResource(id = R.drawable.ic_selesai), contentDescription = "icon", Modifier.size(18.dp))
                            }
                        }
                    }else{
                        Icon(
                            Icons.Default.KeyboardArrowRight,
                            contentDescription = "icon",
                            tint = Color.Black
                        )
                    }
                }
            }
        }
    }
}