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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.ngampusyuk.feature.soal.SoalViewModel
import com.example.ngampusyuk.model.soal.SoalModel
import com.example.ngampusyuk.model.soalUser.SoalUserModel
import com.example.ngampusyuk.ui.theme.CustDarkBlue

@Composable
fun IsiSoal(soal: SoalModel?, soalUser: List<SoalUserModel>, viewModel: SoalViewModel,tryout_user_id: String) {
    val soalTerjawab = soalUser.find { it.soal_id == soal?.id }

    Column(
        Modifier.padding(15.dp)
    ) {
        Text(text = soal?.soal ?: "", style = MaterialTheme.typography.labelMedium)
        Spacer(modifier = Modifier.height(20.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier
                .background(
                    color =
                    if (soalTerjawab?.jawab == soal?.jawaban_a) Color.Green
                    else CustDarkBlue,
                    shape = RoundedCornerShape(10)
                )
                .size(35.dp)
                .clickable {
                    if (soalTerjawab == null) {
                        viewModel.postSoalUser(
                            jawab = soal?.jawaban_a ?: "",
                            benar = soal?.jawaban_a == soal?.jawaban_benar,
                            soal_id = soal?.id ?: "",
                            tryout_user_id = tryout_user_id
                        )
                    } else {
                        if (soalTerjawab.jawab != soal?.jawaban_a) {
                            viewModel.updateSoalUser(
                                id = soalTerjawab.id ?: "",
                                benar = soal?.jawaban_a == soal?.jawaban_benar,
                                jawab = soal?.jawaban_a ?: "",
                            )
                        }
                    }
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
                    if (soalTerjawab?.jawab == soal?.jawaban_b) Color.Green
                    else CustDarkBlue,
                    shape = RoundedCornerShape(10)
                )
                .size(35.dp)
                .clickable {
                    if (soalTerjawab == null) {
                        viewModel.postSoalUser(
                            jawab = soal?.jawaban_b ?: "",
                            benar = soal?.jawaban_b == soal?.jawaban_benar,
                            soal_id = soal?.id ?: "",
                            tryout_user_id = tryout_user_id
                        )
                    } else {
                        if (soalTerjawab.jawab != soal?.jawaban_b) {
                            viewModel.updateSoalUser(
                                id = soalTerjawab.id ?: "",
                                benar = soal?.jawaban_b == soal?.jawaban_benar,
                                jawab = soal?.jawaban_b ?: "",
                            )
                        }
                    }
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
                    if (soalTerjawab?.jawab == soal?.jawaban_c) Color.Green
                    else CustDarkBlue,
                    shape = RoundedCornerShape(10)
                )
                .size(35.dp)
                .clickable {
                    if (soalTerjawab == null) {
                        viewModel.postSoalUser(
                            jawab = soal?.jawaban_c ?: "",
                            benar = soal?.jawaban_c == soal?.jawaban_benar,
                            soal_id = soal?.id ?: "",
                            tryout_user_id = tryout_user_id
                        )
                    } else {
                        if (soalTerjawab.jawab != soal?.jawaban_c) {
                            viewModel.updateSoalUser(
                                id = soalTerjawab.id ?: "",
                                benar = soal?.jawaban_c == soal?.jawaban_benar,
                                jawab = soal?.jawaban_c ?: "",
                            )
                        }
                    }
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
                    if (soalTerjawab?.jawab == soal?.jawaban_d) Color.Green
                    else CustDarkBlue,
                    shape = RoundedCornerShape(10)
                )
                .size(35.dp)
                .clickable {
                    if (soalTerjawab == null) {
                        viewModel.postSoalUser(
                            jawab = soal?.jawaban_d ?: "",
                            benar = soal?.jawaban_d == soal?.jawaban_benar,
                            soal_id = soal?.id ?: "",
                            tryout_user_id = tryout_user_id
                        )
                    } else {
                        if (soalTerjawab.jawab != soal?.jawaban_d) {
                            viewModel.updateSoalUser(
                                id = soalTerjawab.id ?: "",
                                benar = soal?.jawaban_d == soal?.jawaban_benar,
                                jawab = soal?.jawaban_d ?: "",
                            )
                        }
                    }
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