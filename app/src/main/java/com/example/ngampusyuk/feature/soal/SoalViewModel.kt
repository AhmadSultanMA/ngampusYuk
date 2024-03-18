package com.example.ngampusyuk.feature.soal

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.ngampusyuk.data.Repository
import com.example.ngampusyuk.model.soal.SoalModel
import com.google.firebase.firestore.FirebaseFirestore

class SoalViewModel : ViewModel() {
    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val repository = Repository(firestore)

    val soal = mutableStateListOf<SoalModel>()

    fun getAllSoal(
        tryout_id : String
    ){
        repository.getAllSoal(
            tryout_id,
            onSuccess = {
                soal.clear()
                soal.addAll(
                    it.map { model ->
                        SoalModel(
                            id = model.id,
                            tryout_id = model.tryout_id,
                            jawaban_a = model.jawaban_a,
                            jawaban_b = model.jawaban_b,
                            jawaban_c = model.jawaban_c,
                            jawaban_d = model.jawaban_d,
                            jawaban_benar = model.jawaban_benar,
                            soal = model.soal,
                            nomor = model.nomor
                        )
                    }
                )
            },
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }
}