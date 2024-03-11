package com.example.ngampusyuk.feature.signUp

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ngampusyuk.R
import com.example.ngampusyuk.feature.home.HomeViewModel
import com.example.ngampusyuk.feature.main.components.signUpComponents.EmailField
import com.example.ngampusyuk.feature.main.components.signUpComponents.NamaField
import com.example.ngampusyuk.feature.main.components.signUpComponents.NomorField
import com.example.ngampusyuk.feature.main.components.signUpComponents.PasswordField
import com.example.ngampusyuk.feature.main.route.Screen
import com.example.ngampusyuk.model.kampus.KampusModel
import com.example.ngampusyuk.ui.theme.CustDarkBlue
import com.example.ngampusyuk.ui.theme.CustSecondary

@Composable
fun SignUp(modifier : Modifier = Modifier, navController: NavController) {
    val nama = remember { mutableStateOf("") }
    val nomor = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start
    ) {
        Column(
            modifier
                .fillMaxWidth()
                .background(
                    color = CustSecondary,
                    shape = RoundedCornerShape(bottomStartPercent = 10, bottomEndPercent = 10)
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = R.drawable.bottom_signin),
                contentDescription = "bottomSignIn"
            )
            Text(text = "Create An Account", style = TextStyle(fontSize = 36.sp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = "Already have an account?", style = TextStyle(color = Color.Black, fontSize = 12.sp))
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    modifier = Modifier.clickable {
                        navController.navigate(Screen.SignIn.route) {
                            popUpTo(Screen.SignUp.route) {
                                inclusive = true
                            }
                        }},
                    text = "Sign In", style = TextStyle(color = CustDarkBlue, fontSize = 12.sp))
            }
            Spacer(modifier = Modifier.height(50.dp))
            NamaField(value = nama.value, onValueChange = { nama.value = it }, modifier.padding(horizontal = 15.dp))
            Spacer(modifier = Modifier.height(10.dp))
            NomorField(value = nomor.value, onValueChange = { nomor.value = it }, modifier.padding(horizontal = 15.dp))
            Spacer(modifier = Modifier.height(10.dp))
            EmailField(value = email.value, onValueChange = { email.value = it }, modifier.padding(horizontal = 15.dp))
            Spacer(modifier = Modifier.height(10.dp))
            PasswordField(value = password.value, onValueChange = { password.value = it }, modifier.padding(horizontal = 15.dp))
            Spacer(modifier = Modifier.height(40.dp))
        }
        Spacer(modifier = Modifier.height(50.dp))
        Box(
            modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
                .background(
                    color = CustSecondary,
                    shape = RoundedCornerShape(30)
                )
                .padding(vertical = 10.dp),
            contentAlignment = Alignment.Center
        ){
            Text(text = "Sign Up", style = MaterialTheme.typography.titleMedium)
        }
    }
}



