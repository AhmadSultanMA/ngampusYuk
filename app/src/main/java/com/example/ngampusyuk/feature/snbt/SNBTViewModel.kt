package com.example.ngampusyuk.feature.snbp

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.ngampusyuk.data.Repository
import com.example.ngampusyuk.model.snbp.SnbpModel
import com.google.firebase.firestore.FirebaseFirestore

class SNBTViewModel : ViewModel() {
    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val repository = Repository(firestore)

    val snbt = mutableStateListOf<SnbpModel>()

    init {
        repository.getAllSNBT(
            onSuccess = {
                snbt.clear()
                snbt.addAll(it)
            },
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }
}