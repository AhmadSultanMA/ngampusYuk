package com.example.ngampusyuk.data.user

import com.example.ngampusyuk.model.berita.BeritaModel
import com.example.ngampusyuk.model.kampus.KampusModel
import com.example.ngampusyuk.model.soal.SoalModel
import com.example.ngampusyuk.model.soalUser.SoalUserModel
import com.example.ngampusyuk.model.tryOutUser.TryOutUserModel
import com.example.ngampusyuk.model.user.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.util.UUID

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
                            premium = false
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
                            no_telp = doc["no_telp"] as String,
                            premium = doc["premium"] as Boolean
                        )
                    )
                    return@addSnapshotListener
                }
            }
    }

    fun updateUserPremium(
        uid: String,
        onSuccess: () -> Unit,
        onFailed: (Exception) -> Unit,
    ) {
        firestore.collection("user")
            .document(uid)
            .update("premium", true)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener { error ->
                onFailed(error)
            }
    }


    fun postTryoutUser(
        tryout_id: String,
        onSuccess: (String) -> Unit,
        onFailed: (Exception) -> Unit
    ){
        val id = UUID.randomUUID().toString()
        firestore
            .collection("tryout_user")
            .document(id)
            .set(
                TryOutUserModel(
                    id = id,
                    tryout_id = tryout_id,
                    user_id = auth.currentUser?.uid ?: ""
                )
            )
            .addOnSuccessListener {
                onSuccess(id)
            }
            .addOnFailureListener {
                onFailed(it)
            }
    }

    fun getTryoutUser(
        onSuccess: (List<TryOutUserModel>) -> Unit,
        onFailed: (Exception) -> Unit
    ){
        firestore
            .collection("tryout_user")
            .whereEqualTo("user_id", auth.currentUser?.uid ?: "")
            .addSnapshotListener { value, error ->
                if (error != null) {
                    onFailed(error)
                }
                value?.let {
                    onSuccess(
                        it.documents.map { doc ->
                            TryOutUserModel(
                                id = doc?.getString("id") ?: "",
                                tryout_id = doc?.getString("tryout_id") ?: "",
                               user_id = doc?.getString("user_id") ?: "",
                            )
                        }
                    )
                    return@addSnapshotListener
                }
            }
    }

    fun postSoalUser(
        jawab: String,
        benar: Boolean,
        tryout_user_id: String,
        tryout_id: String,
        soal_id: String,
        onSuccess: () -> Unit,
        onFailed: (Exception) -> Unit
    ){
        val id = UUID.randomUUID().toString()
        firestore
            .collection("soal_user")
            .document(id)
            .set(
                SoalUserModel(
                    id = id,
                    user_id = auth.currentUser?.uid ?: "",
                    jawab = jawab,
                    benar = benar,
                    soal_id = soal_id,
                    tryout_user_id = tryout_user_id,
                    tryout_id = tryout_id
                )
            )
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener {
                onFailed(it)
            }
    }

    fun getAllSoalUserById(
        tryout_id: String,
        onSuccess: (List<SoalUserModel>) -> Unit,
        onFailed: (Exception) -> Unit
    ){
        firestore
            .collection("soal_user")
            .whereEqualTo("user_id", auth.currentUser?.uid ?: "")
            .whereEqualTo("tryout_id", tryout_id)
            .addSnapshotListener { value, error ->
                if (error != null) {
                    onFailed(error)
                }
                value?.let {
                    onSuccess(
                        it.documents.map { doc ->
                            SoalUserModel(
                                id = doc?.getString("id") ?: "",
                                soal_id = doc?.getString("soal_id") ?: "",
                                tryout_user_id = doc?.getString("tryout_user_id") ?: "",
                                tryout_id = doc?.getString("tryout_id") ?: "",
                                user_id = doc?.getString("user_id") ?: "",
                                benar = doc?.getBoolean("benar") ?: false,
                                jawab = doc?.getString("jawab") ?: "",
                            )
                        }
                    )
                    return@addSnapshotListener
                }
            }
    }

    fun getTOUserById(
        tryout_id: String,
        onSuccess: (List<SoalUserModel>) -> Unit,
        onFailed: (Exception) -> Unit
    ){

    }
}