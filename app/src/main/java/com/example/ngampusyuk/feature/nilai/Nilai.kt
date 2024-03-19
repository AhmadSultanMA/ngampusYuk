package com.example.ngampusyuk.feature.nilai

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.ngampusyuk.feature.main.route.Screen

@Composable
fun Nilai(navController: NavController) {
    Column {
        IconButton(
            onClick = {
                navController.navigate(Screen.PilihTO.route) {
                    popUpTo(Screen.Nilai.route) {
                        inclusive = true
                    }
                }
            }) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.Black
            )
        }
        Text(text = "ini nilai")
    }

}