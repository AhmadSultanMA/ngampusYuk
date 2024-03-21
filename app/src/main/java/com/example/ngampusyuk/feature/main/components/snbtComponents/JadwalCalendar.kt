package com.example.ngampusyuk.feature.main.components.snbtComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ngampusyuk.R
import com.example.ngampusyuk.ui.theme.Secondary01

@Composable
fun JadwalCalendar() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = Secondary01)
        .padding(horizontal = 15.dp, vertical = 10.dp),
        contentAlignment = Alignment.Center
    ){
        Image(modifier = Modifier.fillMaxWidth(),painter = painterResource(id = R.drawable.snbt_calendar), contentDescription = "calendar")
    }
}