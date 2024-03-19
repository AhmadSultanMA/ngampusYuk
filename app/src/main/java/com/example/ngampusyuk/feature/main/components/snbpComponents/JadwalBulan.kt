package com.example.ngampusyuk.feature.main.components.snbpComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
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
import com.example.ngampusyuk.ui.theme.Aksen06
import com.example.ngampusyuk.ui.theme.CustBlue
import com.example.ngampusyuk.ui.theme.Warning01

@Composable
fun JadwalBulan() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)) {
        Text(text = "Jadwal Bulan ini", style = MaterialTheme.typography.labelSmall)
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "Siapkah kamu untuk membuka gerbang menuju perguruan tinggi impian?",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Aksen06.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(
                        topStartPercent = 20,
                        bottomStartPercent = 20,
                        bottomEndPercent = 20
                    )
                )
                .padding(10.dp)
        ){
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(20)),
                    contentAlignment = Alignment.Center
                )
                {
                    Image(painter = painterResource(id = R.drawable.ic_pencil), contentDescription = "icon", Modifier.size(24.dp))
                }
                Column {
                    Text(text = "Pendaftaran", style = MaterialTheme.typography.labelSmall)
                    Text(
                        text = "Pembuatan akun SNPMB",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Spacer(modifier = Modifier.width(5.dp))
                Icon(Icons.Filled.MoreVert, contentDescription = "Menu", Modifier.fillMaxHeight())
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Warning01,
                    shape = RoundedCornerShape(
                        topStartPercent = 20,
                        bottomStartPercent = 20,
                        bottomEndPercent = 20
                    )
                )
                .padding(10.dp)
        ){
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(20)),
                    contentAlignment = Alignment.Center
                )
                {
                    Image(painter = painterResource(id = R.drawable.ic_computer), contentDescription = "icon", Modifier.size(24.dp))
                }
                Column {
                    Text(text = "Input Nilai", style = MaterialTheme.typography.labelSmall)
                    Text(
                        text = "Memasukkan Nilai Rapor",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White
                    )
                    Text(
                        text = "Semester 1 - 5",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Spacer(modifier = Modifier.width(5.dp))
                Icon(Icons.Filled.MoreVert, contentDescription = "Menu", Modifier.fillMaxHeight())
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = CustBlue.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(
                        topStartPercent = 20,
                        bottomStartPercent = 20,
                        bottomEndPercent = 20
                    )
                )
                .padding(10.dp)
        ){
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(20)),
                    contentAlignment = Alignment.Center
                )
                {
                    Image(painter = painterResource(id = R.drawable.ic_book), contentDescription = "icon", Modifier.size(24.dp))
                }
                Column {
                    Text(text = "Pengumuman", style = MaterialTheme.typography.labelSmall)
                    Text(
                        text = "Pengumuman Eligible",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Spacer(modifier = Modifier.width(5.dp))
                Icon(Icons.Filled.MoreVert, contentDescription = "Menu", Modifier.fillMaxHeight())
            }
        }
    }
}