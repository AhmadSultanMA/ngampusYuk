package com.example.ngampusyuk.feature.penjelasan

import android.util.Log
import androidx.compose.runtime.MutableState
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

class PenjelasanViewModel : ViewModel() {
    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    val repository = Repository(firestore)
    val authRepository = AuthRepository(auth, firestore)

    val AllSoal = mutableStateListOf<SoalModel>()
    val AllSoalUser = mutableStateListOf<SoalUserModel>()
    val mapJawaban = mutableMapOf<String, String>()

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
    fun getAllSoalUser(
        tryout_id: String
    ){
        authRepository.getAllSoalUserById(
            tryout_id,
            onSuccess = {AllSoalUser.addAll(it)},
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }
    fun getAllSoal(
        tryout_id:String
    ){
        repository.getAllSoal(
            tryout_id,
            onSuccess = {
                mapJawaban.clear()
                AllSoal.addAll(
                    it.map { model->
                        val jawaban = AllSoalUser.find { it.soal_id == model.id && (auth.currentUser?.uid ?: "") == it.user_id }?.jawab ?: ""
                        mapJawaban[model.id] = jawaban
                        model.copy(
                            status = mutableStateOf(AllSoalUser.any {
                                it.soal_id == model.id && (auth.currentUser?.uid ?: "") == it.user_id
                            }),
                            benar = mutableStateOf(AllSoalUser.any {
                               it.soal_id == model.id && it.benar && (auth.currentUser?.uid ?: "") == it.user_id
                            })
                        )
                    }
                )},
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }
}