package com.example.ngampusyuk.feature.editProfile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ngampusyuk.R
import com.example.ngampusyuk.feature.main.route.Screen
import com.example.ngampusyuk.ui.theme.CustBlue
import com.example.ngampusyuk.ui.theme.CustDarkBlue
import kotlin.math.round

@Composable
fun EditProfile(navController: NavController) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    Column(verticalArrangement = Arrangement.Center, modifier = Modifier
        .fillMaxSize()
        .background(color = CustBlue)) {
        Box(modifier = Modifier
            .background(color = Color.White, shape = RoundedCornerShape(10))
            .padding(start = 25.dp, end = 25.dp)){
            Column(modifier = Modifier.offset(0.dp, -45.dp)) {
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center) {
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(100)
                            )
                            .width((0.9f * 100).dp)
                            .height((0.9f * 100).dp)
                            .border(
                                border = BorderStroke(1.dp, Color.Black),
                                shape = RoundedCornerShape(100)
                            ),
                    ){
                        Image(
                            modifier = Modifier
                                .size(64.dp)
                                .align(Alignment.Center),
                            painter = painterResource(id = R.drawable.ic_man),
                            contentDescription = "iconMan"
                        )
                    }
                    Spacer(modifier = Modifier.width(60.dp))
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(100)
                            )
                            .width((0.9f * 100).dp)
                            .height((0.9f * 100).dp)
                            .border(
                                border = BorderStroke(1.dp, Color.Black),
                                shape = RoundedCornerShape(100)
                            ),
                    ){
                        Image(
                            modifier = Modifier
                                .size(72.dp)
                                .align(Alignment.Center),
                            painter = painterResource(id = R.drawable.ic_women),
                            contentDescription = "iconWoman"
                        )
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "Nama", style = TextStyle(fontSize = 13.sp))
                Spacer(modifier = Modifier.height(10.dp))
                NamaField(value = "", onValueChange = {}, Modifier.height(50.dp))

                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "Jenjang", style = TextStyle(fontSize = 13.sp))
                Spacer(modifier = Modifier.height(10.dp))
                NamaField(value = "", onValueChange = {}, Modifier.height(50.dp))

                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "Email", style = TextStyle(fontSize = 13.sp))
                Spacer(modifier = Modifier.height(10.dp))
                NamaField(value = "", onValueChange = {}, Modifier.height(50.dp))

                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "Password", style = TextStyle(fontSize = 13.sp))
                Spacer(modifier = Modifier.height(10.dp))
                NamaField(value = "", onValueChange = {}, Modifier.height(50.dp))

                Spacer(modifier = Modifier.height(20.dp))
                Row(horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                    .fillMaxWidth()
                ) {
                    Box(modifier = Modifier
                        .width(screenWidth * 0.37f)
                        .background(color = Color.White, shape = RoundedCornerShape(20.dp))
                        .border(border = BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(20.dp)),
                        contentAlignment = Alignment.Center,
                    ){
                        Text(modifier = Modifier.padding(vertical = 10.dp),text = "Batal", style = TextStyle(color = Color.Black, fontWeight = FontWeight.SemiBold, fontSize = 19.sp))
                    }

                    Box(modifier = Modifier
                        .width(screenWidth * 0.37f)
                        .background(color = CustDarkBlue, shape = RoundedCornerShape(20.dp)),
                        contentAlignment = Alignment.Center,
                    ){
                        Text(modifier = Modifier.padding(vertical = 10.dp),text = "Simpan", style = TextStyle(color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 19.sp))
                    }
                }

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NamaField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card( modifier = modifier
        .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
        defaultElevation = 8.dp
    )) {
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(20.dp)),
            value = value,
            shape = RoundedCornerShape(20.dp),
            onValueChange = onValueChange,
            textStyle = TextStyle(color = Color.Black),
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.White,
                focusedBorderColor = Color.Black
            )
        )
    }
}