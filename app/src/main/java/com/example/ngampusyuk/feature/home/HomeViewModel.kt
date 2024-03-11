package com.example.ngampusyuk.feature.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.ngampusyuk.data.Repository
import com.example.ngampusyuk.model.berita.BeritaModel
import com.example.ngampusyuk.model.kampus.KampusModel
import com.google.firebase.firestore.FirebaseFirestore

class HomeViewModel : ViewModel() {
    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val repository = Repository(firestore)
    val kampus = mutableStateListOf<KampusModel>()
    val berita = mutableStateListOf<BeritaModel>()
    var filteredList = mutableStateOf(emptyList<KampusModel>())
    init
    {
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
                        )
                    }
                )
            },
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )

        repository.getAllBerita(
            onSuccess = {
                berita.clear()
                berita.addAll(
                    it.map { model ->
                        BeritaModel(
                            id = model.id ?: "",
                            email_berita = model.email_berita ?: "",
                            gambar_berita = model.gambar_berita ?: "",
                            isi_berita = model.isi_berita ?: "",
                            judul_berita = model.judul_berita ?: "",
                            penulis_berita = model.penulis_berita ?: "",
                            tanggal_berita = model.tanggal_berita ?: ""
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