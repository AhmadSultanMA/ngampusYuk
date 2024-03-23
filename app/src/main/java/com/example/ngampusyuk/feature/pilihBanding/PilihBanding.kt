package com.example.ngampusyuk.feature.pilihBanding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.ngampusyuk.R
import com.example.ngampusyuk.feature.main.route.Screen
import com.example.ngampusyuk.ui.theme.CustBlue
import com.example.ngampusyuk.ui.theme.CustDarkBlue

@Composable
fun PilihBanding(navController: NavController, viewModel: PilihBandingViewModel,modifier : Modifier = Modifier) {

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier
                .background(Color.White)
                .padding(15.dp))
        {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Tentukan Pilihan", style = MaterialTheme.typography.headlineMedium)
                Text(
                    modifier = Modifier.fillMaxWidth(0.8f),
                    text = "Pilih universitas dan program studi yang kamu inginkan",
                    style = MaterialTheme.typography.labelLarge, textAlign = TextAlign.Center
                )
            }
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(topEndPercent = 10, topStartPercent = 10))
            .background(color = CustBlue)
        ){
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(25.dp))
                Box(
                    modifier
                        .fillMaxWidth(0.5f)
                        .height(180.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(20))
                        .clickable {
                            navController.navigate("${Screen.PilihUniv.route}/satu") {
                                popUpTo(Screen.PilihBanding.route) {
                                    inclusive = true
                                }
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    if (viewModel.jurusan1.value == null) {
                        Text(
                            text = "+ Pilihan Pertama",
                            style = MaterialTheme.typography.titleSmall
                        )
                    } else {
                        Column(
                            modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            AsyncImage(
                                model = viewModel.kampus1.value?.logo ?: "",
                                contentDescription = "logo"
                            )
                            Text(
                                text = viewModel.jurusan1.value?.nama_jurusan ?: "",
                                style = MaterialTheme.typography.bodySmall
                            )
                            Text(
                                text = viewModel.kampus1.value?.nama ?: "",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
                Image(
                    painter = painterResource(id = R.drawable.vs),
                    contentDescription = "vs",
                    Modifier.size(108.dp)
                )
                Box(
                    modifier
                        .fillMaxWidth(0.5f)
                        .height(180.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(20))
                        .clickable {
                            navController.navigate("${Screen.PilihUniv.route}/dua") {
                                popUpTo(Screen.PilihBanding.route) {
                                    inclusive = true
                                }
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    if (viewModel.jurusan2.value == null) {
                        Text(text = "+ Pilihan Kedua", style = MaterialTheme.typography.titleSmall)
                    } else {
                        Column(
                            modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            AsyncImage(
                                model = viewModel.kampus2.value?.logo ?: "",
                                contentDescription = "logo"
                            )
                            Text(
                                text = viewModel.jurusan2.value?.nama_jurusan ?: "",
                                style = MaterialTheme.typography.bodySmall
                            )
                            Text(
                                text = viewModel.kampus2.value?.nama ?: "",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
                if (viewModel.jurusan2.value != null && viewModel.jurusan1 != null) {
                    Spacer(modifier = Modifier.height(40.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = CustDarkBlue, shape = RoundedCornerShape(20.dp))
                            .clickable {
                                navController.navigate(Screen.HasilBanding.route) {
                                    popUpTo(Screen.PilihBanding.route) {
                                        inclusive = true
                                    }
                                }
                            },
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            modifier = Modifier.padding(vertical = 10.dp),
                            text = "Mulai Sekarang",
                            style = TextStyle(
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 19.sp
                            )
                        )
                    }
                }
            }
        }
    }
}