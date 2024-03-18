package com.example.ngampusyuk.feature.pilihTO

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ngampusyuk.feature.main.components.pilihTOComponents.AppBar
import com.example.ngampusyuk.feature.main.components.pilihTOComponents.TryOutCard

@Composable
fun PilihTO(navController: NavController) {
    val viewModel : TryOutViewModel = viewModel()

    LazyColumn {
        item {
            AppBar(navController)
        }
        items(viewModel.tryOut.size){ index ->
            val to = viewModel.tryOut[index]
            Spacer(modifier = Modifier.height(10.dp))
            TryOutCard(navController, to, viewModel)
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}