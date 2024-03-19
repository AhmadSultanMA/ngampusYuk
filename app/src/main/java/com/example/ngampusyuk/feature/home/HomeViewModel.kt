package com.example.ngampusyuk.feature.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.ngampusyuk.data.Repository
import com.example.ngampusyuk.data.user.AuthRepository
import com.example.ngampusyuk.model.berita.BeritaModel
import com.example.ngampusyuk.model.kampus.KampusModel
import com.example.ngampusyuk.model.user.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class HomeViewModel : ViewModel() {
    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    val repository = Repository(firestore)
    val authRepository = AuthRepository(auth, firestore)

    val kampus = mutableStateListOf<KampusModel>()
    val berita = mutableStateListOf<BeritaModel>()
    var filteredList = mutableStateOf(emptyList<KampusModel>())
    val user = mutableStateOf<UserModel?>(null)
    init
    {
        repository.getAllKampus(
            onSuccess = {
                kampus.clear()
                kampus.addAll(it)
            },
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )

        repository.getAllBerita(
            onSuccess = {
                berita.clear()
                berita.addAll(it)
            },
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )

        authRepository.getUser(
            auth?.uid ?: "",
            onSuccess = {
                user.value = it
            },
            onFailed = {
                Log.e("Gagal", it.toString())
            }
        )
    }
}