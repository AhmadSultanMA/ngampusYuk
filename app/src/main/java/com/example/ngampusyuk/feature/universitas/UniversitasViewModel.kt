package com.example.ngampusyuk.feature.universitas

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.ngampusyuk.data.Repository
import com.example.ngampusyuk.model.jurusan.JurusanModel
import com.example.ngampusyuk.model.kampus.KampusModel
import com.google.firebase.firestore.FirebaseFirestore

class UniversitasViewModel: ViewModel() {
    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val repository = Repository(firestore)
    val kampus = mutableStateOf<KampusModel?>(null)
    val jurusan = mutableStateListOf<JurusanModel>()

    fun getAllJurusan(
        kampus_id : String
    ){
        repository.getAllJurusanByKampus(
            kampus_id,
            onSuccess = {
                jurusan.clear()
                jurusan.addAll(it)
            },
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }

    fun getKampusById(
        kampus_id : String
    ){
        repository.getKampusById(
            kampus_id ,
            onSuccess = {
                kampus.value = it
            },
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }
}