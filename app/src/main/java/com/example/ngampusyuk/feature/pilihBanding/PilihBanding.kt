package com.example.ngampusyuk.feature.pilihBanding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ngampusyuk.R
import com.example.ngampusyuk.ui.theme.CustBlue

@Composable
fun PilihBanding(navController: NavController, modifier : Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier
                .background(Color.White)
                .padding(15.dp))
        {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Tentukan Pilihan", style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(0.8f),
                    text = "Pilih universitas dan program studi yang kamu inginkan",
                    style = MaterialTheme.typography.labelLarge, textAlign = TextAlign.Center
                )
            }
        }
        Column(
            Modifier
                .fillMaxSize()
                .background(CustBlue),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Box(
                modifier
                    .fillMaxWidth(0.5f)
                    .height(200.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(20)),
                contentAlignment = Alignment.Center
            ){
                Text(text = "+ Pilihan Pertama", style = MaterialTheme.typography.titleSmall)
            }
            Image(painter = painterResource(id = R.drawable.vs), contentDescription = "vs", Modifier.size(108.dp))
            Box(
                modifier
                    .fillMaxWidth(0.5f)
                    .height(200.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(20)),
                contentAlignment = Alignment.Center
            ){
                Text(text = "+ Pilihan Kedua", style = MaterialTheme.typography.titleSmall)
            }
        }
    }
}