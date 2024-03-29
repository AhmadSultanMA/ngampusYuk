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

@Composable
fun SyaratSiswa() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
    )
    {
        Box(modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(20)), contentAlignment = Alignment.BottomCenter){
            Image(modifier = Modifier.fillMaxWidth(), painter = painterResource(id = R.drawable.syarat_siswa), contentDescription = "gambar")
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(color = Color.Black.copy(alpha = 0.5f)), contentAlignment = Alignment.CenterStart
            )
            {
                Row {
                    Spacer(modifier = Modifier.width(30.dp))
                    Text(text = "Persyaratan Siswa", style = MaterialTheme.typography.bodyMedium, color = Color.White)
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
                    Text(text = "Warga Negara Indonesia (WNI) yang memiliki Nomor Induk Kependudukan (NIK).", style = MaterialTheme.typography.bodySmall)
                    Text(text = "Tidak pernah menikah dan tidak memiliki anak kandung.", style = MaterialTheme.typography.bodySmall)
                    Text(text = "Sehat jasmani dan rohani.", style = MaterialTheme.typography.bodySmall)
                    Text(text = "Bebas dari narkoba.", style = MaterialTheme.typography.bodySmall)
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
                    Text(text = "Memiliki NISN dan terdaftar di PDSS.", style = MaterialTheme.typography.bodySmall)
                    Text(text = "Merupakan siswa SMA/SMK/MA kelas terakhir (kelas XII) pada tahun 2024 yang memiliki prestasi unggul.", style = MaterialTheme.typography.bodySmall)
                    Text(text = "Memiliki nilai rapor yang telah diisikan di PDSS sesuai dengan ketentuan.", style = MaterialTheme.typography.bodySmall)
                    Text(text = "Lulus SMA/SMK/MA dengan nilai rata-rata minimal 7,00 untuk semua mata pelajaran.", style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}