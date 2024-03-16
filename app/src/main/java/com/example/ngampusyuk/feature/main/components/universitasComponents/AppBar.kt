package com.example.ngampusyuk.feature.main.components.universitasComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.ngampusyuk.R
import com.example.ngampusyuk.model.kampus.KampusModel

@Composable
fun AppBar(kampus : KampusModel?, modifier: Modifier = Modifier) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    Column(modifier.fillMaxWidth()) {
        AsyncImage(model = kampus?.gambar_appbar ?: "", contentDescription = "gambar_appbar", contentScale = ContentScale.Crop, modifier = Modifier.height(120.dp))
        Column(
            modifier
                .padding(start = 15.dp, end = 15.dp)
                .offset(0.dp, -35.dp)
        ) {
            Card(
                modifier
                    .fillMaxWidth(),

                elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
                 ),)
            {
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
                    .padding(10.dp)) {
                    AsyncImage(model = kampus?.logo ?: "", contentDescription = "logo", Modifier.size(48.dp))
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(text = kampus?.nama ?: "",
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 22.sp,
                                color = Color.Black
                            )
                        )
                        Text(text = kampus?.email_kampus ?: "",
                            style = TextStyle(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                color = Color.Gray
                            )
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
                Card(
                    modifier.width(screenWidth*0.27f),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 8.dp
                    ),
                ) {
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                        .padding(10.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Jenis",
                            color = Color.Black,
                            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium)
                        )
                        Text(
                            text = kampus?.jenis ?: "",
                            color = Color.Gray,
                            style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium)
                        )
                    }
                }

                Card(
                    modifier.width(screenWidth*0.27f),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 8.dp
                    ),
                ) {
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                        .padding(10.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Status",
                            color = Color.Black,
                            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium)
                        )
                        Text(
                            text = kampus?.status ?: "",
                            color = Color.Gray,
                            style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium)
                        )
                    }
                }

                Card(
                    modifier.width(screenWidth*0.27f),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 8.dp
                    ),
                ) {
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                        .padding(10.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Akreditasi",
                            color = Color.Black,
                            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium)
                        )
                        Text(
                            text = kampus?.akreditasi ?: "",
                            color = Color.Gray,
                            style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium)
                        )
                    }
                }

            }
        }
    }
}