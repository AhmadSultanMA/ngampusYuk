package com.example.ngampusyuk.model.soal

data class SoalModel(
    val id : String,
    val tryout_id : String,
    val jawaban_a : String,
    val jawaban_b : String,
    val jawaban_c : String,
    val jawaban_d : String,
    val jawaban_benar : String,
    val nomor : Long,
    val soal : String,
)