package com.example.ngampusyuk.feature.snbp

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.ngampusyuk.data.Repository
import com.example.ngampusyuk.model.snbp.SnbpModel
import com.google.firebase.firestore.FirebaseFirestore

class SNBPViewModel : ViewModel() {
    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val repository = Repository(firestore)

    val snbp = mutableStateListOf<SnbpModel>()

    init {
        repository.getAllSNBP(
            onSuccess = {
                snbp.clear()
                snbp.addAll(it)
            },
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }
}