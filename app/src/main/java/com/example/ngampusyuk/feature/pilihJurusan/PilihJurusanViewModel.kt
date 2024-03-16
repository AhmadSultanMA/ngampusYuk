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
                jurusan.addAll(
                    it.map { model ->
                        JurusanModel(
                            kampus_id = model.kampus_id ?: "",
                            fakultas_id = model.fakultas_id ?: "",
                            id = model.id ?: "",
                            nama_jurusan = model.nama_jurusan ?: "",
                            snbp = model.snbp ?: 0.0,
                            snbt = model.snbt ?: 0.0,
                            tipe = model.tipe ?: 0,
                            jalur_masuk = model.jalur_masuk ?: "",
                            ukt_minimal = model.ukt_minimal ?: "",
                            ukt_maximal = model.ukt_maximal ?: "",
                            akreditasi = model.akreditasi ?: "",
                            jumlah_pendaftar = model.jumlah_pendaftar ?: 0,
                            kuota = model.kuota ?: 0,
                            passing_grade = model.passing_grade ?: 0,
                            peluang_kerja = model.peluang_kerja ?: 0,
                            tingkat_ketat = model.tingkat_ketat ?: 0
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