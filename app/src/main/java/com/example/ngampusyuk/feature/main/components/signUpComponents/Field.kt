package com.example.ngampusyuk.feature.main.components.signUpComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.ngampusyuk.R

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun NamaField(
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
        onValueChange = {
            onValueChange(it)
        },
        placeholder = {
            Text("Masukkan Nama", color = Color.Black,
                style = MaterialTheme.typography.labelMedium
            ) },
        leadingIcon = {
            Icon(
                painterResource(id = R.drawable.ic_nama_signup),
                contentDescription = "iconSearch",
                tint = Color.Gray,
                modifier = Modifier.size(25.dp)
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

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun NomorField(
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
        onValueChange = {
            val filter = it.filter { it.isDigit() }
            onValueChange(filter)
        },
        placeholder = {
            Text("08xxxxx", color = Color.Black,
                style = MaterialTheme.typography.labelMedium
            ) },
        leadingIcon = {
            Icon(
                painterResource(id = R.drawable.ic_tele_signup),
                contentDescription = "iconSearch",
                tint = Color.Gray,
                modifier = Modifier.size(25.dp)
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

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun EmailField(
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
        onValueChange = {
            onValueChange(it)
        },
        placeholder = {
            Text("Email", color = Color.Black,
                style = MaterialTheme.typography.labelMedium
            ) },
        leadingIcon = {
            Icon(
                painterResource(id = R.drawable.ic_email_signup),
                contentDescription = "iconSearch",
                tint = Color.Gray,
                modifier = Modifier.size(25.dp)
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

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun PasswordField(
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
        onValueChange = {
            onValueChange(it)
        },
        placeholder = {
            Text("Password", color = Color.Black,
                style = MaterialTheme.typography.labelMedium
            ) },
        leadingIcon = {
            Icon(
                painterResource(id = R.drawable.ic_pass_signup),
                contentDescription = "iconSearch",
                tint = Color.Gray,
                modifier = Modifier.size(25.dp)
            )
        },
        visualTransformation = PasswordVisualTransformation(),
        textStyle = TextStyle(color = Color.Black),
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.White,
            focusedBorderColor = Color.Black
        )
    )
}



