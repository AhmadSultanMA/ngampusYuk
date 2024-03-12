package com.example.ngampusyuk.data.user

import com.example.ngampusyuk.model.kampus.KampusModel
import com.example.ngampusyuk.model.user.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class AuthRepository constructor(
    val auth : FirebaseAuth,
    private val firestore : FirebaseFirestore
) {
    fun signUp(
        email : String,
        password : String,
        nama: String,
        no_telp: String,
        onSuccess: () -> Unit,
        onFailed: (Exception) -> Unit
    ){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                firestore
                    .collection("user")
                    .document(it.user?.uid ?: "")
                    .set(
                        UserModel(
                            uid = it.user?.uid ?: "",
                            nama = nama,
                            no_telp = no_telp,
                        )
                    )
                    .addOnSuccessListener {
                        onSuccess()
                    }
                    .addOnFailureListener {
                        onFailed(it)
                    }
            }
            .addOnFailureListener{
                onFailed(it)
            }
    }

    fun signIn(
        email: String,
        password: String,
        onSuccess: (Boolean) -> Unit,
        onFailed: (Exception) -> Unit
    ){
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                onSuccess(true)
            }
            .addOnFailureListener {
                onFailed(it)
            }
    }

    fun getUser(
        uid: String,
        onSuccess: (UserModel) -> Unit,
        onFailed: (Exception) -> Unit,
    ){
        firestore
            .collection("user")
            .document(uid)
            .addSnapshotListener { value, error ->
                if (error != null) {
                    onFailed(error)
                }
                value?.let { doc ->
                    onSuccess(
                        UserModel(
                            uid = auth?.uid ?: "",
                            nama = doc["nama"] as String,
                            no_telp = doc["no_telp"] as String
                        )
                    )
                    return@addSnapshotListener
                }
            }
    }
}