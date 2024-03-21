package com.example.ngampusyuk.feature.hasilTO

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
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ngampusyuk.feature.main.components.hasilTOComponents.AppBar
import com.example.ngampusyuk.feature.main.components.hasilTOComponents.CardNilai
import com.example.ngampusyuk.feature.main.route.Screen
import com.example.ngampusyuk.ui.theme.CustDarkBlue

@Composable
fun HasilTO(navController: NavController) {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .background(color = Color.White)){
        item {
            AppBar(navController)
            Spacer(modifier = Modifier.height(10.dp))
            CardNilai()
            Spacer(modifier = Modifier.height(20.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate(Screen.Tes.route) {
                        popUpTo(Screen.HasilTO.route) {
                            inclusive = true
                        }
                    }
                },
                contentAlignment = Alignment.Center
            ){
                Card(
                    shape = RoundedCornerShape(50.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    )
                ) {
                    Row(
                        Modifier
                            .background(color = Color.White)
                            .padding(horizontal = 24.dp)
                        ,verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Cek Peluang", style = MaterialTheme.typography.headlineSmall)
                        Icon(Icons.Default.KeyboardArrowRight, contentDescription = "icon")
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(modifier = Modifier.padding(horizontal = 15.dp),
                text = "Cek peluang masuk universitas impian dengan skor kamu!",
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(30.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = CustDarkBlue, shape = RoundedCornerShape(20.dp))
                    .clickable {

                    },
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 10.dp),
                    text = "Lihat Penjelasan",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}