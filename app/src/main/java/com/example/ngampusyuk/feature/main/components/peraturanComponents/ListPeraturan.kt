package com.example.ngampusyuk.feature.main.components.peraturanComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ListPeraturan() {
    Column(Modifier.padding(15.dp)) {
        Text(text = "Peraturan Try Out", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Text(text = "1.", style = MaterialTheme.typography.labelLarge)
            Text(
                text = "Peserta harus memiliki koneksi internet yang stabil dan perangkat (komputer, laptop, atau tablet) yang memadai untuk mengakses platform try out online.",
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Justify
                )
        }
        Row {
            Text(text = "2.", style = MaterialTheme.typography.labelLarge)
            Text(
                text = "Peserta diharapkan memulai try out tepat waktu dan menyelesaikan semua bagian dalam batas waktu yang ditentukan.",
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Justify
            )
        }
        Row {
            Text(text = "3.", style = MaterialTheme.typography.labelLarge)
            Text(
                text = "Hasil try out akan dinilai secara otomatis oleh sistem.",
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Justify
            )
        }
        Row {
            Text(text = "4.", style = MaterialTheme.typography.labelLarge)
            Text(
                text = "Try out dianggap selesai setelah peserta menyelesaikan semua bagian tes dan keluar dari platform try out.",
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Justify
            )
        }
        Row {
            Text(text = "5.", style = MaterialTheme.typography.labelLarge)
            Text(
                text = "Tidak diperkenankan mengunggah, menyebarkan, atau menggunakan soal try out secara ilegal atau tanpa izin tertulis dari penyelenggara.",
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Justify
            )
        }
    }
}