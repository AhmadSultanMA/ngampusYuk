package com.example.ngampusyuk.feature.soal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun Soal(navController: NavController, tryout_id : String) {
    val viewModel : SoalViewModel = viewModel()

    LaunchedEffect(key1 = true){
        viewModel.getAllSoal(tryout_id)
    }

    LazyColumn{
        items(viewModel.soal.size){index ->
            val soal = viewModel.soal[index]

            Text(text = soal.jawaban_a)
            Text(text = soal.jawaban_b)
            Text(text = soal.jawaban_c)
            Text(text = soal.jawaban_d)
        }
    }
}