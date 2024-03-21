package com.example.ngampusyuk.feature.main.components.soalComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.example.ngampusyuk.feature.soal.SoalViewModel
import com.example.ngampusyuk.model.soal.SoalModel
import com.example.ngampusyuk.model.soalUser.SoalUserModel
import com.example.ngampusyuk.ui.theme.CustDarkBlue

@Composable
fun IsiSoal(soal: SoalModel?, jawaban: String, onJawabanChange:(String?)->Unit) {

    Column(
        Modifier.padding(15.dp)
    ) {
        Text(text = soal?.soal ?: "", style = MaterialTheme.typography.labelMedium)
        Spacer(modifier = Modifier.height(20.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier
                .background(
                    color =
                    if (jawaban == soal?.jawaban_a) Color.Green
                    else CustDarkBlue,
                    shape = RoundedCornerShape(10)
                )
                .size(35.dp)
                .clickable {
                    onJawabanChange(soal?.jawaban_a)
                },
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
                    if (jawaban == soal?.jawaban_b) Color.Green
                    else CustDarkBlue,
                    shape = RoundedCornerShape(10)
                )
                .size(35.dp)
                .clickable {
                    onJawabanChange(soal?.jawaban_b)
                },
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
                    if (jawaban == soal?.jawaban_c) Color.Green
                    else CustDarkBlue,
                    shape = RoundedCornerShape(10)
                )
                .size(35.dp)
                .clickable {
                    onJawabanChange(soal?.jawaban_c)
                },
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
                    if (jawaban == soal?.jawaban_d) Color.Green
                    else CustDarkBlue,
                    shape = RoundedCornerShape(10)
                )
                .size(35.dp)
                .clickable {
                    onJawabanChange(soal?.jawaban_d)
                },
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