package com.example.ngampusyuk.feature.main.components.peluangComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.ngampusyuk.feature.peluang.PeluangViewModel

@Composable
fun FilteredList(viewModel: PeluangViewModel) {
    if (viewModel.filteredJurusan.value.isNotEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .offset(0.dp, 255.dp)
                    .fillMaxWidth()
                    .background(color = Color.White, shape = RoundedCornerShape(20))
            ) {
                items(viewModel.filteredJurusan.value.distinctBy { it.nama_jurusan }.size) { index ->
                    val distinctJurusan = viewModel.filteredJurusan.value.distinctBy { it.nama_jurusan }
                    Text(
                        text = distinctJurusan[index].nama_jurusan,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable {
                                viewModel.jurusanText.value = distinctJurusan[index].nama_jurusan
                                viewModel.filteredJurusan.value = emptyList()
                            }
                    )
                }
            }
        }
    }
}
