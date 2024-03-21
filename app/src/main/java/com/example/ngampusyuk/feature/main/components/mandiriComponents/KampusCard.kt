package com.example.ngampusyuk.feature.main.components.mandiriComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ngampusyuk.model.kampus.KampusModel

@Composable
fun KampusCard(kampus: KampusModel?, modifier: Modifier = Modifier) {
    Card(
        modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Column(Modifier.fillMaxWidth()) {
            AsyncImage(modifier = Modifier.fillMaxWidth(),model = kampus?.gambar_appbar, contentDescription = "gambar")
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
            ){
                Row(Modifier.padding(5.dp), verticalAlignment = Alignment.CenterVertically) {
                    AsyncImage(model = kampus?.logo, contentDescription = "logo", modifier = Modifier.size(24.dp))
                    Spacer(modifier = Modifier.width(5.dp))
                    Column(Modifier.fillMaxWidth()) {
                        Text(text = kampus?.nama ?: "", style = MaterialTheme.typography.bodySmall)
                        Text(text = "Cek jalur mandiri di UI sekarang!", style = MaterialTheme.typography.bodySmall, color = Color.Gray)
                    }
                }
            }
        }
    }
}