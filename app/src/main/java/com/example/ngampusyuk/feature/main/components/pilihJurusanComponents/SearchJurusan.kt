package com.example.ngampusyuk.feature.main.components.pilihJurusanComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.ngampusyuk.feature.pilihJurusan.PilihJurusanViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchJurusan(
    value: String,
    onValueChange: (String) -> Unit,
    viewModel: PilihJurusanViewModel,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier.clip(shape = RoundedCornerShape(20.dp)),
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
                    viewModel.jurusan.filter { jurusan ->
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
                )
            },
            textStyle = TextStyle(color = Color.Black),
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Gray,
                focusedBorderColor = Color.Black
            )
        )
    }
}
