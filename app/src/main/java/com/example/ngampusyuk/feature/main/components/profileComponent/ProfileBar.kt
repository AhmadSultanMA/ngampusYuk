package com.example.ngampusyuk.feature.main.components.profileComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ngampusyuk.ui.theme.CustSecondary

@Composable
fun ProfileBar(modifier: Modifier = Modifier) {
    val profileItems = listOf(
        ProfileItem.Pengaturan,
        ProfileItem.Info,
        ProfileItem.Pusat,
        ProfileItem.Tentang,
        ProfileItem.Hapus,
        ProfileItem.Keluar,
    )

    Column {
        profileItems.forEach { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                )
                ) {
                Row(
                    modifier = Modifier
                        .background(color = CustSecondary, shape = RoundedCornerShape(12.dp))
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(modifier.padding(start = 10.dp)) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.label,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = item.label, style = TextStyle(fontSize = 16.sp),modifier = Modifier.padding(top = 15.dp, bottom = 15.dp))
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}