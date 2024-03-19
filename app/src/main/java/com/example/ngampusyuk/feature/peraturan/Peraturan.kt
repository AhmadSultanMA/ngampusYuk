package com.example.ngampusyuk.feature.peraturan

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.ngampusyuk.feature.main.components.peraturanComponents.AppBar
import com.example.ngampusyuk.feature.main.components.peraturanComponents.ListPeraturan
import com.example.ngampusyuk.feature.main.route.Screen
import com.example.ngampusyuk.ui.theme.CustDarkBlue

@Composable
fun Peraturan(navController: NavController, id: String) {
    val viewModel : PeraturanViewModel = viewModel()

    LaunchedEffect(key1 = true){
        viewModel.getTOById(id)
        viewModel.getAllSoal(id)
    }

    LaunchedEffect(key1 = viewModel.isSuccess.value){
        if(viewModel.isSuccess.value){
            navController.navigate("${Screen.Soal.route}/${viewModel.data.value?.id}/${viewModel.tryout_user_id.value}") {
                popUpTo("${Screen.Peraturan.route}/${viewModel.data.value?.id}") {
                    inclusive = true
                }
            }
        }
    }

    LazyColumn {
        item {
            AppBar(navController, viewModel.data.value)
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = viewModel.data.value?.gambar,
                contentDescription = "gambar",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Total Jumlah Soal", style = MaterialTheme.typography.labelLarge)
                Text(text = "${viewModel.soal.size} Butir", style = MaterialTheme.typography.labelLarge)
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Total Waktu Pengerjaan", style = MaterialTheme.typography.labelLarge)
                Text(text = "25 Menit", style = MaterialTheme.typography.labelLarge)
            }
            Spacer(modifier = Modifier.height(10.dp))
            ListPeraturan()
            Spacer(modifier = Modifier.height(10.dp))
            if (viewModel.isLoading.value){
                Box(modifier = Modifier
                    .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ){
                    CircularProgressIndicator()
                }
            }else{
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp)
                        .background(color = CustDarkBlue, shape = RoundedCornerShape(20.dp))
                        .clickable {
                            viewModel.postTryoutUser(viewModel.data.value?.id ?: "")
                        },
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        modifier = Modifier.padding(vertical = 10.dp),
                        text = "Mulai Try Out",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}