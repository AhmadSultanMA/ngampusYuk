package com.example.ngampusyuk.feature.signIn

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.ngampusyuk.data.user.AuthRepository
import com.example.ngampusyuk.model.kampus.KampusModel
import com.example.ngampusyuk.model.user.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class SignInViewModel: ViewModel() {
    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val auth: FirebaseAuth = FirebaseAuth.getInstance()
    val authRepository = AuthRepository(auth, firestore)

    val isLogin = mutableStateOf(false)
    val isLoading = mutableStateOf(false)

    val errMsg = mutableStateOf("")

    fun signIn(
        email : String,
        password : String,
    ){
        isLoading.value = true
        authRepository.signIn(
            email,
            password,
            onSuccess = {
                isLoading.value = false
                isLogin.value = it
            },
            onFailed = {
                isLoading.value = false
                errMsg.value = it.toString()
            }
        )
    }
}