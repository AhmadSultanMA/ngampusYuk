package com.example.ngampusyuk.feature.main.components.homeComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ngampusyuk.R
import com.example.ngampusyuk.feature.main.route.Screen
import com.example.ngampusyuk.model.kampus.KampusModel
import com.example.ngampusyuk.ui.theme.CustDarkGreen

@Composable
fun RekomendasiKampus(navController: NavController, kampus : KampusModel, modifier: Modifier = Modifier) {
    Column(
        modifier.padding(start = 15.dp, end = 15.dp)
    ) {
        Text(
            text = "Rekomendasi Kampus",
            color = Color.Black,
            style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Medium),
        )
        Text(
            text = "Top 10 Universitas terbaik menurut Kemendikbud",
            color = Color.Gray,
            style = TextStyle(fontSize = 12.sp)
        )
        Spacer(modifier.height(10.dp))
        KampusBox(navController, kampus)
        Spacer(modifier.height(10.dp))
        }
}

@Composable
fun KampusBox(navController: NavController, kampus: KampusModel ,modifier: Modifier = Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        modifier = Modifier
            .clickable {
                navController.navigate(Screen.Universitas.route) {
                    popUpTo(Screen.Home.route) {
                        inclusive = true
                    }
                }
            },
    ) {
        Row (
            modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color.White)
                .padding(12.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row {
                Image(
                    modifier = Modifier.width((0.4f * 100).dp),
                    painter = painterResource(id = R.drawable.logo_ui),
                    contentDescription = "kampusUI"
                )
                Spacer(modifier = Modifier.width(15.dp))
                Column {
                    Text(
                        text = kampus.nama,
                        style = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.Medium)
                    )
                    Text(
                        text = kampus.alamat,
                        style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.Light)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Akreditasi : ${kampus.akreditasi}",
                            Modifier
                                .background(
                                    color = CustDarkGreen,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .padding(vertical = 2.dp, horizontal = 16.dp),
                            style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "PTN - BH",
                            Modifier
                                .background(
                                    color = CustDarkGreen,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .padding(vertical = 2.dp, horizontal = 16.dp),
                            style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                        )
                    }
                }
            }
            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = "Love Icon",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}