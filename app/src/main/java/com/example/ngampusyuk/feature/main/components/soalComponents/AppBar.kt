package com.example.ngampusyuk.feature.main.components.soalComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ngampusyuk.feature.main.route.Screen
import com.example.ngampusyuk.ui.theme.CustBlue

@Composable
fun AppBar() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(CustBlue)
        .height(80.dp),
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier = Modifier.fillMaxWidth(0.83f),
            text = "Soal",
            style = TextStyle(color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        )
    }
}