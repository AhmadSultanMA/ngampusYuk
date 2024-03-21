package com.example.ngampusyuk.feature.invoice

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ngampusyuk.feature.main.components.invoiceComponents.AppBar
import com.example.ngampusyuk.feature.main.components.invoiceComponents.DetailPembayaran
import com.example.ngampusyuk.feature.main.components.invoiceComponents.DetailPemesanan
import com.example.ngampusyuk.feature.main.route.Screen
import com.example.ngampusyuk.ui.theme.CustDarkBlue

@Composable
fun Invoice(navController: NavController) {
    val viewModel: InvoiceViewModel = viewModel()

    LazyColumn(
        Modifier
            .fillMaxSize()
            .background(color = Color.White))
    {
        item {
            AppBar(navController)
            Spacer(modifier = Modifier.height(10.dp))
            DetailPemesanan()
            Spacer(modifier = Modifier.height(20.dp))
            DetailPembayaran()
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier.padding(horizontal = 15.dp),
                text = "Dengan menekan tombol “beli paket” maka anda menyatakan telah meyetujui pembelian paket ini dan tidak dapat dibatalkan.",
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))
            if (viewModel.isLoading.value){
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                    CircularProgressIndicator()
                }
            }else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 50.dp)
                        .background(color = CustDarkBlue, shape = RoundedCornerShape(20.dp))
                        .clickable {
                            viewModel.updateUserPremium()
                            navController.navigate(Screen.StatusBayar.route) {
                                popUpTo(Screen.Invoice.route) {
                                    inclusive = true
                                }
                            }
                        },
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        modifier = Modifier.padding(vertical = 10.dp),
                        text = "Beli Paket",
                        style = MaterialTheme.typography.titleSmall, color = Color.White
                    )
                }
            }
        }
    }
}