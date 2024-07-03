package com.hnf.mysourcecode.agenda

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.hnf.mysourcecode.databinding.ActivityAgendaBinding

class Agenda : AppCompatActivity() {

    private lateinit var binding: ActivityAgendaBinding
    private val bd = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgendaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd.collection("agenda")
            .get()
            .addOnSuccessListener {
                val listData: ArrayList<AgendaModel> = ArrayList()
                listData.clear()

                for (document in it) {
                    listData.add(AgendaModel(
                        document.get("nama").toString(),
                        document.get("tanggal").toString(),
                        document.get("undangan").toString(),
                        document.get("kategori").toString()
                    ))
                }

                val agendaAdapter = AgendaAdapter(listData)
                binding.rvAgenda.apply {
                    adapter = agendaAdapter
                    layoutManager = LinearLayoutManager(context)
                }
            }
            .addOnFailureListener {
                Log.v("Error", "Gagal mengambil data")
            }

        }
    }
