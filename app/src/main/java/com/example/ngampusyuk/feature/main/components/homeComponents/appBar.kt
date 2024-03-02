package com.example.ngampusyuk.feature.main.components.homeComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ngampusyuk.R
import com.example.ngampusyuk.ui.theme.CustBlue


@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    name: String
) {
    val searchText = remember { mutableStateOf("") }
    Box(
        modifier
            .fillMaxSize()
            .background(
                color = CustBlue,
                shape = RoundedCornerShape(
                    bottomStart = 30.dp,
                    bottomEnd = 30.dp
                )
            )
            .padding(15.dp)
    ){
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ){
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
                ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        modifier = Modifier.width((0.5f * 100).dp),
                        painter = painterResource(id = R.drawable.profil),
                        contentDescription = "profilImage"
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Hallo, ${name} !",
                                color = Color.White,
                                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.SemiBold, fontFamily = FontFamily(Font(R.font.poppins_semibold)))
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Icon(
                                modifier = Modifier.size(24.dp),
                                painter = painterResource(id = R.drawable.ic_greet),
                                contentDescription = "iconGreet",
                                tint = Color.White
                            )
                        }

                        Text(
                            text = "Mulai langkahmu disini",
                            color = Color.White,
                            style = TextStyle(fontSize = 15.sp, fontFamily = FontFamily(Font(R.font.poppins_regular))),
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.White, shape = CircleShape),
                    contentAlignment = Alignment.Center,
                    content = {
                        Icon(
                            modifier = Modifier.size(30.dp),
                            imageVector =  Icons.Outlined.Notifications,
                            contentDescription = "iconNotif",
                            tint = Color.Black
                        )
                    }
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            SearchField(value = searchText.value, onValueChange = { searchText.value = it }, Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(20.dp)),

        value = value,
        shape = RoundedCornerShape(20.dp),
        onValueChange = onValueChange,
        placeholder = { Text("Cari Fakultas", color = Color.Black, style = TextStyle(fontFamily = FontFamily(Font(R.font.poppins_regular)))) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "iconSearch",
                tint = Color.Gray
            )
        },
        textStyle = TextStyle(color = Color.Black),
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.White,
            focusedBorderColor = Color.Black
        )
    )
}