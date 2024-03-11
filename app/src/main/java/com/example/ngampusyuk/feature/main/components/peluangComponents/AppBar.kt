package com.example.ngampusyuk.feature.main.components.peluangComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
    Box(modifier =
    Modifier
        .fillMaxWidth()
        .height(100.dp)
        .background(color = CustBlue)
        .padding(15.dp),
        contentAlignment = Alignment.BottomCenter)
    {
        Text(text = "Cek Peluangmu!", style = MaterialTheme.typography.headlineSmall, color = Color.White)
    }
}