package com.example.ngampusyuk.feature.main.components.peluangComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ngampusyuk.feature.main.route.Screen
import com.example.ngampusyuk.feature.peluang.PeluangViewModel
import com.example.ngampusyuk.ui.theme.CustDarkBlue
import com.example.ngampusyuk.ui.theme.Primary01

@Composable
fun Input(viewModel: PeluangViewModel, navController: NavController, modifier: Modifier = Modifier) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
        ){
            Row(
                modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Belum Memiliki Skor?", style = MaterialTheme.typography.labelLarge)
                Card(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 8.dp
                    )
                ) {
                    Text(
                        modifier = Modifier
                            .padding(vertical = 4.dp, horizontal = 12.dp)
                            .clickable {
                                navController.navigate(Screen.PilihTO.route) {
                                    popUpTo(Screen.Tes.route) {
                                        inclusive = true
                                    }
                                }
                            },
                        text = "Cek Sekarang!", style = MaterialTheme.typography.labelMedium, color = CustDarkBlue
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Skor(value = viewModel.skor.value, onValueChange = {  viewModel.skor.value = it })
            Spacer(modifier = Modifier.height(10.dp))
            jurusan(value = viewModel.jurusanText.value, onValueChange = {  viewModel.jurusanText.value = it }, viewModel = viewModel)
            Spacer(modifier = Modifier.height(10.dp))
            Box(modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                Card(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 8.dp
                    )
                ){
                    Text(
                        modifier = Modifier
                            .background(color = Primary01)
                            .padding(vertical = 8.dp, horizontal = 24.dp)
                            .clickable {
                                viewModel.getAllJurusanByTes()
                            },
                        text = "Submit", style = MaterialTheme.typography.titleSmall, color = Color.White
                    )
                }
            }
        }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Skor(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(20.dp)),
            value = value,
            shape = RoundedCornerShape(20.dp),
            onValueChange = {
                val filter = it.filter { it.isDigit() }
                onValueChange(filter)
            },
            placeholder = {
                Text("Masukkan Skor",
                    color = Color.Black,
                    style = MaterialTheme.typography.labelSmall
                )},
            textStyle = TextStyle(color = Color.Black),
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.White,
                focusedBorderColor = Color.Black
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun jurusan(
    value: String,
    onValueChange: (String) -> Unit,
    viewModel: PeluangViewModel,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(20.dp)),
            value = value,
            shape = RoundedCornerShape(20.dp),
            onValueChange = {
                onValueChange(it)
                viewModel.filteredJurusan.value = if (it.isNotEmpty()) {
                    viewModel.jurusanAll.filter { jurusan ->
                        jurusan.nama_jurusan.contains(it, ignoreCase = true)
                    }
                } else {
                    emptyList()
                }
            },
            placeholder = {
                Text("Masukkan Program Studi",
                    color = Color.Black,
                    style = MaterialTheme.typography.labelSmall
                )},
            textStyle = TextStyle(color = Color.Black),
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.White,
                focusedBorderColor = Color.Black
            )
        )
    }
}