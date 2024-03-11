package com.example.ngampusyuk.feature.main.components.homeComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ngampusyuk.feature.main.route.Screen
import com.example.ngampusyuk.model.kampus.KampusModel

@Composable
fun FilterList(
    filteredList : List<KampusModel>,
    navController : NavController
               ) {
    if (filteredList.isNotEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .offset(0.dp,150.dp)
                    .fillMaxWidth()
                    .background(color = Color.White, shape = RoundedCornerShape(20))
            ) {
                items(filteredList.size) { index ->
                    Text(
                        text = filteredList[index].nama,
                        style = MaterialTheme.typography.bodySmall,
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .clickable {
                                    navController.navigate("${Screen.Universitas.route}/${filteredList[index].id}") {
                                        popUpTo(Screen.Home.route) {
                                            inclusive = true
                                        }
                                    }
                                }
                    )
                }
            }
        }
    }
}