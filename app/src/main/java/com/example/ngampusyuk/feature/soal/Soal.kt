package com.example.ngampusyuk.feature.soal

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ngampusyuk.feature.main.components.soalComponents.AppBar
import com.example.ngampusyuk.feature.main.components.soalComponents.IsiSoal
import com.example.ngampusyuk.feature.main.route.Screen
import kotlinx.coroutines.launch
import com.example.ngampusyuk.ui.theme.CustBlue
import com.example.ngampusyuk.ui.theme.CustDarkBlue

@Composable
fun Soal(navController: NavController, tryout_id : String, tryout_user_id: String) {
    val viewModel : SoalViewModel = viewModel()
    LaunchedEffect(key1 = true){
        viewModel.getAllSoal(tryout_id)
    }

    val soalNomorSatu = viewModel.soal.find { it.nomor == 1L }
    if (soalNomorSatu != null) {
        viewModel.getSoalById(soalNomorSatu.id)
    }
    val soalSortedByNomor = viewModel.soal.sortedBy { it.nomor }

    val selectedIndex = remember{
        mutableStateOf(-1)
    }

    LaunchedEffect(key1 = soalSortedByNomor.size ){
        if (soalSortedByNomor.size > 0){
            selectedIndex.value = 0
        }
    }

    LaunchedEffect(key1 = viewModel.isSuccess.value){
        if (viewModel.isSuccess.value) {
            navController.navigate(Screen.HasilTO.route) {
                popUpTo(Screen.Soal.route) {
                    inclusive = true
                }
            }
        }
    }

    LazyColumn{
        item {
            AppBar()
            Spacer(modifier = Modifier.height(10.dp))
            LazyRow {
                items(soalSortedByNomor.size) { index ->
                    val nomor = soalSortedByNomor[index].nomor
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Box(
                            modifier =
                            Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(
                                    color =
                                    if (viewModel.soalId.value?.nomor == soalSortedByNomor[index].nomor) CustBlue
                                    else if (viewModel.mapJawaban[soalSortedByNomor[index].id]?.value != "") Color.Green
                                    else Color.White
                                )
                                .clickable {
                                    viewModel.getSoalById(soalSortedByNomor[index].id)
                                    selectedIndex.value = index
                                },
                            contentAlignment = Alignment.Center,
                        ){
                            Text(text = nomor.toString(), style = MaterialTheme.typography.headlineSmall)
                        }
                        Spacer(modifier = Modifier.width(20.dp))

                    }
                }
            }
            if (selectedIndex.value != -1){
                IsiSoal(
                    soalSortedByNomor[selectedIndex.value],
                    (viewModel.mapJawaban[soalSortedByNomor[selectedIndex.value].id]?.value ?: ""),
                    {
                        viewModel.mapJawaban[soalSortedByNomor[selectedIndex.value].id]?.value = it ?: ""
                    }
                )
            }
        }
        item {
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .background(color = CustDarkBlue, shape = RoundedCornerShape(20))
                        .clickable
                        {
                            if (selectedIndex.value > 0) {
                                viewModel.getSoalById(soalSortedByNomor[selectedIndex.value - 1].id)
                                selectedIndex.value -= 1
                            }
                        }
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                        text = "Sebelumnya", style = MaterialTheme.typography.labelMedium,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Box(
                    modifier = Modifier
                        .background(color = CustDarkBlue, shape = RoundedCornerShape(20))
                        .clickable
                        {
                            if (selectedIndex.value < soalSortedByNomor.size - 1) {
                                viewModel.getSoalById(soalSortedByNomor[selectedIndex.value + 1].id)
                                selectedIndex.value += 1
                            } else if (selectedIndex.value == soalSortedByNomor.size - 1) {
                                viewModel.postSoalUserList(
                                    soalSortedByNomor,
                                    tryout_user_id,
                                )
                            }
                        }
                ) {
                    if (selectedIndex.value == soalSortedByNomor.size -1){
                        Text(
                            modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                            text = "Selesai", style = MaterialTheme.typography.labelMedium,
                            color = Color.White
                        )
                    }else{
                        Text(
                            modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                            text = "Selanjutnya", style = MaterialTheme.typography.labelMedium,
                            color = Color.White
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}