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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ngampusyuk.R
import com.example.ngampusyuk.feature.main.components.signUpComponents.EmailField
import com.example.ngampusyuk.feature.main.components.signUpComponents.NamaField
import com.example.ngampusyuk.feature.main.components.signUpComponents.NomorField
import com.example.ngampusyuk.feature.main.components.signUpComponents.PasswordField
import com.example.ngampusyuk.feature.main.route.Screen
import com.example.ngampusyuk.ui.theme.CustDarkBlue
import com.example.ngampusyuk.ui.theme.CustSecondary
import kotlinx.coroutines.delay

@Composable
fun SignUp(modifier : Modifier = Modifier, navController: NavController) {
    val nama = remember { mutableStateOf("") }
    val nomor = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    val viewModel : SignUpViewModel = viewModel()

    LaunchedEffect(viewModel.errMsg.value) {
        if (viewModel.errMsg.value.isNotEmpty()) {
            delay(3000)
            viewModel.errMsg.value = ""
        }
    }

    LaunchedEffect(key1 = viewModel.isSuccess.value){
        if (viewModel.isSuccess.value) {
            navController.navigate(Screen.SignIn.route) {
                popUpTo(Screen.SignUp.route) {
                    inclusive = true
                }
            }
        }
    }

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
        if (viewModel.isLoading.value){
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                CircularProgressIndicator()
            }
        }else{
            Box(
                modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
                    .background(
                        color = CustSecondary,
                        shape = RoundedCornerShape(30)
                    )
                    .padding(vertical = 10.dp)
                    .clickable {
                        if(email.value == "" || password.value == "" || nama.value == "" || nomor.value == ""){
                            viewModel.errMsg.value = "Harap isi semua kolom"
                        }else{
                            viewModel.signUp(email.value, password.value, nama.value, nomor.value)
                        }
                    },
                contentAlignment = Alignment.Center
            ){
                Text(text = "Sign Up", style = MaterialTheme.typography.titleMedium)
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Box(modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp), contentAlignment = Alignment.Center){
            Text(text = viewModel.errMsg.value,style = MaterialTheme.typography.bodySmall, color = Color.Red)
        }

    }
}



