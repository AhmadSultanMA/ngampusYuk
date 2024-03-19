package com.example.ngampusyuk.model.tryout

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class TryOutModel(
    val id : String,
    val gambar : String,
    val judul : String,
    val tanggal_start : String,
    val tanggal_end : String,
    val status : MutableState<Boolean> = mutableStateOf(false)
)