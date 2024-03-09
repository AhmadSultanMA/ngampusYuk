package com.example.ngampusyuk.feature.berita

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ngampusyuk.R
import com.example.ngampusyuk.feature.main.components.beritaComponents.AppBar

@Composable
fun Berita(navController: NavController, modifier : Modifier = Modifier) {
    LazyColumn{
        item {
            AppBar(navController)
            Column(modifier.padding(15.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(painter = painterResource(id = R.drawable.ic_berita1), contentDescription = "icon1")
                    Text(text = " ugm.ac.id", style = TextStyle(fontSize = 12.sp))
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(painter = painterResource(id = R.drawable.ic_berita2), contentDescription = "icon1")
                    Text(text = " 15 Januari 2024", style = TextStyle(fontSize = 12.sp))
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(painter = painterResource(id = R.drawable.ic_berita3), contentDescription = "icon1")
                    Text(text = " Oleh: Satria Ardhi", style = TextStyle(fontSize = 12.sp))
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "UGM Siap Terima 10.000 Mahasiswa dalam Penerimaan Mahasiswa Baru 2024",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Image(painter = painterResource(id = R.drawable.contentberita), contentDescription = "contentBerita", modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "UGM sebagai salah satu kampus yang banyak menjadi tujuan siswa-siswi untuk jenjang perguruan tinggi kembali mengumumkan penerimaan mahasiswa baru tahun 2024. Berbagai program studi tingkat sarjana dan vokasi ditawarkan dengan kriteria dan kuota tertentu. Sebagaimana pelaksanaan di tahun sebelumnya, pemilihan program studi tidak bergantung sepenuhnya pada jurusan di sekolah asal masing-masing. UGM juga berkomitmen untuk menciptakan keragaman dalam meningkatkan kualitas pendidikan.",
                    style = TextStyle(fontSize = 12.sp, textAlign = TextAlign.Justify)
                    )
            }
        }
    }
}

