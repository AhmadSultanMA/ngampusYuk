package com.example.ngampusyuk.feature.pilihJurusan

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.ngampusyuk.data.Repository
import com.example.ngampusyuk.model.jurusan.JurusanModel
import com.example.ngampusyuk.model.kampus.KampusModel
import com.google.firebase.firestore.FirebaseFirestore

class PilihJurusanViewModel : ViewModel() {
    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val repository = Repository(firestore)

    val jurusan = mutableStateListOf<JurusanModel>()
    var filteredJurusan = mutableStateOf(emptyList<JurusanModel>())
    val kampus = mutableStateOf<KampusModel?>(null)
    val jurusanText = mutableStateOf("")
    val jurusanChosen = mutableStateOf<JurusanModel?>(null)

    val status = mutableStateOf(false)
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



}