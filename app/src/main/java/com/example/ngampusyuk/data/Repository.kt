package com.example.ngampusyuk.data

import com.example.ngampusyuk.model.jurusan.JurusanModel
import com.example.ngampusyuk.model.kampus.KampusModel
import com.google.firebase.firestore.FirebaseFirestore

class Repository constructor(
    private val firestore : FirebaseFirestore
) {
    fun getAllKampus(
        onSuccess: (List<KampusModel>) -> Unit,
        onFailed: (Exception) -> Unit
    ) {
        firestore
            .collection("kampus")
            .addSnapshotListener { value, error ->
                if (error != null) {
                    onFailed(error)
                    return@addSnapshotListener
                }
                value?.let {
                    onSuccess(
                        it.documents.map { doc ->
                            KampusModel(
                                id = doc["id"] as String,
                                nama = doc["nama"] as String,
                                email_kampus = doc["email_kampus"] as String,
                                jenis = doc["jenis"] as String,
                                akreditasi = doc["akreditasi"] as String,
                                status = doc["status"] as String,
                                no_telp = doc["no_telp"] as String,
                                alamat = doc["alamat"] as String,
                            )
                        }
                    )
                    return@addSnapshotListener
                }
            }
    }

    fun getKampusById(
        id: String,
        onSuccess: (KampusModel) -> Unit,
        onFailed: (Exception) -> Unit
    ) {
        firestore
            .collection("kampus")
            .document(id)
            .addSnapshotListener { value, error ->
                if (error != null) {
                    onFailed(error)
                }
                value?.let { doc ->
                    onSuccess(
                        KampusModel(
                            id = doc["id"] as String,
                            nama = doc["nama"] as String,
                            email_kampus = doc["email_kampus"] as String,
                            jenis = doc["jenis"] as String,
                            akreditasi = doc["akreditasi"] as String,
                            status = doc["status"] as String,
                            no_telp = doc["no_telp"] as String,
                            alamat = doc["alamat"] as String,
                        )
                    )
                    return@addSnapshotListener
                }
            }
    }

    fun getAllJurusan(
        kampus_id: String,
        onSuccess: (List<JurusanModel>) -> Unit,
        onFailed: (Exception) -> Unit
    ) {
        firestore
            .collection("jurusan")
            .whereEqualTo("kampus_id", kampus_id)
            .addSnapshotListener { value, error ->
                if (error != null) {
                    onFailed(error)
                    return@addSnapshotListener
                }
                value?.let {
                    onSuccess(
                        it.map { doc ->
                            JurusanModel(
                                kampus_id = doc?.getString("kampus_id") ?: "",
                                fakultas_id = doc?.getString("fakultas_id") ?: "",
                                id = doc?.getString("id") ?: "",
                                nama_jurusan = doc?.getString("nama_jurusan") ?: "",
                                snbp = doc?.getDouble("snbp") ?: 0.0,
                                snbt = doc?.getDouble("snbt") ?: 0.0,
                                tipe = doc?.getLong("tipe") ?: 0,
                             )
                        }
                    )
                    return@addSnapshotListener
                }
            }

    }
}