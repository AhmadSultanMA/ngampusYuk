package com.example.ngampusyuk.feature.snbt

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ngampusyuk.feature.main.components.snbtComponents.AppBar
import com.example.ngampusyuk.feature.main.components.snbtComponents.JadwalBulan
import com.example.ngampusyuk.feature.main.components.snbtComponents.JadwalCalendar
import com.example.ngampusyuk.feature.main.components.snbtComponents.SemuaAlur
import com.example.ngampusyuk.feature.main.components.snbtComponents.SemuaJadwal
import com.example.ngampusyuk.feature.main.components.snbtComponents.SemuaPersyaratan
import com.example.ngampusyuk.feature.main.components.snbtComponents.InfoLanjut
import com.example.ngampusyuk.feature.main.components.snbtComponents.SnbtCard
import com.example.ngampusyuk.feature.main.components.snbtComponents.SyaratAkademik
import com.example.ngampusyuk.feature.main.components.snbtComponents.SyaratLain
import com.example.ngampusyuk.feature.main.components.snbtComponents.SyaratUmum
import com.example.ngampusyuk.feature.main.route.Screen
import com.example.ngampusyuk.feature.snbp.SNBTViewModel
import com.example.ngampusyuk.ui.theme.Primary05

@Composable
fun SNBT(navController: NavController) {
    val items = listOf("Semua", "Jadwal", "Persyaratan", "Pendaftaran")
    val selectedItem = remember{
        mutableStateOf("Semua")
    }
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val viewModel : SNBTViewModel = viewModel()

    LazyColumn{
        item{
            AppBar(navController)
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier
                .padding(horizontal = 15.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                items.forEach { item ->
                    Box(
                        modifier = Modifier
                            .background(
                                color = if (selectedItem.value == item) Primary05
                                else Color.Gray,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .clickable {
                                selectedItem.value = item
                            }
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = item, style = MaterialTheme.typography.bodySmall,
                            color = Color.White
                        )
                    }
                }
            }
        }
        if (selectedItem.value == "Semua"){
            item {
                Spacer(modifier = Modifier.height(10.dp))
                Column(Modifier.padding(horizontal = 15.dp)) {
                    Text(text = "Definisi SNBT", style = MaterialTheme.typography.bodyMedium)
                    Text(
                        text = "Kenali lebih dalam mengenai SNBT 2024",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
            val chunks = viewModel.snbt.chunked(2)
            items(chunks.size){index ->
                Row(Modifier.fillMaxWidth().padding(horizontal = 15.dp) ,horizontalArrangement = Arrangement.SpaceBetween) {
                    chunks[index].forEach{item->
                        Box(modifier = Modifier
                            .width(screenWidth * 0.44f)
                            .clickable {
                                navController.navigate("${Screen.SNBTDetail.route}/${item.id}") {
                                    popUpTo(Screen.SNBT.route) {
                                        inclusive = true
                                    }
                                }
                            },){
                            SnbtCard(
                                item.gambar,
                                item.judul,
                                item.sub_judul
                            )
                        }
                    }
                }
                if (index < chunks.size - 1) {
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
            item{
                Spacer(modifier = Modifier.height(10.dp))
                SemuaJadwal(selectedItem)
                Spacer(modifier = Modifier.height(10.dp))
                SemuaPersyaratan(selectedItem)
                Spacer(modifier = Modifier.height(10.dp))
                SemuaAlur()
                Spacer(modifier = Modifier.height(10.dp))
                InfoLanjut()
                Spacer(modifier = Modifier.height(15.dp))
            }
        }else if (selectedItem.value == "Jadwal"){
            item{
                Spacer(modifier = Modifier.height(10.dp))
                Column(Modifier.padding(horizontal = 15.dp)) {
                    Text(text = "Jadwal SNBT", style = MaterialTheme.typography.bodyMedium)
                    Text(
                        text = "Kenali lebih dalam mengenai SBNT 2024",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                JadwalCalendar()
                Spacer(modifier = Modifier.height(10.dp))
                JadwalBulan()
                Spacer(modifier = Modifier.height(15.dp))
            }
        }else if (selectedItem.value == "Persyaratan"){
            item {
                Spacer(modifier = Modifier.height(10.dp))
                Column(Modifier.padding(horizontal = 15.dp)) {
                    Text(text = "Persyaratan Umum", style = MaterialTheme.typography.bodyMedium)
                    Text(
                        text = "Pelajari lebih lanjut persyaratan menuju SNBT ",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                SyaratUmum()
                Spacer(modifier = Modifier.height(10.dp))
                Column(Modifier.padding(horizontal = 15.dp)) {
                    Text(text = "Persyaratan Akademik", style = MaterialTheme.typography.bodyMedium)
                    Text(
                        text = "Pelajari persyaratan Akademik kalian dan persiapkan untuk menuju SNBT 2024",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                SyaratAkademik()
                Spacer(modifier = Modifier.height(10.dp))
                Column(Modifier.padding(horizontal = 15.dp)) {
                    Text(text = "Persyaratan Lainnya", style = MaterialTheme.typography.bodyMedium)
                    Text(
                        text = "Penuhi persyartan lainnya  dan persiapkan untuk menuju SNBT 2024",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                SyaratLain()
                Spacer(modifier = Modifier.height(15.dp))
            }
        }else if(selectedItem.value == "Pendaftaran"){
            item{
                Spacer(modifier = Modifier.height(10.dp))
                SemuaAlur()
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}