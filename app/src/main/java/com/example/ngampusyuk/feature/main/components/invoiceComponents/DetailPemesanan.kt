package com.example.ngampusyuk.feature.main.components.invoiceComponents

import androidx.compose.foundation.background
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ngampusyuk.ui.theme.Secondary01

@Composable
fun DetailPemesanan(modifier : Modifier = Modifier) {
    Card(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .background(color = Secondary01)
                .padding(15.dp)
        ) {
            Text(text = "Detail Pemesanan", style = MaterialTheme.typography.titleSmall)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Nama Produk : ", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Paket Premium 1 Bulan", style = MaterialTheme.typography.labelSmall)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Deskripsi : ", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = " Paket Premium 1 Bulan free access pembahasan seluruh paket. Berlaku hingga 16 April 2024.", style = MaterialTheme.typography.labelSmall)

        }
    }
}