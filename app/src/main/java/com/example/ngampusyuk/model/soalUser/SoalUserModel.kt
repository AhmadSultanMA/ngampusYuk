package com.example.ngampusyuk.model.soalUser

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class SoalUserModel(
    val id : String,
    val benar : Boolean,
    val jawab : String,
    val soal_id : String,
    val user_id : String,
    val tryout_user_id : String
)