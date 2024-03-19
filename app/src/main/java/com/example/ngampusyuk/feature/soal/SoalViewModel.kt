package com.example.ngampusyuk.feature.soal

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.ngampusyuk.data.Repository
import com.example.ngampusyuk.data.user.AuthRepository
import com.example.ngampusyuk.model.soal.SoalModel
import com.example.ngampusyuk.model.soalUser.SoalUserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class SoalViewModel : ViewModel() {
    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val auth: FirebaseAuth = FirebaseAuth.getInstance()
    val authRepository = AuthRepository(auth, firestore)
    val repository = Repository(firestore)

    val soal = mutableStateListOf<SoalModel>()
    val soalId = mutableStateOf<SoalModel?>(null)
    val soalUser = mutableStateListOf<SoalUserModel>()

    init {
        authRepository.getSoalUser(
            onSuccess = {soalUser.addAll(it)},
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }
    fun getAllSoal(
        tryout_id : String
    ){
        repository.getAllSoal(
            tryout_id,
            onSuccess = {
                soal.clear()
                soal.addAll(
                    it.map { model ->
                        SoalModel(
                            id = model.id,
                            tryout_id = model.tryout_id,
                            jawaban_a = model.jawaban_a,
                            jawaban_b = model.jawaban_b,
                            jawaban_c = model.jawaban_c,
                            jawaban_d = model.jawaban_d,
                            jawaban_benar = model.jawaban_benar,
                            soal = model.soal,
                            nomor = model.nomor,
                            status = mutableStateOf(soalUser.any{
                                it.soal_id == model.id && (auth.currentUser?.uid ?: "") == it.user_id
                            })
                        )
                    }
                )
            },
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }

    fun getSoalById(
        id : String
    ){
        repository.getSoalById(
            id,
            onSuccess = {soalModel ->
                soalModel.status.value = soalUser.any {
                    it.soal_id == soalModel.id && (auth.currentUser?.uid ?: "") == it.user_id
                }
                soalId.value = soalModel
            },
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }

    fun postSoalUser(
        jawab: String,
        benar: Boolean,
        tryout_user_id: String,
        soal_id: String,
    ){
        authRepository.postSoalUser(
            jawab = jawab,
            benar = benar,
            tryout_user_id = tryout_user_id,
            soal_id = soal_id,
            onSuccess = {},
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }

    fun updateSoalUser(
        id: String,
        benar: Boolean,
        jawab: String
    ){
        repository.updateSoalUser(
            id = id,
            benar = benar,
            jawab = jawab,
            onSuccess = {},
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }
}