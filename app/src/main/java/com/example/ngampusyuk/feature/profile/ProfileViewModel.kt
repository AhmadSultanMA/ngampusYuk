package com.example.ngampusyuk.feature.profile

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.ngampusyuk.data.Repository
import com.example.ngampusyuk.data.user.AuthRepository
import com.example.ngampusyuk.model.tryOutUser.TryOutUserModel
import com.example.ngampusyuk.model.tryout.TryOutModel
import com.example.ngampusyuk.model.user.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ProfileViewModel : ViewModel() {
    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val auth: FirebaseAuth = FirebaseAuth.getInstance()
    val authRepository = AuthRepository(auth, firestore)
    val repository = Repository(firestore)

    val allTO = mutableStateListOf<TryOutModel>()
    val user = mutableStateOf<UserModel?>(null)

    init {
        authRepository.getTryoutUser(
            onSuccess = {it.map { model->
                getTOByID(model.tryout_id)
            } },
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

    fun getTOByID(tryout_id: String) {
        repository.getTOById(
            tryout_id,
            onSuccess = { tryout ->
                allTO.add(tryout)
            },
            onFailed = { error ->
                Log.e("ERROR", error.toString())
            }
        )
    }
}