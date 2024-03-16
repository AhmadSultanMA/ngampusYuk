package com.example.ngampusyuk.feature.banding

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ngampusyuk.R
import com.example.ngampusyuk.feature.main.navigation.BottomNavigationBar
import com.example.ngampusyuk.feature.main.route.Screen
import com.example.ngampusyuk.feature.pilihBanding.PilihBandingViewModel
import com.example.ngampusyuk.ui.theme.CustBlue
import com.example.ngampusyuk.ui.theme.CustDarkBlue

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Banding(navController: NavController, bandingViewModel: PilihBandingViewModel) {
    Scaffold(
        bottomBar =  {
            BottomAppBar(
                tonalElevation = 8.dp,
                containerColor = Color.White,
            ) {
                BottomNavigationBar(navController = navController)
            }
        }) {
        Box(
            modifier = Modifier
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
                .padding(bottom = 180.dp), contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 15.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.vs),
                    contentDescription = "vs",
                    Modifier.size(144.dp)
                )
                Text(
                    text = "Banding Jurusan",
                    style = TextStyle(fontSize = 36.sp, fontWeight = FontWeight.Medium)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Bandingkan jurusan dan kampus yang kamu inginkan, yuk!",
                    style = TextStyle(fontSize = 16.sp, textAlign = TextAlign.Center)
                )
                Spacer(modifier = Modifier.height(50.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .background(color = CustDarkBlue, shape = RoundedCornerShape(20.dp))
                        .clickable {
                            bandingViewModel.jurusan1.value = null
                            bandingViewModel.jurusan2.value = null
                            bandingViewModel.kampus1.value = null
                            bandingViewModel.kampus2.value = null
                            navController.navigate(Screen.PilihBanding.route) {
                                popUpTo(Screen.Banding.route) {
                                    inclusive = true
                                }
                            }
                        },
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        modifier = Modifier.padding(vertical = 10.dp),
                        text = "Mulai Sekarang",
                        style = TextStyle(
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 19.sp
                        )
                    )
                }
            }
        }
    }
}