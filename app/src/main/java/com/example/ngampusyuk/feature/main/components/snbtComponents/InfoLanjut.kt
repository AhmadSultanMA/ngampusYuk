package com.example.ngampusyuk.feature.main.components.snbtComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.ngampusyuk.ui.theme.Secondary01

@Composable
fun InfoLanjut() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = Secondary01)
        .padding(horizontal = 15.dp, vertical = 10.dp)
    ){
        Column {
            Text(text = "Info Lanjut SNBT", style = MaterialTheme.typography.labelSmall)
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "Yuk cari tau jalur masuk Universitas kamu sekarang !",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(modifier = Modifier
                .width(220.dp)
                .background(color = Color.White, shape = RoundedCornerShape(10))
            )
            {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(10.dp), horizontalAlignment = Alignment.Start) {
                    Text(text = "Info Lengkap", style = MaterialTheme.typography.bodyMedium)
                    Row(Modifier.fillMaxWidth()) {
                        Text(text = "1. ", style = MaterialTheme.typography.bodySmall, color = Color.Gray)
                        Text(text = "Anda dapat membuat akun SNPMB di portal resmi SNPMB (https://portal-snpmb.bppp.kemdikbud.go.id/).", style = MaterialTheme.typography.bodySmall, color = Color.Gray)
                    }
                }
            }
        }
    }
}