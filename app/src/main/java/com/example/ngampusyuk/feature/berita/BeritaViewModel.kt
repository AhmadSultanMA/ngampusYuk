package com.example.ngampusyuk.feature.berita

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.ngampusyuk.data.Repository
import com.example.ngampusyuk.model.berita.BeritaModel
import com.example.ngampusyuk.model.kampus.KampusModel
import com.google.firebase.firestore.FirebaseFirestore

class BeritaViewModel: ViewModel() {
    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val repository = Repository(firestore)
    val berita = mutableStateOf<BeritaModel?>(null)

    fun getBeritaById(
        berita_id : String
    ){
        repository.getBeritaById(
            berita_id ,
            onSuccess = {
                berita.value = it
            },
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }
}