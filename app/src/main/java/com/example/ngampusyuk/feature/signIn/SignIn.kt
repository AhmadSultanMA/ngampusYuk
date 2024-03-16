package com.example.ngampusyuk.feature.signIn

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ngampusyuk.R
import com.example.ngampusyuk.ui.theme.CustDarkBlue
import com.example.ngampusyuk.ui.theme.CustSecondary
import com.example.ngampusyuk.feature.main.route.Screen
import kotlinx.coroutines.delay


@Composable
fun SignIn(navController: NavController) {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    val viewModel : SignInViewModel = viewModel()

    LaunchedEffect(viewModel.errMsg.value) {
        if (viewModel.errMsg.value.isNotEmpty()) {
            delay(3000)
            viewModel.errMsg.value = ""
        }
    }

    LaunchedEffect(key1 = viewModel.isLogin.value){
        if(viewModel.isLogin.value == true){
            navController.navigate(Screen.Home.route) {
                popUpTo(Screen.SignIn.route) {
                    inclusive = true
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .background(color = CustSecondary)
            .fillMaxSize(),
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            modifier = Modifier.height(screenHeight*0.3f),
            painter = painterResource(id = R.drawable.top_signin),
            contentDescription = "topSignIn"
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight * 0.75f)

        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(-20.dp, 30.dp),
                painter = painterResource(id = R.drawable.bottom_signin),
                contentDescription = "bottomSignIn"
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White, shape = RoundedCornerShape(30.dp))
                    .padding(horizontal = 40.dp)
                    .height(screenHeight * 0.55f)
            ) {
               Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
                   Spacer(modifier = Modifier.height(10.dp))
                   Text(modifier = Modifier.fillMaxWidth(),
                       text = "Sign In",
                       style = TextStyle(
                           fontSize = 32.sp,
                           fontWeight = FontWeight.SemiBold,
                           textAlign = TextAlign.Center
                       )
                   )

                   Column {
                       Text(text = "Email",
                           style = TextStyle(
                               fontSize = 16.sp,
                               fontWeight = FontWeight.SemiBold,
                           )
                       )
                       Spacer(modifier = Modifier.height(10.dp))
                       EmailField(value = email.value, onValueChange = { email.value = it },Modifier.height(50.dp))
                       Spacer(modifier = Modifier.height(10.dp))
                       Text(text = "Password",
                           style = TextStyle(
                               fontSize = 16.sp,
                               fontWeight = FontWeight.SemiBold,
                           )
                       )
                       Spacer(modifier = Modifier.height(10.dp))
                       PasswordField(value = password.value, onValueChange = { password.value = it },Modifier.height(50.dp))
                   }

                   if (viewModel.isLoading.value){
                       Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                           CircularProgressIndicator()
                       }
                   }else{
                       Box(modifier = Modifier
                           .fillMaxWidth()
                           .background(color = CustDarkBlue, shape = RoundedCornerShape(20.dp))
                           .clickable {
//                               if(email.value == "" || password.value == ""){
//                                   viewModel.errMsg.value = "Harap isi semua kolom"
//                               }else{
                                   viewModel.signIn(
                                       //email.value,password.value
                                       "ahmad.irza18@gmail.com", "12345678"
                                   )
//                               }
                           },
                           contentAlignment = Alignment.Center,

                           ){
                           Text(modifier = Modifier.padding(vertical = 10.dp),text = "Sign In", style = TextStyle(color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 19.sp))
                       }
                   }

                   Spacer(modifier = Modifier.height(5.dp))
                   Box(modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp), contentAlignment = Alignment.Center){
                       Text(text = viewModel.errMsg.value,style = MaterialTheme.typography.bodySmall, color = Color.Red)
                   }

                   Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                       Text(text = "Don't have an account?", style = TextStyle(color = Color.Gray, fontSize = 12.sp))
                       Spacer(modifier = Modifier.width(5.dp))
                       Text(
                           modifier = Modifier.clickable {
                           navController.navigate(Screen.SignUp.route) {
                               popUpTo(Screen.SignIn.route) {
                                   inclusive = true
                               }
                           }},
                           text = "Sign Up", style = TextStyle(color = CustDarkBlue, fontSize = 12.sp))
                   }
                   Spacer(modifier = Modifier.height(10.dp))
               }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier
            .fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            Color.Black,
            unfocusedIndicatorColor = Color.Black,
            focusedIndicatorColor = Color.Black,
            focusedSupportingTextColor = Color.Black,
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier
            .fillMaxWidth(),
        visualTransformation = PasswordVisualTransformation(),
        colors = TextFieldDefaults.textFieldColors(
            Color.Black,
            unfocusedIndicatorColor = Color.Black,
            focusedIndicatorColor = Color.Black,
            focusedSupportingTextColor = Color.Black,
        )
    )
}