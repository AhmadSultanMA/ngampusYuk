package com.example.ngampusyuk.feature.snbpDetail

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.ngampusyuk.data.Repository
import com.example.ngampusyuk.model.snbp.SnbpModel
import com.google.firebase.firestore.FirebaseFirestore

class SNBPDetailViewModel : ViewModel() {
    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val repository = Repository(firestore)

    val snbp = mutableStateOf<SnbpModel?>(null)

    fun getSNBPById(
        id: String
    ){
        repository.getSNBPById(
            id,
            onSuccess = {snbp.value = it},
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }
}