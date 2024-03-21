package com.example.ngampusyuk.feature.main.components.snbtComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.ngampusyuk.ui.theme.CustBlue
import com.example.ngampusyuk.ui.theme.CustDarkBlue
import com.example.ngampusyuk.ui.theme.CustYellow

@Composable
fun SemuaPersyaratan(selectedItem: MutableState<String>) {
    Column(Modifier.padding(horizontal = 15.dp)) {
        Text(text = "Persyaratan SNBT", style = MaterialTheme.typography.labelSmall)
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "Ketahui persyaratan SNBT mulai sekarang",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = CustBlue, shape = RoundedCornerShape(20)),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ))
        {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(color = CustBlue)
                .padding(horizontal = 10.dp, vertical = 5.dp)
            ){
                Column(Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "15 April, 2024", style = MaterialTheme.typography.bodySmall, color = Color.White)
                        Box(
                            modifier = Modifier
                                .background(color = CustDarkBlue, shape = RoundedCornerShape(20))
                                .clickable { selectedItem.value = "Persyaratan" },
                            contentAlignment = Alignment.Center)
                        {
                            Text(
                                modifier = Modifier
                                    .padding(horizontal = 8.dp, vertical = 4.dp),
                                text = "Lanjutkan",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.White
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "Persyaratan Umum", style = MaterialTheme.typography.labelSmall, color = Color.White)
                        Text(text = "Progress 15%", style = MaterialTheme.typography.bodySmall, color = Color.White)
                    }
                    LinearProgressIndicator(
                        progress = 15/100f,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(
                                shape = RoundedCornerShape(
                                    topStartPercent = 20,
                                    bottomStartPercent = 20
                                )
                            ),
                        color = Color.White,
                        trackColor = CustDarkBlue
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = CustBlue, shape = RoundedCornerShape(20)),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ))
        {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(color = CustBlue)
                .padding(horizontal = 10.dp, vertical = 5.dp)
            ){
                Column(Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "15 April, 2024", style = MaterialTheme.typography.bodySmall, color = Color.White)
                        Box(
                            modifier = Modifier
                                .background(color = CustDarkBlue, shape = RoundedCornerShape(20))
                                .clickable { selectedItem.value = "Persyaratan" },
                            contentAlignment = Alignment.Center)
                        {
                            Text(
                                modifier = Modifier
                                    .padding(horizontal = 8.dp, vertical = 4.dp),
                                text = "Lanjutkan",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.White
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "Persyaratan Akademik", style = MaterialTheme.typography.labelSmall, color = Color.White)
                        Text(text = "Progress 30%", style = MaterialTheme.typography.bodySmall, color = Color.White)
                    }
                    LinearProgressIndicator(
                        progress = 30/100f,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(
                                shape = RoundedCornerShape(
                                    topStartPercent = 20,
                                    bottomStartPercent = 20
                                )
                            ),
                        color = Color.White,
                        trackColor = CustDarkBlue
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = CustBlue, shape = RoundedCornerShape(20)),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ))
        {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(color = CustBlue)
                .padding(horizontal = 10.dp, vertical = 5.dp)
            ){
                Column(Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "15 April, 2024", style = MaterialTheme.typography.bodySmall, color = Color.White)
                        Box(
                            modifier = Modifier
                                .background(color = CustDarkBlue, shape = RoundedCornerShape(20))
                                .clickable { selectedItem.value = "Persyaratan" },
                            contentAlignment = Alignment.Center)
                        {
                            Text(
                                modifier = Modifier
                                    .padding(horizontal = 8.dp, vertical = 4.dp),
                                text = "Lanjutkan",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.White
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "Persyaratan Lainnya", style = MaterialTheme.typography.labelSmall, color = Color.White)
                        Text(text = "Progress 20%", style = MaterialTheme.typography.bodySmall, color = Color.White)
                    }
                    LinearProgressIndicator(
                        progress = 20/100f,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(
                                shape = RoundedCornerShape(
                                    topStartPercent = 20,
                                    bottomStartPercent = 20
                                )
                            ),
                        color = Color.White,
                        trackColor = CustDarkBlue
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
        }
    }
}