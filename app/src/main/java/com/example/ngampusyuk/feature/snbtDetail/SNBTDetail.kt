package com.example.ngampusyuk.feature.snbtDetail

import com.example.ngampusyuk.feature.snbpDetail.SNBPDetailViewModel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.ngampusyuk.feature.main.route.Screen
import com.example.ngampusyuk.ui.theme.CustBlue

@Composable
fun SNBTDetail(navController: NavController, id: String, modifier : Modifier = Modifier) {
    val viewModel: SNBTDetailViewModel = viewModel()
    LaunchedEffect(key1 = true){
        viewModel.getSNBTById(id)
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(CustBlue)){
                Row(
                    modifier.padding(15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = {
                            navController.navigate(Screen.SNBP  .route) {
                                popUpTo("${Screen.Berita.route}/${id}") {
                                    inclusive = true
                                }
                            }
                        }) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                    Text(
                        modifier = Modifier.fillMaxWidth(0.83f),
                        text = "SNBT Detail",
                        style = TextStyle(color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
                    )
                }
            }
            Column(Modifier.padding(horizontal = 15.dp)) {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                    Text(text = viewModel.snbt.value?.judul ?: "", style = MaterialTheme.typography.labelLarge)
                }
                Spacer(modifier = Modifier.height(10.dp))
                AsyncImage(modifier = Modifier.fillMaxWidth(),model = viewModel.snbt.value?.gambar ?: "", contentDescription = "gambar")
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = viewModel.snbt.value?.isi ?: "", style = MaterialTheme.typography.bodyMedium)
            }

        }
    }
}