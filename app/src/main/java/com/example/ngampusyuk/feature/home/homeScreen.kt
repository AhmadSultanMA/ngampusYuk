package com.example.ngampusyuk.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ngampusyuk.feature.main.components.homeComponents.AppBar
import com.example.ngampusyuk.feature.main.components.homeComponents.Berita
import com.example.ngampusyuk.feature.main.components.homeComponents.Fitur
import com.example.ngampusyuk.feature.main.components.homeComponents.Iklan
import com.example.ngampusyuk.feature.main.components.homeComponents.InfoKampus

@Composable
fun HomeScreen(navController: NavController) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            AppBar(name = "irza", modifier = Modifier.height(180.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Iklan()
            Spacer(modifier = Modifier.height(10.dp))
            InfoKampus()
            Spacer(modifier = Modifier.height(10.dp))
            Fitur()
            Spacer(modifier = Modifier.height(10.dp))
            Berita()
            Spacer(modifier = Modifier.height(20.dp))

        }
    }
}