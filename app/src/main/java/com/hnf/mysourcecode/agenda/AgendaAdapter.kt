package com.hnf.mysourcecode.agenda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hnf.mysourcecode.databinding.AgendaItemBinding

class AgendaAdapter(private val data: List<AgendaModel>) : RecyclerView.Adapter<AgendaAdapter.AgendaViewHolder>() {
    inner class AgendaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = AgendaItemBinding.bind(itemView)
        fun bind(data: AgendaModel) {
            with(binding) {
                tvNama.text = data.nama
                tvTanggal.text = data.tanggal
                tvUndangan.text = data.undangan
                tvKategori.text = data.kategori
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgendaViewHolder {
        val view = AgendaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false).root
        return AgendaViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: AgendaViewHolder, position: Int) {
        holder.bind(data[position])
    }
}