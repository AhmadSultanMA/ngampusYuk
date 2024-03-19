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
                kampus.addAll(it)
            },
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }
}