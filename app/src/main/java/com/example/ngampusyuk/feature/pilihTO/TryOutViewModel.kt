package com.example.ngampusyuk.feature.pilihTO

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.ngampusyuk.data.Repository
import com.example.ngampusyuk.data.user.AuthRepository
import com.example.ngampusyuk.model.tryOutUser.TryOutUserModel
import com.example.ngampusyuk.model.tryout.TryOutModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class TryOutViewModel : ViewModel() {
    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val auth: FirebaseAuth = FirebaseAuth.getInstance()
    val authRepository = AuthRepository(auth, firestore)
    val repository = Repository(firestore)

    val tryOut = mutableStateListOf<TryOutModel>()
    val tryOutUser = mutableStateOf<TryOutUserModel?>(null)

    fun getTryOutUser(
        tryout_id : String
    ){
        authRepository.getTryoutUser(
            tryout_id,
            onSuccess = {tryOutUser.value = it},
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }

    init {
        repository.getAllTO(
            onSuccess = {
                tryOut.clear()
                tryOut.addAll(
                    it.map { model ->
                        TryOutModel(
                            id = model.id,
                            gambar = model.gambar,
                            tanggal_start = model.tanggal_start,
                            tanggal_end = model.tanggal_end,
                            judul = model.judul,
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