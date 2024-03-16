package com.example.ngampusyuk.feature.main.components.hasilBandingComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ngampusyuk.feature.pilihBanding.PilihBandingViewModel
import com.example.ngampusyuk.ui.theme.CustGray

@Composable
fun InformasiKampus(bandingViewModel: PilihBandingViewModel) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Text(text = bandingViewModel.kampus1.value?.nama ?: "")
        Text(text = bandingViewModel.kampus2.value?.nama ?: "")
    }
    Row(
        Modifier.fillMaxWidth(0.85f),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(model = bandingViewModel.kampus1.value?.logo ?: "", contentDescription = "logo")
        AsyncImage(model = bandingViewModel.kampus2.value?.logo ?: "", contentDescription = "logo")
    }
    Spacer(modifier = Modifier.height(10.dp))
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier
            .width(150.dp)
            .height(25.dp)
            .background(color = CustGray, shape = RoundedCornerShape(50)),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Akreditasi ${bandingViewModel.jurusan1.value?.akreditasi ?: ""}",
                style = MaterialTheme.typography.bodySmall
            )
        }
        Box(modifier = Modifier
            .width(150.dp)
            .height(25.dp)
            .background(color = CustGray, shape = RoundedCornerShape(50)),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Akreditasi ${bandingViewModel.jurusan2.value?.akreditasi ?: ""}",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier
            .width(150.dp)
            .height(25.dp)
            .background(color = CustGray, shape = RoundedCornerShape(50)),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = bandingViewModel.jurusan1.value?.nama_jurusan ?: "",
                style = MaterialTheme.typography.bodySmall
            )
        }
        Box(modifier = Modifier
            .width(150.dp)
            .height(25.dp)
            .background(color = CustGray, shape = RoundedCornerShape(50)),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = bandingViewModel.jurusan2.value?.nama_jurusan ?: "",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = CustGray, shape = RoundedCornerShape(50))
        .height(30.dp),
    ){
        Row(Modifier.fillMaxSize().padding(horizontal = 15.dp),horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = bandingViewModel.jurusan1.value?.ukt_minimal ?: "",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "UKT Minimal",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = bandingViewModel.jurusan2.value?.ukt_minimal ?: "",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = CustGray, shape = RoundedCornerShape(50))
        .height(30.dp),
    ){
        Row(Modifier.fillMaxSize().padding(horizontal = 15.dp),horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = bandingViewModel.jurusan1.value?.ukt_maximal ?: "",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "UKT Maximal",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = bandingViewModel.jurusan2.value?.ukt_maximal ?: "",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = CustGray, shape = RoundedCornerShape(50))
        .height(30.dp),
    ){
        Row(Modifier.fillMaxSize().padding(horizontal = 15.dp),horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = bandingViewModel.jurusan1.value?.jalur_masuk ?: "",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "Jalur Masuk",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = bandingViewModel.jurusan2.value?.jalur_masuk ?: "",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}