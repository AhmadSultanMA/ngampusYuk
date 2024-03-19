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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ngampusyuk.R
import com.example.ngampusyuk.ui.theme.Aksen06
import com.example.ngampusyuk.ui.theme.CustSecondary

@Composable
fun SemuaAlur() {
    Column(Modifier.padding(horizontal = 15.dp)) {
        Text(text = "Alur Pendaftaran SNBP", style = MaterialTheme.typography.labelSmall)
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "Siapkah kamu untuk membuka gerbang menuju perguruan tinggi impian?",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(horizontalArrangement = Arrangement.Start) {
            Box(
                modifier = Modifier
                    .width(210.dp)
                    .background(
                        color = Aksen06.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(
                            topStartPercent = 20,
                            topEndPercent = 20,
                            bottomStartPercent = 20
                        )
                    )
                    .padding(6.dp)
            ){
                Row(Modifier.fillMaxWidth(),verticalAlignment = Alignment.Top) {
                    Text(text = "1. ", style = MaterialTheme.typography.labelSmall)
                    Column(Modifier.fillMaxWidth()) {
                        Text(text = "Pengumuman Kuota Sekolah", style = MaterialTheme.typography.labelSmall)
                        Text(text = "Cek kuota sekolah dan persiapkan dirimu untuk mendaftar!", style = MaterialTheme.typography.labelSmall, color = Color.White)
                    }
                }
            }
            Spacer(modifier = Modifier.width(20.dp))
            Image(painter = painterResource(id = R.drawable.person1), contentDescription = "person1")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row(horizontalArrangement = Arrangement.End) {
            Image(painter = painterResource(id = R.drawable.person2), contentDescription = "person2")
            Spacer(modifier = Modifier.width(20.dp))
            Box(
                modifier = Modifier
                    .width(210.dp)
                    .background(
                        color = CustSecondary,
                        shape = RoundedCornerShape(
                            topStartPercent = 20,
                            topEndPercent = 20,
                            bottomEndPercent = 20
                        )
                    )
                    .padding(6.dp)
            ){
                Row(Modifier.fillMaxWidth(),verticalAlignment = Alignment.Top) {
                    Text(text = "2. ", style = MaterialTheme.typography.labelSmall)
                    Column(Modifier.fillMaxWidth()) {
                        Text(text = "Masa Sanggah kuota Sekolah", style = MaterialTheme.typography.labelSmall)
                        Text(text = "Jika terdapat ketidaksesuaian, ajukan sanggah dengan cermat", style = MaterialTheme.typography.labelSmall, color = Color.White)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row(horizontalArrangement = Arrangement.Start) {
            Box(
                modifier = Modifier
                    .width(210.dp)
                    .background(
                        color = Aksen06.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(
                            topStartPercent = 20,
                            topEndPercent = 20,
                            bottomStartPercent = 20
                        )
                    )
                    .padding(6.dp)
            ){
                Row(Modifier.fillMaxWidth(),verticalAlignment = Alignment.Top) {
                    Text(text = "3. ", style = MaterialTheme.typography.labelSmall)
                    Column(Modifier.fillMaxWidth()) {
                        Text(text = "Registrasi  Akun SNPMB", style = MaterialTheme.typography.labelSmall)
                        Text(text = "Daftarkan dirimu dan sekolahmu di portal SNPMB.", style = MaterialTheme.typography.labelSmall, color = Color.White)
                    }
                }
            }
            Spacer(modifier = Modifier.width(20.dp))
            Image(painter = painterResource(id = R.drawable.person1), contentDescription = "person1")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row(horizontalArrangement = Arrangement.End) {
            Image(painter = painterResource(id = R.drawable.person2), contentDescription = "person2")
            Spacer(modifier = Modifier.width(20.dp))
            Box(
                modifier = Modifier
                    .width(210.dp)
                    .background(
                        color = CustSecondary,
                        shape = RoundedCornerShape(
                            topStartPercent = 20,
                            topEndPercent = 20,
                            bottomEndPercent = 20
                        )
                    )
                    .padding(6.dp)
            ){
                Row(Modifier.fillMaxWidth(),verticalAlignment = Alignment.Top) {
                    Text(text = "4. ", style = MaterialTheme.typography.labelSmall)
                    Column(Modifier.fillMaxWidth()) {
                        Text(text = "Pengisian PDSS", style = MaterialTheme.typography.labelSmall)
                        Text(text = "Pastikan semua data akademismu dan prestasi akurat dan lengkap!", style = MaterialTheme.typography.labelSmall, color = Color.White)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row(horizontalArrangement = Arrangement.Start) {
            Box(
                modifier = Modifier
                    .width(210.dp)
                    .background(
                        color = Aksen06.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(
                            topStartPercent = 20,
                            topEndPercent = 20,
                            bottomStartPercent = 20
                        )
                    )
                    .padding(6.dp)
            ){
                Row(Modifier.fillMaxWidth(),verticalAlignment = Alignment.Top) {
                    Text(text = "5. ", style = MaterialTheme.typography.labelSmall)
                    Column(Modifier.fillMaxWidth()) {
                        Text(text = "Pendaftaran SNBP", style = MaterialTheme.typography.labelSmall)
                        Text(text = "Pilihlah program studi yang sesuai dengan minat dan bakatmu", style = MaterialTheme.typography.labelSmall, color = Color.White)
                    }
                }
            }
            Spacer(modifier = Modifier.width(20.dp))
            Image(painter = painterResource(id = R.drawable.person1), contentDescription = "person1")
        }
    }
}