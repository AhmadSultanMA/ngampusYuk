package com.example.ngampusyuk.feature.main.components.penjelasanComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import com.example.ngampusyuk.model.soal.SoalModel
import com.example.ngampusyuk.ui.theme.Aksen02
import com.example.ngampusyuk.ui.theme.CustBlue
import com.example.ngampusyuk.ui.theme.CustDarkBlue

@Composable
fun IsiSoal(soal : SoalModel?, jawaban:String?) {

    Column(
        Modifier.padding(15.dp)
    ) {
        Text(text = soal?.soal ?: "", style = MaterialTheme.typography.labelMedium)
        Spacer(modifier = Modifier.height(20.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier
                .background(
                    color =
                    if (soal?.benar?.value == false && jawaban == soal.jawaban_a) Color.Red
                    else if (jawaban == soal?.jawaban_a) Aksen02
                    else CustDarkBlue,
                    shape = RoundedCornerShape(10)
                )
                .size(35.dp),
                contentAlignment = Alignment.Center
            )
            {
                Text(text = "A", style = MaterialTheme.typography.titleLarge, color = Color.White)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = soal?.jawaban_a ?: "", style = MaterialTheme.typography.labelMedium)
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier
                .background(
                    if (soal?.benar?.value == false && jawaban == soal.jawaban_b) Color.Red
                    else if (jawaban == soal?.jawaban_b) Aksen02
                    else CustDarkBlue,
                    shape = RoundedCornerShape(10)
                )
                .size(35.dp),
                contentAlignment = Alignment.Center
            )
            {
                Text(text = "B", style = MaterialTheme.typography.titleLarge, color = Color.White)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = soal?.jawaban_b ?: "", style = MaterialTheme.typography.labelMedium)
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier
                .background(
                    if (soal?.benar?.value == false && jawaban == soal.jawaban_c) Color.Red
                    else if (jawaban == soal?.jawaban_c) Aksen02
                    else CustDarkBlue,
                    shape = RoundedCornerShape(10)
                )
                .size(35.dp),
                contentAlignment = Alignment.Center
            )
            {
                Text(text = "C", style = MaterialTheme.typography.titleLarge, color = Color.White)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = soal?.jawaban_c?: "", style = MaterialTheme.typography.labelMedium)
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier
                .background(
                    if (soal?.benar?.value == false && jawaban == soal.jawaban_d) Color.Red
                    else if (jawaban == soal?.jawaban_d) Aksen02
                    else CustDarkBlue,
                    shape = RoundedCornerShape(10)
                )
                .size(35.dp),
                contentAlignment = Alignment.Center
            )
            {
                Text(text = "D",style = MaterialTheme.typography.titleLarge ,color = Color.White)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = soal?.jawaban_d ?: "", style = MaterialTheme.typography.labelMedium)
        }
    }
}