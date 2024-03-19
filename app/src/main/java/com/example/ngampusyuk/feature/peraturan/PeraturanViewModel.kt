package com.example.ngampusyuk.feature.peraturan

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.ngampusyuk.data.Repository
import com.example.ngampusyuk.data.user.AuthRepository
import com.example.ngampusyuk.model.soal.SoalModel
import com.example.ngampusyuk.model.tryout.TryOutModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class PeraturanViewModel : ViewModel() {
    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val auth: FirebaseAuth = FirebaseAuth.getInstance()
    val authRepository = AuthRepository(auth, firestore)
    val repository = Repository(firestore)

    val data = mutableStateOf<TryOutModel?>(null)
    val soal = mutableStateListOf<SoalModel>()
    val tryout_user_id = mutableStateOf("")

    val isLoading = mutableStateOf(false)
    val isSuccess = mutableStateOf(false)

    fun getTOById(
        id : String
    ){
        repository.getTOById(
            id,
            onSuccess = {data.value = it},
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }

    fun getAllSoal(
        id : String
    ){
        repository.getAllSoal(
            id,
            onSuccess = {soal.addAll(it)},
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }

    fun postTryoutUser(
        tryout_id: String
    ){
        isLoading.value = true
        isSuccess.value = false
        authRepository.postTryoutUser(
            tryout_id,
            onSuccess = {
                tryout_user_id.value = it
                isSuccess.value = true
                isLoading.value = false
                        },
            onFailed = {
                isSuccess.value = false
                isLoading.value = false
                Log.e("ERROR", it.toString())
            }
        )
    }
}