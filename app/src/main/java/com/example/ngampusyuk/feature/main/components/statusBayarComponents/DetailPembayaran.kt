package com.example.ngampusyuk.feature.main.components.statusBayarComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.example.ngampusyuk.ui.theme.Aksen02

@Composable
fun DetailPembayaran(nama: String?, modifier: Modifier = Modifier) {
    Card(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Box(
            modifier
                .fillMaxWidth()
                .background(color = Color.White)
        ){
            Column(modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    contentAlignment = Alignment.CenterStart
                ){
                    Text(text = "Rp. 5000", style = MaterialTheme.typography.titleLarge, color = Aksen02)
                }
                Box(
                    modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(color = Color.Black)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Nama Pemesan:", style = MaterialTheme.typography.titleSmall)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = nama ?: "", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Total Dibayar:", style = MaterialTheme.typography.titleSmall)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Rp 5.000", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}