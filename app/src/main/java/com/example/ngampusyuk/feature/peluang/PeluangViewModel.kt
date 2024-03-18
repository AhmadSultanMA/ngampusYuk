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
                            model.kampus_id,
                            onSuccess = {
                                kampus.add(it)
                            },
                            onFailed = {
                            Log.e("ERROR", it.toString())
                        })
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
}