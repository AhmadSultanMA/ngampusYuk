package com.example.ngampusyuk.data

import android.util.Log
import com.example.ngampusyuk.model.berita.BeritaModel
import com.example.ngampusyuk.model.jurusan.JurusanModel
import com.example.ngampusyuk.model.kampus.KampusModel
import com.example.ngampusyuk.model.snbp.SnbpModel
import com.example.ngampusyuk.model.soal.SoalModel
import com.example.ngampusyuk.model.tryout.TryOutModel
import com.google.firebase.firestore.FirebaseFirestore
import java.time.LocalDateTime

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
                                gambar_appbar = doc?.getString("gambar_appbar") ?: "",
                                gambar_gedung = doc?.getString("gambar_gedung") ?: "",
                                singkatan = doc?.getString("singkatan") ?: "",
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
                            gambar_appbar = doc["gambar_appbar"] as String,
                            gambar_gedung = doc["gambar_gedung"] as String,
                            singkatan = doc["singkatan"] as String,
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
                        val jalur_masuk = doc.getString("jalur_masuk") ?: ""
                        val ukt_minimal = doc.getString("ukt_minimal") ?: ""
                        val ukt_maximal = doc.getString("ukt_maximal") ?: ""
                        val akreditasi = doc.getString("akreditasi") ?: ""
                        val snbp = doc["snbp"]
                        val snbt = doc["snbt"]
                        val tipe = doc.getLong("tipe") ?: 0
                        val kuota = doc.getLong("kuota") ?: 0
                        val passing_grade = doc.getLong("passing_grade") ?: 0
                        val peluang_kerja = doc.getLong("peluang_kerja") ?: 0
                        val tingkat_ketat = doc.getLong("tingkat_ketat") ?: 0
                        val jumlah_pendaftar = doc.getLong("jumlah_pendaftar") ?: 0


                        if (snbp is Number && snbt is Number) {
                            jurusanList.add(
                                JurusanModel(
                                    kampus_id = kampusId,
                                    fakultas_id = fakultasId,
                                    id = id,
                                    nama_jurusan = namaJurusan,
                                    snbp = snbp.toDouble(),
                                    snbt = snbt.toDouble(),
                                    tipe = tipe,
                                    jalur_masuk = jalur_masuk,
                                    ukt_minimal = ukt_minimal,
                                    ukt_maximal = ukt_maximal,
                                    jumlah_pendaftar = jumlah_pendaftar,
                                    kuota = kuota,
                                    passing_grade = passing_grade,
                                    peluang_kerja = peluang_kerja,
                                    tingkat_ketat = tingkat_ketat,
                                    akreditasi = akreditasi
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
                        val jalur_masuk = doc.getString("jalur_masuk") ?: ""
                        val ukt_minimal = doc.getString("ukt_minimal") ?: ""
                        val ukt_maximal = doc.getString("ukt_maximal") ?: ""
                        val akreditasi = doc.getString("akreditasi") ?: ""
                        val snbp = doc["snbp"]
                        val snbt = doc["snbt"]
                        val tipe = doc.getLong("tipe") ?: 0
                        val kuota = doc.getLong("kuota") ?: 0
                        val passing_grade = doc.getLong("passing_grade") ?: 0
                        val peluang_kerja = doc.getLong("peluang_kerja") ?: 0
                        val tingkat_ketat = doc.getLong("tingkat_ketat") ?: 0
                        val jumlah_pendaftar = doc.getLong("jumlah_pendaftar") ?: 0

                        if (snbp is Number && snbt is Number) {
                            jurusanList.add(
                                JurusanModel(
                                    kampus_id = kampusId,
                                    fakultas_id = fakultasId,
                                    id = id,
                                    nama_jurusan = namaJurusan,
                                    snbp = snbp.toDouble(),
                                    snbt = snbt.toDouble(),
                                    tipe = tipe,
                                    jalur_masuk = jalur_masuk,
                                    ukt_minimal = ukt_minimal,
                                    ukt_maximal = ukt_maximal,
                                    jumlah_pendaftar = jumlah_pendaftar,
                                    kuota = kuota,
                                    passing_grade = passing_grade,
                                    peluang_kerja = peluang_kerja,
                                    tingkat_ketat = tingkat_ketat,
                                    akreditasi = akreditasi
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
                        val jalur_masuk = doc.getString("jalur_masuk") ?: ""
                        val ukt_minimal = doc.getString("ukt_minimal") ?: ""
                        val ukt_maximal = doc.getString("ukt_maximal") ?: ""
                        val akreditasi = doc.getString("akreditasi") ?: ""
                        val snbp = doc["snbp"]
                        val snbt = doc["snbt"]
                        val tipe = doc.getLong("tipe") ?: 0
                        val kuota = doc.getLong("kuota") ?: 0
                        val passing_grade = doc.getLong("passing_grade") ?: 0
                        val peluang_kerja = doc.getLong("peluang_kerja") ?: 0
                        val tingkat_ketat = doc.getLong("tingkat_ketat") ?: 0
                        val jumlah_pendaftar = doc.getLong("jumlah_pendaftar") ?: 0

                        if (snbp is Number && snbt is Number) {
                            jurusanList.add(
                                JurusanModel(
                                    kampus_id = kampusId,
                                    fakultas_id = fakultasId,
                                    id = id,
                                    nama_jurusan = namaJurusan,
                                    snbp = snbp.toDouble(),
                                    snbt = snbt.toDouble(),
                                    tipe = tipe,
                                    jalur_masuk = jalur_masuk,
                                    ukt_minimal = ukt_minimal,
                                    ukt_maximal = ukt_maximal,
                                    jumlah_pendaftar = jumlah_pendaftar,
                                    kuota = kuota,
                                    passing_grade = passing_grade,
                                    peluang_kerja = peluang_kerja,
                                    tingkat_ketat = tingkat_ketat,
                                    akreditasi = akreditasi
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

    fun getAllTO(
        onSuccess: (List<TryOutModel>) -> Unit,
        onFailed: (Exception) -> Unit
    ){
        firestore
            .collection("tryout")
            .addSnapshotListener { value, error ->
                if (error != null) {
                    onFailed(error)
                    return@addSnapshotListener
                }
                value?.let {
                    onSuccess(
                        it.documents.map { doc ->
                            val tanggal_start = doc["tanggal_start"]
                            val tanggal_end = doc["tanggal_end"]
                            TryOutModel(
                                id = doc?.getString("id") ?: "",
                                gambar = doc?.getString("gambar") ?: "",
                                judul = doc?.getString("judul") ?: "",
                                tanggal_start = tanggal_start.toString(),
                                tanggal_end = tanggal_end.toString(),
                            )
                        }
                    )
                    return@addSnapshotListener
                }
            }
    }

    fun getTOById(
        id: String,
        onSuccess: (TryOutModel) -> Unit,
        onFailed: (Exception) -> Unit
    ){
        firestore
            .collection("tryout")
            .document(id)
            .addSnapshotListener { value, error ->
                if (error != null) {
                    onFailed(error)
                }
                value?.let { doc ->
                    val tanggal_start = doc["tanggal_start"]
                    val tanggal_end = doc["tanggal_end"]
                    onSuccess(
                        TryOutModel(
                            id = doc?.getString("id") ?: "",
                            gambar = doc?.getString("gambar") ?: "",
                            judul = doc?.getString("judul") ?: "",
                            tanggal_start = tanggal_start.toString(),
                            tanggal_end = tanggal_end.toString()
                            )
                    )
                    return@addSnapshotListener
                }
            }
    }

    fun getAllSoal(
        tryout_id: String,
        onSuccess: (List<SoalModel>) -> Unit,
        onFailed: (Exception) -> Unit
    ){
        firestore
            .collection("soal")
            .whereEqualTo("tryout_id", tryout_id)
            .addSnapshotListener { value, error ->
                if (error != null) {
                    onFailed(error)
                    return@addSnapshotListener
                }
                value?.let {
                    onSuccess(
                        it.documents.map { doc ->
                            SoalModel(
                                id = doc?.getString("id") ?: "",
                                tryout_id = doc?.getString("tryout_id") ?: "",
                                jawaban_a = doc?.getString("jawaban_a") ?: "",
                                jawaban_b = doc?.getString("jawaban_b") ?: "",
                                jawaban_c = doc?.getString("jawaban_c") ?: "",
                                jawaban_d = doc?.getString("jawaban_d") ?: "",
                                jawaban_benar = doc?.getString("jawaban_benar") ?: "",
                                soal = doc?.getString("soal") ?: "",
                                nomor = doc?.getLong("nomor") ?: 0
                            )
                        }
                    )
                    return@addSnapshotListener
                }
            }
    }

    fun getSoalById(
        id: String,
        onSuccess: (SoalModel) -> Unit,
        onFailed: (Exception) -> Unit
    ) {
        firestore
            .collection("soal")
            .document(id)
            .addSnapshotListener { value, error ->
                if (error != null) {
                    onFailed(error)
                }
                value?.let { doc ->
                    onSuccess(
                        SoalModel(
                            id = doc?.getString("id") ?: "",
                            soal = doc?.getString("soal") ?: "",
                            jawaban_a = doc?.getString("jawaban_a") ?: "",
                            jawaban_b = doc?.getString("jawaban_b") ?: "",
                            jawaban_c = doc?.getString("jawaban_c") ?: "",
                            jawaban_d = doc?.getString("jawaban_d") ?: "",
                            jawaban_benar = doc?.getString("jawaban_benar") ?: "",
                            tryout_id = doc?.getString("tryout_id") ?: "",
                            nomor = doc?.getLong("nomor") ?: 0,
                        )
                    )
                    return@addSnapshotListener
                }
            }
    }

    fun getAllSNBP(
        onSuccess: (List<SnbpModel>) -> Unit,
        onFailed: (Exception) -> Unit
    ){
        firestore
            .collection("snbp")
            .addSnapshotListener { value, error ->
                if (error != null) {
                    onFailed(error)
                    return@addSnapshotListener
                }
                value?.let {
                    onSuccess(
                        it.documents.map { doc ->
                            SnbpModel(
                                id = doc?.getString("id") ?: "",
                                isi = doc?.getString("isi") ?: "",
                                gambar= doc?.getString("gambar") ?: "",
                                judul = doc?.getString("judul") ?: "",
                                sub_judul = doc?.getString("sub_judul") ?: "",
                            )
                        }
                    )
                    return@addSnapshotListener
                }
            }
    }

    fun getSNBPById(
        id: String,
        onSuccess: (SnbpModel) -> Unit,
        onFailed: (Exception) -> Unit
    ) {
        firestore
            .collection("snbp")
            .document(id)
            .addSnapshotListener { value, error ->
                if (error != null) {
                    onFailed(error)
                }
                value?.let { doc ->
                    onSuccess(
                        SnbpModel(
                            id = doc?.getString("id") ?: "",
                            isi = doc?.getString("isi") ?: "",
                            gambar= doc?.getString("gambar") ?: "",
                            judul = doc?.getString("judul") ?: "",
                            sub_judul = doc?.getString("sub_judul") ?: "",
                        )
                    )
                    return@addSnapshotListener
                }
            }
    }


    fun getAllSNBT(
        onSuccess: (List<SnbpModel>) -> Unit,
        onFailed: (Exception) -> Unit
    ){
        firestore
            .collection("snbt")
            .addSnapshotListener { value, error ->
                if (error != null) {
                    onFailed(error)
                    return@addSnapshotListener
                }
                value?.let {
                    onSuccess(
                        it.documents.map { doc ->
                            SnbpModel(
                                id = doc?.getString("id") ?: "",
                                isi = doc?.getString("isi") ?: "",
                                gambar= doc?.getString("gambar") ?: "",
                                judul = doc?.getString("judul") ?: "",
                                sub_judul = doc?.getString("sub_judul") ?: "",
                            )
                        }
                    )
                    return@addSnapshotListener
                }
            }
    }

    fun getSNBTById(
        id: String,
        onSuccess: (SnbpModel) -> Unit,
        onFailed: (Exception) -> Unit
    ) {
        firestore
            .collection("snbt")
            .document(id)
            .addSnapshotListener { value, error ->
                if (error != null) {
                    onFailed(error)
                }
                value?.let { doc ->
                    onSuccess(
                        SnbpModel(
                            id = doc?.getString("id") ?: "",
                            isi = doc?.getString("isi") ?: "",
                            gambar= doc?.getString("gambar") ?: "",
                            judul = doc?.getString("judul") ?: "",
                            sub_judul = doc?.getString("sub_judul") ?: "",
                        )
                    )
                    return@addSnapshotListener
                }
            }
    }

}