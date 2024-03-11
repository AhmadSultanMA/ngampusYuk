package com.example.ngampusyuk.feature.berita

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.ngampusyuk.R
import com.example.ngampusyuk.feature.main.components.beritaComponents.AppBar
import com.example.ngampusyuk.feature.universitas.UniversitasViewModel

@Composable
fun Berita(navController: NavController, id : String, modifier : Modifier = Modifier) {
    val viewModel : BeritaViewModel = viewModel()

    LaunchedEffect(key1 = true){
        viewModel.getBeritaById(id)
    }

    LazyColumn{
        item {
            AppBar(navController)
            Column(modifier.padding(15.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(painter = painterResource(id = R.drawable.ic_berita1), contentDescription = "icon1")
                    Text(text = " ${viewModel.berita.value?.email_berita ?: ""}", style = TextStyle(fontSize = 12.sp))
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(painter = painterResource(id = R.drawable.ic_berita2), contentDescription = "icon1")
                    Text(text =" ${viewModel.berita.value?.tanggal_berita ?: ""}" , style = TextStyle(fontSize = 12.sp))
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(painter = painterResource(id = R.drawable.ic_berita3), contentDescription = "icon1")
                    Text(text = " Oleh: ${viewModel.berita.value?.penulis_berita ?: ""}", style = TextStyle(fontSize = 12.sp))
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = viewModel.berita.value?.judul_berita ?: "",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium)
                )
                Spacer(modifier = Modifier.height(10.dp))
                AsyncImage(model = viewModel.berita.value?.gambar_berita ?: "", contentDescription = "gambar", modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = viewModel.berita.value?.isi_berita ?: "",
                    style = TextStyle(fontSize = 12.sp, textAlign = TextAlign.Justify)
                    )
            }
        }
    }
}

