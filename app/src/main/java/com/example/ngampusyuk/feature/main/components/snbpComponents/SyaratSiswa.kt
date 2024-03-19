package com.example.ngampusyuk.feature.main.components.snbpComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ngampusyuk.R

@Composable
fun SyaratSiswa() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
    )
    {
        Box(modifier = Modifier.fillMaxWidth().clip(shape = RoundedCornerShape(20)), contentAlignment = Alignment.BottomCenter){
            Image(modifier = Modifier.fillMaxWidth(), painter = painterResource(id = R.drawable.syarat_siswa), contentDescription = "gambar")
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(color = Color.Black.copy(alpha = 0.5f)), contentAlignment = Alignment.CenterStart
            )
            {
                Row {
                    Spacer(modifier = Modifier.width(30.dp))
                    Text(text = "Persyaratan Siswa", style = MaterialTheme.typography.bodyMedium, color = Color.White)
                }
            }
        }
    }
}