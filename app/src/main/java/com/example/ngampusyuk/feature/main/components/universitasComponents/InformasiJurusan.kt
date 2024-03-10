package com.example.ngampusyuk.feature.main.components.universitasComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ngampusyuk.model.jurusan.JurusanModel
import com.example.ngampusyuk.ui.theme.CustBlue
import com.example.ngampusyuk.ui.theme.CustLightBlue
import com.example.ngampusyuk.ui.theme.CustSecondary10

@Composable
fun InformasiJurusan(jurusan : List<JurusanModel>, modifier: Modifier = Modifier) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    Column (
        modifier
            .padding(start = 15.dp, end = 15.dp)
            .offset(0.dp, -15.dp)
    ){
        Text(text = "Informasi Jurusan dan Passing Grade", style = TextStyle(fontWeight = FontWeight.Medium, fontSize = 16.sp))
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier
                .background(color = CustBlue, shape = RoundedCornerShape(20))
                .padding(vertical = 15.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Text(text = "SAINS DAN TEKNOLOGI", style = TextStyle(color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 16.sp))
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier
                .fillMaxWidth()
                .background(
                    color = CustSecondary10,
                    shape = RoundedCornerShape(topEndPercent = 20, topStartPercent = 20)
                )
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Program Studi", style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 16.sp))
            Column(modifier.width(screenWidth * 0.35f)) {
                Text(
                    text = "Nilai Skor",
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 16.sp),
                    textAlign = TextAlign.Center
                )
                Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "SNBP", style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 16.sp))
                    Text(text = "SNBT", style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 16.sp))
                }
            }
        }
        Box(
            modifier
                .fillMaxWidth()
                .background(
                    color = CustLightBlue,
                    shape = RoundedCornerShape(bottomStartPercent = 20, bottomEndPercent = 20)
                )
                .padding(15.dp)

        ){
            Column {
                for (jurusans in jurusan){
                    if (jurusans.tipe == 1L){
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text(text = jurusans.nama_jurusan, style = TextStyle(fontSize = 14.sp))
                            Row(modifier.width(screenWidth * 0.35f),horizontalArrangement = Arrangement.SpaceBetween) {
                                Text(text = jurusans.snbp.toString(), style = TextStyle(fontSize = 14.sp))
                                Text(text = jurusans.snbt.toString(), style = TextStyle(fontSize = 14.sp))
                            }
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        if (jurusan.any{it.tipe == 2L}) {
            Box(
                modifier
                    .background(color = CustBlue, shape = RoundedCornerShape(20))
                    .padding(vertical = 15.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "SOSIAL HUMANIORA",
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier
                    .fillMaxWidth()
                    .background(
                        color = CustSecondary10,
                        shape = RoundedCornerShape(topEndPercent = 20, topStartPercent = 20)
                    )
                    .padding(15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Program Studi",
                    style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                )
                Column(modifier.width(screenWidth * 0.35f)) {
                    Text(
                        text = "Nilai Skor",
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 16.sp),
                        textAlign = TextAlign.Center
                    )
                    Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(
                            text = "SNBP",
                            style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                        )
                        Text(
                            text = "SNBT",
                            style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                        )
                    }
                }
            }
            Box(
                modifier
                    .fillMaxWidth()

                    .background(
                        color = CustLightBlue,
                        shape = RoundedCornerShape(bottomStartPercent = 20, bottomEndPercent = 20)
                    )
                    .padding(15.dp)

            ) {
                for (jurusans in jurusan) {
                    if(jurusans.tipe == 2L){
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text(text = jurusans.nama_jurusan, style = TextStyle(fontSize = 14.sp))
                            Row(
                                modifier.width(screenWidth * 0.35f),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = jurusans.snbp.toString(),
                                    style = TextStyle(fontSize = 14.sp)
                                )
                                Text(
                                    text = jurusans.snbt.toString(),
                                    style = TextStyle(fontSize = 14.sp)
                                )
                            }
                        }
                    }
                }

            }
        }
    }
}