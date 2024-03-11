package com.example.ngampusyuk.feature.peluang

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.ngampusyuk.data.Repository
import com.example.ngampusyuk.model.jurusan.JurusanModel
import com.example.ngampusyuk.model.kampus.KampusModel
import com.google.firebase.firestore.FirebaseFirestore

class PeluangViewModel: ViewModel() {
    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val repository = Repository(firestore)
    val skor =   mutableStateOf("")
    val jurusanText =   mutableStateOf("")
    val jurusanAll = mutableStateListOf<JurusanModel>()
    var filteredJurusan = mutableStateOf(emptyList<JurusanModel>())

    val kampus = mutableStateListOf<KampusModel>()
    val jurusanAllByTes = mutableStateListOf<JurusanModel>()

    fun getAllJurusanByTes(){
        repository.getAllJurusanByTes(
            jurusanText.value,
            skor.value.toDouble(),
            onSuccess = {
                jurusanAllByTes.clear()
                kampus.clear()
                jurusanAllByTes.addAll(
                    it.map { model->
                        repository.getKampusById(
                            model.kampus_id ?: "",
                            onSuccess = {
                                kampus.add(it)
                            },
                            onFailed = {
                            Log.e("ERROR", it.toString())
                        })
                        JurusanModel(
                            kampus_id = model.kampus_id ?: "",
                            fakultas_id = model.fakultas_id ?: "",
                            id = model.id ?: "",
                            nama_jurusan = model.nama_jurusan ?: "",
                            snbp = model.snbp ?: 0.0,
                            snbt = model.snbt ?: 0.0,
                            tipe = model.tipe ?: 0,
                        )
                    }
                )
                Log.e("berhasil", "bisa")
            },
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }

    init {
        repository.getAllJurusan(
            onSuccess = {
                jurusanAll.clear()
                jurusanAll.addAll(
                    it.map { model->
                        JurusanModel(
                            kampus_id = model.kampus_id ?: "",
                            fakultas_id = model.fakultas_id ?: "",
                            id = model.id ?: "",
                            nama_jurusan = model.nama_jurusan ?: "",
                            snbp = model.snbp ?: 0.0,
                            snbt = model.snbt ?: 0.0,
                            tipe = model.tipe ?: 0,
                        )
                    }
                )
            },
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }
}