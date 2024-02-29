package com.example.ngampusyuk.feature.main.components.homeComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ngampusyuk.R
import com.example.ngampusyuk.ui.theme.CustLightBlue

@Composable
fun InfoKampus(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .padding(
                start = 15.dp,
                end = 15.dp
            )
    ) {
        val screenWidth = LocalConfiguration.current.screenWidthDp.dp
        Text(
            text = "Info Kampus",
            color = Color.Black,
            style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Medium)
        )
        Text(
            text = "Yuk cari tau jalur masuk Universitas kamu sekarang !",
            color = Color.Gray,
            style = TextStyle(fontSize = 12.sp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
            //SNBP
            Card(
                modifier.height(90.dp).width(screenWidth*0.27f),
                elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = CustLightBlue
                )
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier.width(40.dp).height(40.dp),
                            painter = painterResource(id = R.drawable.ic_snbp),
                            contentDescription = "iconSNBP"
                        )
                        Text(
                            text = "SNBP",
                            color = Color.Black,
                            style = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.Bold)
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Seleksi Nasional Berdasarkan Prestasi",
                        color = Color.Gray,
                        style = TextStyle(fontSize = 9.sp)
                    )
                }
            }

            //SNBT
            Card(
                modifier.height(90.dp).width(screenWidth*0.27f),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = CustLightBlue
                )
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier.width(40.dp).height(40.dp),
                            painter = painterResource(id = R.drawable.ic_snbt),
                            contentDescription = "iconSNBT"
                        )
                        Text(
                            text = "SNBT",
                            color = Color.Black,
                            style = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.Bold)
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Seleksi Nasional Berdasarkan Tes",
                        color = Color.Gray,
                        style = TextStyle(fontSize = 9.sp)
                    )
                }
            }

            //Mandiri
            Card(
                modifier.height(90.dp).width(screenWidth*0.27f),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = CustLightBlue
                )
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier.width(40.dp).height(40.dp),
                            painter = painterResource(id = R.drawable.ic_mandiri),
                            contentDescription = "iconMandiri"
                        )
                        Text(
                            text = "Mandiri",
                            color = Color.Black,
                            style = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.Bold)
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Seleksi Mandiri PTN",
                        color = Color.Gray,
                        style = TextStyle(fontSize = 9.sp)
                    )
                }
            }
        }
    }
}