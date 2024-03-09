package com.example.ngampusyuk.feature.pilihUniv

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
import com.example.ngampusyuk.ui.theme.CustBlue

@Composable
fun PilihUniv(navController: NavController, modifier : Modifier = Modifier) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    Box(modifier = Modifier
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
    ){
        Column(modifier.padding(15.dp)) {
            Box(
                modifier
                    .fillMaxWidth()
                    .background(color = Color.White, shape = RoundedCornerShape(30))
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center){
                Text(text = "Pilih Universitas", style = MaterialTheme.typography.labelLarge)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier
                    .fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween)
            {
                Box(modifier.width(screenWidth*0.44f)) {
                    UnivCard(
                        painter = painterResource(id = R.drawable.gedung_ui),
                        contentDesc = "gedungUI",
                        title = "UI"
                    )
                }
                Box(modifier.width(screenWidth*0.44f)) {
                    UnivCard(
                        painter = painterResource(id = R.drawable.gedung_ui),
                        contentDesc = "gedungUI",
                        title = "UI"
                    )
                }
            }
        }
    }
}

@Composable
fun UnivCard(
    painter : Painter,
    contentDesc : String,
    title : String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Box(modifier.height(180.dp)){
            Image(modifier = Modifier.fillMaxSize(),painter = painter, contentDescription = contentDesc, contentScale = ContentScale.Crop)
            Box(
                modifier
                    .fillMaxSize()
                    .padding(15.dp),
                contentAlignment = Alignment.TopEnd
            ){
                Text(text = title, style = MaterialTheme.typography.titleSmall)
            }
        }
    }
}