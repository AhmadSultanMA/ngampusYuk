package com.example.ngampusyuk.feature.pilihUniv

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.ngampusyuk.data.Repository
import com.example.ngampusyuk.model.kampus.KampusModel
import com.google.firebase.firestore.FirebaseFirestore

class PilihUnivViewModel: ViewModel() {
    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val repository = Repository(firestore)

    val kampus = mutableStateListOf<KampusModel>()

    init {
        repository.getAllKampus(
            onSuccess = {
                kampus.clear()
                kampus.addAll(
                    it.map { model ->
                        KampusModel(
                            id = model.id ?: "",
                            nama = model.nama ?: "",
                            email_kampus = model.email_kampus ?: "",
                            jenis = model.jenis ?: "",
                            akreditasi = model.akreditasi ?: "",
                            status = model.status ?: "",
                            no_telp = model.no_telp ?: "",
                            alamat = model.alamat ?: "",
                            logo = model.logo ?: "",
                            gambar_appbar = model.gambar_appbar ?: "",
                            gambar_gedung = model.gambar_gedung ?: "",
                            singkatan = model.singkatan ?: "",
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