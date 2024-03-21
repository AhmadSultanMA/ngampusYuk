package com.example.ngampusyuk.feature.main.components.snbtComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ngampusyuk.R

@Composable
fun SnbtCard(gambar: String, judul: String, subJudul: String, modifier: Modifier = Modifier) {
    Card(
        modifier.fillMaxWidth().height(200.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ){
        Box(
            modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(10))){
            Column(Modifier.fillMaxWidth()) {
                AsyncImage(model = gambar, contentDescription = "gambar", contentScale = ContentScale.Crop)
                Box(
                    modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                        .padding(horizontal = 10.dp, vertical = 5.dp))
                {
                    Column {
                        Text(text = judul, style = MaterialTheme.typography.bodyLarge)
                        Text(text = subJudul, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
                    }
                }
            }
        }
    }
}