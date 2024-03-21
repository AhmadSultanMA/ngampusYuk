package com.example.ngampusyuk.feature.invoice

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.ngampusyuk.data.user.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class InvoiceViewModel : ViewModel() {
    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val auth: FirebaseAuth = FirebaseAuth.getInstance()
    val authRepository = AuthRepository(auth, firestore)
    val isLoading = mutableStateOf(false)

    fun updateUserPremium()
    {
        isLoading.value = true
        authRepository.updateUserPremium(
            auth.currentUser?.uid ?: "",
            onSuccess = {
                isLoading.value = false
            },
            onFailed = {
                isLoading.value = false
            }
        )
    }
}