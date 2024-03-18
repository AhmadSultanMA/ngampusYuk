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
                jurusan.addAll(
                    it.map { model ->
                        JurusanModel(
                            kampus_id = model.kampus_id,
                            fakultas_id = model.fakultas_id,
                            id = model.id,
                            nama_jurusan = model.nama_jurusan,
                            snbp = model.snbp,
                            snbt = model.snbt,
                            tipe = model.tipe,
                            jalur_masuk = model.jalur_masuk,
                            ukt_minimal = model.ukt_minimal,
                            ukt_maximal = model.ukt_maximal,
                            akreditasi = model.akreditasi,
                            jumlah_pendaftar = model.jumlah_pendaftar,
                            kuota = model.kuota,
                            passing_grade = model.passing_grade,
                            peluang_kerja = model.peluang_kerja,
                            tingkat_ketat = model.tingkat_ketat
                        )
                    }
                )
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