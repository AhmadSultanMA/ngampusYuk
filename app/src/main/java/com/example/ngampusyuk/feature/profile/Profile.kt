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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ngampusyuk.R
import com.example.ngampusyuk.feature.main.components.profileComponents.TryOutCard
import com.example.ngampusyuk.feature.main.navigation.BottomNavigationBar
import com.example.ngampusyuk.feature.main.route.Screen
import com.example.ngampusyuk.ui.theme.CustBlue
import com.example.ngampusyuk.ui.theme.CustSecondary

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(navController : NavController) {
    val viewModel : ProfileViewModel = viewModel()

    Scaffold(
        floatingActionButton = {
            EditFloatingButton(
                onClick = {
                    navController.navigate(Screen.EditProfile.route){
                        popUpTo(Screen.Profil.route) {
                            inclusive = true
                        }
                    }
                }
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
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            CustSecondary,
                            Color.White
                        ),
                        startY = 1f
                    )
                ),
        ) {
            item {
                Spacer(modifier = Modifier.height(30.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Column{
                        Box(modifier = Modifier.fillMaxWidth()) {
                            Image(
                                modifier = Modifier
                                    .size(122.dp)
                                    .align(Alignment.Center),
                                painter = painterResource(id = R.drawable.profil),
                                contentDescription = "profilImage"
                            )
                        }
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Irza",
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                }
            }
            item{
                Box(modifier = Modifier.padding(horizontal = 15.dp)) {
                    Text(text = "Riwayat Try Out", style = MaterialTheme.typography.titleSmall)
                }
            }
            items(viewModel.allTO.size){ index->
                val tryout = viewModel.allTO[index]
                TryOutCard(navController, tryout)
                Spacer(modifier = Modifier.height(15.dp))
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