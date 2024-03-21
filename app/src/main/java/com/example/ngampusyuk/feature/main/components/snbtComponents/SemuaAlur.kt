package com.example.ngampusyuk.feature.main.components.snbtComponents

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
        Text(text = "Alur Pendaftaran SNBT", style = MaterialTheme.typography.labelSmall)
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
                        Text(text = "Buat akun SNPMB", style = MaterialTheme.typography.labelSmall)
                        Text(text = "Biasanya pendaftaran akun dibuka sekitar Januari-Februari.", style = MaterialTheme.typography.labelSmall, color = Color.White)
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
                        Text(text = "Lengkapi biodata dan sekolah", style = MaterialTheme.typography.labelSmall)
                        Text(text = "Isi data diri Anda dengan lengkap dan teliti.", style = MaterialTheme.typography.labelSmall, color = Color.White)
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
                        Text(text = "Pilih Program Studi yang diminati", style = MaterialTheme.typography.labelSmall)
                        Text(text = "Pilih program studi (prodi) yang kamu inginkan di PTN pilihan.", style = MaterialTheme.typography.labelSmall, color = Color.White)
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
                        Text(text = "Bayar Biaya Pendaftaran", style = MaterialTheme.typography.labelSmall)
                        Text(text = "lakukan pembayaran sesuai dengan ketentuan yang berlaku.", style = MaterialTheme.typography.labelSmall, color = Color.White)
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
                        Text(text = "Cetak Kartu peserta UTBK", style = MaterialTheme.typography.labelSmall)
                        Text(text = "Download kartu peserta UTBK SNBT yang akan digunakan saat ujian ", style = MaterialTheme.typography.labelSmall, color = Color.White)
                    }
                }
            }
            Spacer(modifier = Modifier.width(20.dp))
            Image(painter = painterResource(id = R.drawable.person1), contentDescription = "person1")
        }
    }
}