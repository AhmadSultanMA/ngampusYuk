package com.example.ngampusyuk.feature.statusBayar

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.ngampusyuk.data.user.AuthRepository
import com.example.ngampusyuk.model.user.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class StatusBayarViewModel : ViewModel() {
    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    val authRepository = AuthRepository(auth, firestore)
    val user = mutableStateOf<UserModel?>(null)
    init {
        authRepository.getUser(
            auth.currentUser?.uid ?: "",
            onSuccess = {user.value = it},
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }
}