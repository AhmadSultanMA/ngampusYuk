package com.example.ngampusyuk.feature.main.components.snbtComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ngampusyuk.R
import com.example.ngampusyuk.ui.theme.Secondary01

@Composable
fun SemuaJadwal(selectedItem: MutableState<String>) {
    Column(
        Modifier
            .fillMaxWidth()
            .background(color = Secondary01)
    )
    {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Jadwal SNBT", style = MaterialTheme.typography.labelSmall)
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Catat tanggal penting sekarang!",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
            Box(
                modifier = Modifier
                    .background(color = Color.White, shape = RoundedCornerShape(20))
                    .clickable { selectedItem.value = "Jadwal" },
                contentAlignment = Alignment.Center
            ){
                Text(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),text = "Cek Sekarang", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Image(painter = painterResource(id = R.drawable.jadwal_snbp), contentDescription = "gambar", Modifier.size(168.dp))
            Image(painter = painterResource(id = R.drawable.snbt_calendar), contentDescription = "calendar", Modifier.size(168.dp))
            Spacer(modifier = Modifier.width(5.dp))
        }
    }
}