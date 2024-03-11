package com.example.ngampusyuk.data

import android.util.Log
import com.example.ngampusyuk.model.berita.BeritaModel
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
                                id = doc?.getString("id") ?: "",
                                nama = doc?.getString("nama") ?: "",
                                email_kampus = doc?.getString("email_kampus") ?: "",
                                jenis = doc?.getString("jenis") ?: "",
                                akreditasi = doc?.getString("akreditasi") ?: "",
                                status = doc?.getString("status") ?: "",
                                no_telp = doc?.getString("no_telp") ?: "",
                                alamat = doc?.getString("alamat") ?: "",
                                logo = doc?.getString("logo") ?: "",
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
                            logo = doc["logo"] as String,
                        )
                    )
                    return@addSnapshotListener
                }
            }
    }

    fun getAllJurusanByKampus(
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
                value?.let { snapshot ->
                    val jurusanList = mutableListOf<JurusanModel>()
                    for (doc in snapshot.documents) {
                        val kampusId = doc.getString("kampus_id") ?: ""
                        val fakultasId = doc.getString("fakultas_id") ?: ""
                        val id = doc.getString("id") ?: ""
                        val namaJurusan = doc.getString("nama_jurusan") ?: ""
                        val snbp = doc["snbp"]
                        val snbt = doc["snbt"]
                        val tipe = doc.getLong("tipe") ?: 0

                        if (snbp is Number && snbt is Number) {
                            jurusanList.add(
                                JurusanModel(
                                    kampus_id = kampusId,
                                    fakultas_id = fakultasId,
                                    id = id,
                                    nama_jurusan = namaJurusan,
                                    snbp = snbp.toDouble(),
                                    snbt = snbt.toDouble(),
                                    tipe = tipe
                                )
                            )
                        } else {
                            Log.e("ERROR", "SNBP is not number")
                        }
                    }
                    onSuccess(jurusanList)
                }
            }
    }

    fun getAllJurusan(
        onSuccess: (List<JurusanModel>) -> Unit,
        onFailed: (Exception) -> Unit
    ) {
        firestore
            .collection("jurusan")
            .addSnapshotListener { value, error ->
                if (error != null) {
                    onFailed(error)
                    return@addSnapshotListener
                }
                value?.let { snapshot ->
                    val jurusanList = mutableListOf<JurusanModel>()
                    for (doc in snapshot.documents) {
                        val kampusId = doc.getString("kampus_id") ?: ""
                        val fakultasId = doc.getString("fakultas_id") ?: ""
                        val id = doc.getString("id") ?: ""
                        val namaJurusan = doc.getString("nama_jurusan") ?: ""
                        val snbp = doc["snbp"]
                        val snbt = doc["snbt"]
                        val tipe = doc.getLong("tipe") ?: 0

                        if (snbp is Number && snbt is Number) {
                            jurusanList.add(
                                JurusanModel(
                                    kampus_id = kampusId,
                                    fakultas_id = fakultasId,
                                    id = id,
                                    nama_jurusan = namaJurusan,
                                    snbp = snbp.toDouble(),
                                    snbt = snbt.toDouble(),
                                    tipe = tipe
                                )
                            )
                        } else {
                            Log.e("ERROR", "SNBP is not number")
                        }
                    }
                    onSuccess(jurusanList)
                }
            }
    }

    fun getAllJurusanByTes(
        nama_jurusan: String,
        skor: Double,
        onSuccess: (List<JurusanModel>) -> Unit,
        onFailed: (Exception) -> Unit
    ){
        firestore
            .collection("jurusan")
            .whereEqualTo("nama_jurusan", nama_jurusan)
            .whereLessThanOrEqualTo("snbt", skor)
            .addSnapshotListener { value, error ->
                if (error != null) {
                    onFailed(error)
                    return@addSnapshotListener
                }
                value?.let { snapshot ->
                    val jurusanList = mutableListOf<JurusanModel>()
                    for (doc in snapshot.documents) {
                        val kampusId = doc.getString("kampus_id") ?: ""
                        val fakultasId = doc.getString("fakultas_id") ?: ""
                        val id = doc.getString("id") ?: ""
                        val namaJurusan = doc.getString("nama_jurusan") ?: ""
                        val snbp = doc["snbp"]
                        val snbt = doc["snbt"]
                        val tipe = doc.getLong("tipe") ?: 0

                        if (snbp is Number && snbt is Number) {
                            jurusanList.add(
                                JurusanModel(
                                    kampus_id = kampusId,
                                    fakultas_id = fakultasId,
                                    id = id,
                                    nama_jurusan = namaJurusan,
                                    snbp = snbp.toDouble(),
                                    snbt = snbt.toDouble(),
                                    tipe = tipe
                                )
                            )
                        } else {
                            Log.e("ERROR", "SNBP is not number")
                        }
                    }
                    onSuccess(jurusanList)
                }
            }
    }

    fun getAllBerita(
        onSuccess: (List<BeritaModel>) -> Unit,
        onFailed: (Exception) -> Unit
    ){
        firestore
            .collection("berita")
            .addSnapshotListener { value, error ->
                if (error != null) {
                    onFailed(error)
                    return@addSnapshotListener
                }
                value?.let {
                    onSuccess(
                        it.documents.map { doc ->
                            BeritaModel(
                                id = doc?.getString("id") ?: "",
                                email_berita = doc?.getString("email_berita") ?: "",
                                gambar_berita = doc?.getString("gambar_berita") ?: "",
                                isi_berita = doc?.getString("isi_berita") ?: "",
                                judul_berita = doc?.getString("judul_berita") ?: "",
                                penulis_berita = doc?.getString("penulis_berita") ?: "",
                                tanggal_berita = doc?.getString("tanggal_berita") ?: "",
                            )
                        }
                    )
                    return@addSnapshotListener
                }
            }
    }

    fun getBeritaById(
        id: String,
        onSuccess: (BeritaModel) -> Unit,
        onFailed: (Exception) -> Unit
    ) {
        firestore
            .collection("berita")
            .document(id)
            .addSnapshotListener { value, error ->
                if (error != null) {
                    onFailed(error)
                }
                value?.let { doc ->
                    onSuccess(
                        BeritaModel(
                            id = doc["id"] as String,
                            email_berita = doc["email_berita"] as String,
                            gambar_berita = doc["gambar_berita"] as String,
                            isi_berita = doc["isi_berita"] as String,
                            judul_berita = doc["judul_berita"] as String,
                            penulis_berita = doc["penulis_berita"] as String,
                            tanggal_berita = doc["tanggal_berita"] as String,
                        )
                    )
                    return@addSnapshotListener
                }
            }
    }

}