package com.example.ngampusyuk.feature.main.components.homeComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ngampusyuk.R
import com.example.ngampusyuk.feature.main.route.Screen

@Composable
fun Berita(navController : NavController,modifier : Modifier = Modifier) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    Column(
        modifier.padding(start = 15.dp, end = 15.dp)
    ) {
        Text(
            text = "Berita",
            color = Color.Black,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier.height(10.dp))
        Row(modifier.fillMaxWidth() ,horizontalArrangement = Arrangement.SpaceBetween) {
            Box(modifier.width(screenWidth*0.44f).clickable {
                navController.navigate(Screen.Berita.route) {
                    popUpTo(Screen.Home.route) {
                        inclusive = true
                    }
                }
            }){

                BeritaCard(
                    painter = painterResource(id = R.drawable.berita1),
                    contentDesc = "berita1",
                    title = "UGM Siap Terima 10.000 Mahasiswa dalam Penerimaan Mahasiswa Baru 2024"
                )
            }
            Box(modifier.width(screenWidth*0.44f)){
                BeritaCard(
                    painter = painterResource(id = R.drawable.berita1),
                    contentDesc = "berita1",
                    title = "UGM Siap Terima 10.000 Mahasiswa dalam Penerimaan Mahasiswa Baru 2024"
                )
            }
        }
    }
}

@Composable
fun BeritaCard(
    painter : Painter,
    contentDesc : String,
    title : String,
    modifier : Modifier = Modifier
) {
    Card(
        modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Box(modifier.height(180.dp)){
            Image(painter = painter, contentDescription = contentDesc, contentScale = ContentScale.Crop)
            Box(modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f
                    )
                )
            )
            Box(
                modifier
                    .fillMaxSize()
                    .padding(15.dp),
                contentAlignment = Alignment.BottomCenter
            ){
                Text(text = title, style = TextStyle(color = Color.White, fontSize = 10.sp))
            }
        }
    }
}