package com.example.ngampusyuk.feature.statusBayar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ngampusyuk.R
import com.example.ngampusyuk.feature.main.components.statusBayarComponents.AppBar
import com.example.ngampusyuk.feature.main.components.statusBayarComponents.DetailPembayaran
import com.example.ngampusyuk.feature.main.route.Screen
import com.example.ngampusyuk.ui.theme.CustBlue
import com.example.ngampusyuk.ui.theme.CustDarkBlue
import com.example.ngampusyuk.ui.theme.CustSecondary

@Composable
fun StatusBayar(navController: NavController) {
    val viewModel: StatusBayarViewModel = viewModel()

    Column(
        Modifier
            .fillMaxSize()
            .background(CustBlue),
        horizontalAlignment = Alignment.CenterHorizontally
        )
    {
        AppBar()
        Spacer(modifier = Modifier.height(10.dp))
        Image(painter = painterResource(id = R.drawable.ic_status_bayar), contentDescription = "icon", Modifier.size(180.dp))
        Text(text = "Yay, Pembayaran Berhasil !", style = MaterialTheme.typography.titleMedium, color = Color.White)
        Spacer(modifier = Modifier.height(10.dp))
        DetailPembayaran(viewModel.user.value?.nama)
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
                .background(
                    color = CustDarkBlue,
                    shape = RoundedCornerShape(30)
                )
                .padding(vertical = 10.dp)
                .clickable {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.StatusBayar.route) {
                            inclusive = true
                        }
                    }
                },
            contentAlignment = Alignment.Center
        ){
            Text(text = "Selesai", style = MaterialTheme.typography.titleMedium, color = Color.White)
        }
    }
}