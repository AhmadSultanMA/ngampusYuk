package com.example.ngampusyuk.feature.snbtDetail

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.ngampusyuk.data.Repository
import com.example.ngampusyuk.model.snbp.SnbpModel
import com.google.firebase.firestore.FirebaseFirestore

class SNBTDetailViewModel : ViewModel() {
    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val repository = Repository(firestore)

    val snbt = mutableStateOf<SnbpModel?>(null)

    fun getSNBTById(
        id: String
    ){
        repository.getSNBTById(
            id,
            onSuccess = {snbt.value = it},
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }
}