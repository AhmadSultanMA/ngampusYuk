package com.example.ngampusyuk.feature.main.components.statusBayarComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.ngampusyuk.ui.theme.CustBlue

@Composable
fun AppBar() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)
        .height(60.dp),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Status Pembayaran",
            style = MaterialTheme.typography.labelLarge, color = Color.Black
        )
    }
}