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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ngampusyuk.R

@Composable
fun Kontak(modifier: Modifier = Modifier) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    Column (
        modifier
            .padding(start = 15.dp, end = 15.dp)
            .offset(0.dp, -25.dp)
    ){
        Text(text = "Kontak", style = TextStyle(fontWeight = FontWeight.Medium, fontSize = 16.sp))
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
            Card(
                modifier.width(screenWidth * 0.43f),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                ),
            ) {
                Row(
                    modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                        .padding(15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_telephone),
                        contentDescription = "iconTele",
                        Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(text = "+62-815-15002", style = TextStyle(fontWeight = FontWeight.Medium, fontSize = 12.sp))
                        Text(text = "Nomor Telepon", style = TextStyle(color = Color.Gray, fontSize = 10.sp))
                    }
                }
            }
            Card(
                modifier.width(screenWidth * 0.43f),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                ),
            ) {
                Row(
                    modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                        .padding(15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_mail),
                        contentDescription = "iconTele",
                        Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(text = "sipp@ui.ac.id", style = TextStyle(fontWeight = FontWeight.Medium, fontSize = 12.sp))
                        Text(text = "Email", style = TextStyle(color = Color.Gray, fontSize = 10.sp))
                    }
                }
            }
        }
    }
}