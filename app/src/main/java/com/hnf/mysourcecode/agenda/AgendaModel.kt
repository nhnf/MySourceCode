package com.hnf.mysourcecode.agenda

data class AgendaModel(
    val nama: String,
    val tanggal: com.google.firebase.Timestamp,
    val undangan: String,
    val kategori: String
)
