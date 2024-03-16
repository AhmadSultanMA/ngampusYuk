package com.example.ngampusyuk.feature.pilihJurusan

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ngampusyuk.feature.main.components.pilihJurusanComponents.FilteredJurusan
import com.example.ngampusyuk.feature.main.components.pilihJurusanComponents.SearchJurusan
import com.example.ngampusyuk.feature.main.route.Screen
import com.example.ngampusyuk.feature.pilihBanding.PilihBandingViewModel
import com.example.ngampusyuk.ui.theme.CustBlue
import com.example.ngampusyuk.ui.theme.CustDarkBlue

@Composable
fun PilihJurusan(
    navController: NavController,
    kampus_id : String,
    urutan : String,
    bandingViewModel: PilihBandingViewModel,modifier : Modifier = Modifier
) {
    val viewModel : PilihJurusanViewModel = viewModel()

    LaunchedEffect(key1 = true){
        viewModel.getAllJurusan(kampus_id)
        viewModel.getKampusById(kampus_id)
    }

    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Column(modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        CustBlue,
                        Color.White
                    ),
                    startY = 200f
                )
            )
            .padding(15.dp)
        ){
            Box(
                modifier
                    .fillMaxWidth()
                    .background(color = Color.White, shape = RoundedCornerShape(30))
                    .padding(vertical = 8.dp)
            ){
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = {
                        navController.navigate("${Screen.PilihUniv.route}/${urutan}") {
                            popUpTo("${Screen.PilihJurusan.route}/${kampus_id}/${urutan}") {
                                inclusive = true
                            }
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    if (urutan == "satu"){
                        Text(text = "Pilih Jurusan Pertama", style = MaterialTheme.typography.labelLarge)
                    }else{
                        Text(text = "Pilih Jurusan Kedua", style = MaterialTheme.typography.labelLarge)
                    }
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            if (urutan == "satu"){
                Text(text = "Jurusan Pertama", style = MaterialTheme.typography.titleMedium)
            }else{
                Text(text = "Jurusan Kedua", style = MaterialTheme.typography.titleMedium)
            }
            Spacer(modifier = Modifier.height(40.dp))
            SearchJurusan(
                value = viewModel.jurusanText.value,
                onValueChange =
                {
                    viewModel.jurusanText.value = it
                    viewModel.status.value = false
                },
                viewModel )
            Spacer(modifier = Modifier.height(40.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = CustDarkBlue, shape = RoundedCornerShape(20.dp))
                    .clickable {
                        if(viewModel.status.value){
                            if(urutan == "satu"){
                                bandingViewModel.jurusan1.value = viewModel.jurusanChosen.value
                                bandingViewModel.kampus1.value = viewModel.kampus.value
                            }else{
                                bandingViewModel.jurusan2.value = viewModel.jurusanChosen.value
                                bandingViewModel.kampus2.value = viewModel.kampus.value
                            }
                            viewModel.status.value = false
                            navController.navigate(Screen.PilihBanding.route) {
                                popUpTo("${Screen.PilihJurusan.route}/${kampus_id}/${urutan}") {
                                    inclusive = true
                                }
                            }
                        }
                    },
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 10.dp),
                    text = "Next",
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 19.sp
                    )
                )
            }
        }
        FilteredJurusan(viewModel)
    }
}