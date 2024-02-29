package com.example.ngampusyuk.feature.main.components.homeComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RekomendasiKampus(modifier: Modifier = Modifier) {
    Column(
        modifier.padding(start = 25.dp, end = 25.dp)
    ) {
        Text(
            text = "Rekomendasi Kampus",
            color = Color.Black,
            style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Medium),
            modifier = Modifier.padding(start = 25.dp, end = 25.dp)

        )
        Text(
            text = "Top 10 Universitas terbaik menurut Kemendikbud",
            color = Color.Gray,
            style = TextStyle(fontSize = 12.sp),
            modifier = Modifier.padding(start = 25.dp, end = 25.dp)
        )
    }
}