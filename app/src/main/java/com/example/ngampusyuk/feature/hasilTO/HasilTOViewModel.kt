package com.example.ngampusyuk.feature.hasilTO

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.ngampusyuk.data.Repository
import com.example.ngampusyuk.data.user.AuthRepository
import com.example.ngampusyuk.model.soal.SoalModel
import com.example.ngampusyuk.model.soalUser.SoalUserModel
import com.example.ngampusyuk.model.user.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class HasilTOViewModel : ViewModel() {
    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    val authRepository = AuthRepository(auth, firestore)
    val repository = Repository(firestore)

    val soal = mutableStateListOf<SoalModel>()
    val soalUser = mutableStateListOf<SoalUserModel>()

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
    fun getAllSoal(
        tryout_id: String
    ){
        repository.getAllSoal(
            tryout_id,
            onSuccess = {
                soal.addAll(it)
            },
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }

    fun getAllSoalUserById(
        tryout_id : String
    ){
        authRepository.getAllSoalUserById(
            tryout_id,
            onSuccess = {soalUser.addAll(it)},
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }
}