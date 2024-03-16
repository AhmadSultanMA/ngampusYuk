package com.example.ngampusyuk.feature.pilihBanding

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.ngampusyuk.model.jurusan.JurusanModel
import com.example.ngampusyuk.model.kampus.KampusModel

class PilihBandingViewModel : ViewModel() {
    val kampus1 = mutableStateOf<KampusModel?>(null)
    val kampus2 = mutableStateOf<KampusModel?>(null)
    val jurusan1 = mutableStateOf<JurusanModel?>(null)
    val jurusan2 = mutableStateOf<JurusanModel?>(null)
}