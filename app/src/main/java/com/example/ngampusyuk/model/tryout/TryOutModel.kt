package com.example.ngampusyuk.model.tryout

import java.time.LocalDateTime

data class TryOutModel(
    val id : String,
    val gambar : String,
    val judul : String,
    val tanggal_start : String,
    val tanggal_end : String
)