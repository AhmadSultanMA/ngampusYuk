package com.example.ngampusyuk.feature.hasilBanding

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.ngampusyuk.R
import com.example.ngampusyuk.feature.main.components.hasilBandingComponents.BandingIndicator
import com.example.ngampusyuk.feature.main.components.hasilBandingComponents.InformasiKampus
import com.example.ngampusyuk.feature.main.navigation.BottomNavigationBar
import com.example.ngampusyuk.feature.pilihBanding.PilihBandingViewModel
import com.example.ngampusyuk.ui.theme.CustBlue
import com.example.ngampusyuk.ui.theme.CustGray

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HasilBanding(navController : NavController, bandingViewModel: PilihBandingViewModel) {
    Scaffold(
        bottomBar =  {
            BottomAppBar(
                tonalElevation = 8.dp,
                containerColor = Color.White,
            ) {
                BottomNavigationBar(navController = navController)
            }
        }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            item {
                Box(
                    modifier = Modifier
                        .background(color = CustBlue)
                        .fillMaxWidth()
                        .height(110.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Hasil Banding", style = MaterialTheme.typography.headlineMedium)
                }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.White, RoundedCornerShape(10))
                            .padding(horizontal = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(20.dp))
                        InformasiKampus(bandingViewModel)
                        Spacer(modifier = Modifier.height(20.dp))
                        BandingIndicator(
                            bandingViewModel.jurusan1.value?.passing_grade ?: 0,
                            bandingViewModel.jurusan2.value?.passing_grade?:0,
                            painterResource(id = R.drawable.ic_pass_grade),
                            "Passing Grade"
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        BandingIndicator(
                            bandingViewModel.jurusan1.value?.kuota ?: 0,
                            bandingViewModel.jurusan2.value?.kuota?:0,
                            painterResource(id = R.drawable.ic_kuota),
                            "Kuota"
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        BandingIndicator(
                            bandingViewModel.jurusan1.value?.jumlah_pendaftar ?: 0,
                            bandingViewModel.jurusan2.value?.jumlah_pendaftar?:0,
                            painterResource(id = R.drawable.ic_jml_pendaftar),
                            "Jumlah Pendaftar"
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        BandingIndicator(
                            bandingViewModel.jurusan1.value?.tingkat_ketat ?: 0,
                            bandingViewModel.jurusan2.value?.tingkat_ketat?:0,
                            painterResource(id = R.drawable.ic_tingkat_ketat),
                            "Tingkat Keketatan"
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        BandingIndicator(
                            bandingViewModel.jurusan1.value?.peluang_kerja ?: 0,
                            bandingViewModel.jurusan2.value?.peluang_kerja?:0,
                            painterResource(id = R.drawable.ic_peluang_kerja),
                            "Peluang Kerja"
                        )
                        Spacer(modifier = Modifier.height(100.dp))
                    }
            }
        }
    }
}