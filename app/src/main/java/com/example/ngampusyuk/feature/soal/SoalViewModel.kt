package com.example.ngampusyuk.feature.soal

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ngampusyuk.data.Repository
import com.example.ngampusyuk.data.user.AuthRepository
import com.example.ngampusyuk.model.soal.SoalModel
import com.example.ngampusyuk.model.soalUser.SoalUserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

class SoalViewModel : ViewModel() {
    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val auth: FirebaseAuth = FirebaseAuth.getInstance()
    val authRepository = AuthRepository(auth, firestore)
    val repository = Repository(firestore)

    val soal = mutableStateListOf<SoalModel>()
    val mapJawaban = mutableMapOf<String, MutableState<String>>()
    val isSuccess = mutableStateOf(false)

    fun getAllSoal(
        tryout_id : String
    ){
        repository.getAllSoal(
            tryout_id,
            onSuccess = {
                soal.clear()
                soal.addAll(it)
                mapJawaban.putAll(it.associate { it.id to mutableStateOf("") })
            },
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }

    fun postSoalUserList(
        soalList: List<SoalModel>,
        tryout_user_id: String
    ) {
        isSuccess.value = false
        soalList.forEach { soal ->
            val jawab = mapJawaban[soal.id]?.value ?: ""
            val benar = mapJawaban[soal.id]?.value == soal.jawaban_benar
            authRepository.postSoalUser(
                jawab = jawab,
                benar = benar,
                tryout_user_id = tryout_user_id,
                soal_id = soal.id,
                tryout_id = soal.tryout_id,
                onSuccess = {},
                onFailed = {
                    Log.e("ERROR", it.toString())
                }
            )
        }
        isSuccess.value = true
    }

}


