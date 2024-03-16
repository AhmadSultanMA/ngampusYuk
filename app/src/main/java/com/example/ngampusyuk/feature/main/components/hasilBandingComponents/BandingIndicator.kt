package com.example.ngampusyuk.feature.main.components.hasilBandingComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ngampusyuk.ui.theme.CustDarkIndicator
import com.example.ngampusyuk.ui.theme.CustGray
import com.example.ngampusyuk.ui.theme.CustYellow

@Composable
fun BandingIndicator(jurusan1 : Long, jurusan2 : Long, painter: Painter, info : String) {
    val percent1 = 100-jurusan1.toFloat()
    val percent2 = jurusan2.toFloat()

    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
        Box(modifier = Modifier
            .height(40.dp)
            .width(110.dp)
        ){
            LinearProgressIndicator(
                progress = percent1/100f,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(topStartPercent = 20, bottomStartPercent = 20)),
                color = Color.Gray,
                trackColor = CustYellow
            )
            Text(
                text = "${jurusan1.toInt()}%",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(8.dp),
                textAlign = TextAlign.Center
            )
        }
        Column(Modifier.width(120.dp),verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painter, contentDescription = "logo",Modifier.size(24.dp))
            Text(text = info, style = MaterialTheme.typography.bodySmall)
        }
        Box(modifier = Modifier
            .height(40.dp)
            .width(110.dp)
        ){
            LinearProgressIndicator(
                progress = percent2/100f,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(topEndPercent = 20, bottomEndPercent = 20)),
                color = CustDarkIndicator,
                trackColor = Color.Gray
            )
            Text(
                text = "${jurusan2.toInt()}%",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(8.dp),
                textAlign = TextAlign.Center
            )
        }
    }

}