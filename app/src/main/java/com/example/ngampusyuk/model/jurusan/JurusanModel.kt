package com.example.ngampusyuk.model.jurusan

data class JurusanModel(
    val kampus_id : String,
    val fakultas_id : String,
    val id : String,
    val nama_jurusan : String,
    val snbp : Double,
    val snbt : Double,
    val tipe : Long,
    val jalur_masuk : String,
    val ukt_minimal : String,
    val ukt_maximal : String,
    val jumlah_pendaftar : Long,
    val kuota : Long,
    val passing_grade : Long,
    val peluang_kerja : Long,
    val tingkat_ketat : Long,
    val akreditasi : String,
)