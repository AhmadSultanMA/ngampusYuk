package com.example.ngampusyuk.feature.main.components.hasilTOComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun RincianNilai(paint: Painter, text: String, nilai: Long, color: Color) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    Box(
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .fillMaxWidth()
            .background(color = color, shape = RoundedCornerShape(20))
    ){
        Row(
            Modifier.padding(start = 5.dp, end = 20.dp, top = 5.dp, bottom = 5.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(painter = paint, contentDescription = "ic", Modifier.size(60.dp))
            Text(modifier = Modifier.width(screenWidth * 0.5f),text = text, style = MaterialTheme.typography.labelLarge, color = Color.White, textAlign = TextAlign.Start)
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = nilai.toString(), style = MaterialTheme.typography.labelLarge, color = Color.White)

        }
    }
}