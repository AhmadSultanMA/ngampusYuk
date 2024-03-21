package com.example.ngampusyuk.feature.main.components.snbpComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.ngampusyuk.ui.theme.Secondary01
import com.example.ngampusyuk.ui.theme.Warning01

@Composable
fun SyaratSekolah() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
    )
    {
        Box(modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(20)), contentAlignment = Alignment.BottomCenter)
        {
            Image(modifier = Modifier.fillMaxWidth(), painter = painterResource(id = R.drawable.syarat_sekolah), contentDescription = "gambar")
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(color = Color.Black.copy(alpha = 0.5f)), contentAlignment = Alignment.CenterStart
            )
            {
                Row {
                    Spacer(modifier = Modifier.width(30.dp))
                    Text(text = "Persyaratan Sekolah", style = MaterialTheme.typography.bodyMedium, color = Color.White)
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .background(color = Secondary01, shape = RoundedCornerShape(20))
                        .padding(15.dp),
                    contentAlignment = Alignment.Center
                )
                {
                    Image(painter = painterResource(id = R.drawable.ic_lonceng), contentDescription = "icon")
                }
                Spacer(modifier = Modifier.width(15.dp))
                Column {
                    Text(text = "SMA/SMK/MA yang memiliki NPSN.", style = MaterialTheme.typography.bodySmall)
                    Text(text = "Memiliki akreditasi minimal A.", style = MaterialTheme.typography.bodySmall)
                    Text(text = "Mengisi PDSS dan data siswa dengan benar.", style = MaterialTheme.typography.bodySmall)
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .background(color = Secondary01, shape = RoundedCornerShape(20))
                        .padding(15.dp),
                    contentAlignment = Alignment.Center
                )
                {
                    Image(painter = painterResource(id = R.drawable.ic_syarat_book), contentDescription = "icon")
                }
                Spacer(modifier = Modifier.width(15.dp))
                Column {
                    Text(text = "SMA/SMK/MA dengan akreditasi A: 40% terbaik di sekolah.", style = MaterialTheme.typography.bodySmall)
                    Text(text = "SMA/SMK/MA dengan akreditasi B: 25% terbaik di sekolah.", style = MaterialTheme.typography.bodySmall)
                    Text(text = "SMA/SMK/MA dengan akreditasi C dan lainnya: 5% terbaik di sekolah.", style = MaterialTheme.typography.bodySmall)
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .background(color = Secondary01, shape = RoundedCornerShape(20))
                        .padding(15.dp),
                    contentAlignment = Alignment.Center
                )
                {
                    Image(painter = painterResource(id = R.drawable.ic_warn_mail), contentDescription = "icon")
                }
                Spacer(modifier = Modifier.width(15.dp))
                Column {
                    Text(text = "Bagi siswa yang memilih program studi seni dan olahraga, diwajibkan untuk mengunggah portofolio.", style = MaterialTheme.typography.bodySmall)
                    Text(text = "Setiap siswa eligible maksimal dapat memilih 2 program studi di 2 PTN yang berbeda.", style = MaterialTheme.typography.bodySmall)
                    Text(text = "Pendaftaran SNBP dilakukan secara online melalui portal SNPMB.", style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}