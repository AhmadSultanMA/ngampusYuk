package com.example.ngampusyuk.feature.main.components.hasilTOComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.ngampusyuk.ui.theme.Warning01

@Composable
fun CardNilai(jawabBenar: Long, totalSoal: Long, nama: String?) {
    Card(
        Modifier
            .padding(horizontal = 15.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(20.dp),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text(text = nama ?: "", style = MaterialTheme.typography.labelLarge)
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Jawaban Benar", style = MaterialTheme.typography.labelLarge)
                Text(text = "${jawabBenar}/${totalSoal}", style = MaterialTheme.typography.labelLarge)
            }
            Box(modifier = Modifier
                .background(color = Warning01, shape = RoundedCornerShape(20))
                .padding(15.dp))
            {
                Column {
                    Text(text = "780", style = MaterialTheme.typography.displaySmall)
                    Text(text = "Skor Rata-Rata", style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}