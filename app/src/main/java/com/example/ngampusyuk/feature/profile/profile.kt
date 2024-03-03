package com.example.ngampusyuk.feature.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ngampusyuk.R
import com.example.ngampusyuk.feature.main.components.profileComponent.ProfileBar
import com.example.ngampusyuk.feature.main.navigation.BottomNavigationBar
import com.example.ngampusyuk.ui.theme.CustBlue

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(navController : NavController) {
    val widthScreen = LocalConfiguration.current.screenWidthDp.dp
    Scaffold(
        floatingActionButton = {
            EditFloatingButton(
                onClick = {}
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        bottomBar =  {
            BottomAppBar(
                tonalElevation = 8.dp,
                containerColor = Color.White,
            ) {
                BottomNavigationBar(navController = navController)
            }
        }
    ) {
        Column(
            modifier = Modifier
                .background(color = CustBlue)
                .fillMaxSize(),
        ) {
                Box(
                    modifier = Modifier
                        .offset(0.dp, 100.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10))
                        .fillMaxWidth()
                        .padding(bottom = 30.dp)
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .offset(0.dp, -55.dp)
                    ) {
                        Box(modifier = Modifier.fillMaxWidth()) {
                            Image(
                                modifier = Modifier
                                    .width(widthScreen * 0.3f)
                                    .fillMaxWidth()
                                    .align(Alignment.Center),
                                painter = painterResource(id = R.drawable.profil),
                                contentDescription = "profilImage"
                            )
                        }
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Irza",
                            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.SemiBold, textAlign = TextAlign.Center)
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Sekolah Menengah Atas",
                            style = TextStyle(fontSize = 14.sp, color = Color.Gray, textAlign = TextAlign.Center)
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Box(modifier = Modifier.padding(start = 15.dp, end = 15.dp)) {
                            ProfileBar(modifier = Modifier.padding(start = 15.dp, end = 15.dp))
                        }
                    }

                }
            }

    }
}

@Composable
fun EditFloatingButton(onClick: () -> Unit) {
    val heightScreen = LocalConfiguration.current.screenHeightDp.dp
    FloatingActionButton(
        onClick = onClick,
        contentColor = Color.White,
        elevation = FloatingActionButtonDefaults.elevation(8.dp),
        modifier = Modifier.offset(0.dp,-heightScreen+180.dp)
    ) {
        Icon(
            imageVector = Icons.Outlined.Edit,
            tint = Color.Black,
            contentDescription = "Edit",
        )
    }
}