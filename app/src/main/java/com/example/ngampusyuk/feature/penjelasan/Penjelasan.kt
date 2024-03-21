package com.example.ngampusyuk.feature.penjelasan

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.ngampusyuk.feature.main.components.penjelasanComponents.AppBar
import com.example.ngampusyuk.feature.main.components.penjelasanComponents.IsiSoal
import com.example.ngampusyuk.feature.main.route.Screen
import com.example.ngampusyuk.ui.theme.Aksen02
import com.example.ngampusyuk.ui.theme.CustBlue

@Composable
fun Penjelasan(navController: NavController, tryout_id : String) {
    val viewModel : PenjelasanViewModel = viewModel()

    LaunchedEffect(key1 = true){
        viewModel.getAllSoalUser(tryout_id)
        viewModel.getAllSoal(tryout_id)
    }

    val soalSortedByNomor = viewModel.AllSoal.sortedBy { it.nomor }

    val selectedIndex = remember{
        mutableStateOf(-1)
    }

    LaunchedEffect(key1 = soalSortedByNomor.size ){
        if (soalSortedByNomor.size > 0){
            selectedIndex.value = 0
        }
    }

    LazyColumn(
        Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ){
        item {
            AppBar(navController, tryout_id)
            Spacer(modifier = Modifier.height(10.dp))
            LazyRow {
                items(soalSortedByNomor.size) { index ->
                    val soal = soalSortedByNomor[index]
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Box(
                            modifier =
                            Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(
                                    color =
                                    if (soal.nomor.toInt() == selectedIndex.value + 1) CustBlue
                                    else if (soal.benar.value) Aksen02
                                    else if (!soal.benar.value) Color.Red
                                    else Color.White
                                )
                                .clickable {
                                    selectedIndex.value = index
                                },
                            contentAlignment = Alignment.Center,
                        ){
                            Text(text = soal.nomor.toString(), style = MaterialTheme.typography.headlineSmall)
                        }
                        Spacer(modifier = Modifier.width(20.dp))

                    }
                }
            }
            if (selectedIndex.value != -1){
                IsiSoal(
                    soalSortedByNomor[selectedIndex.value],
                    viewModel.mapJawaban[soalSortedByNomor[selectedIndex.value].id],
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            Column(Modifier.padding(horizontal = 15.dp)) {
                Text(text = "Pembahasan", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(20.dp))
                if (viewModel.user.value?.premium == true){
                    if (selectedIndex.value != -1) {
                        Text(
                            text = soalSortedByNomor[selectedIndex.value].penjelasan,
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }else{
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "Eitsss kamu blom premium", style = MaterialTheme.typography.labelMedium)
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(text = "Yuk upgrade ke premium", style = MaterialTheme.typography.labelMedium)
                            Spacer(modifier = Modifier.height(10.dp))
                            Box(Modifier
                                .background(color = CustBlue, shape = RoundedCornerShape(20))
                                .clickable {
                                    navController.navigate(Screen.Invoice.route) {
                                        popUpTo(Screen.Penjelasan.route) {
                                            inclusive = true
                                        }
                                    }
                                },
                                contentAlignment = Alignment.Center
                            ){
                                Text(
                                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                                    text = "Upgrade",
                                    style = MaterialTheme.typography.labelLarge, color = Color.White
                                )
                            }
                        }
                    }
                }
                
            }
        }
    }
}