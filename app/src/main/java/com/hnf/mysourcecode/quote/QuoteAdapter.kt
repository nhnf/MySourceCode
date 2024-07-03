package com.hnf.mysourcecode.quote

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.hnf.mysourcecode.databinding.QuoteItemBinding

class QuoteAdapter() : RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder>() {
    inner class QuoteViewHolder(itemView: QuoteItemBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        private val binding = itemView
        fun bind(url: String) {
            with(binding) {
                Glide.with(itemView)
                    .load(url)
                    .into(ivQuote)
            }
        }
    }

    private val storage = FirebaseStorage.getInstance()
    private val storageRef = storage.reference
    private val imageRefs = mutableListOf<StorageReference>()

    private fun fetchImagesRefs() {
        val imagesRef = storageRef.child("quote")
        imagesRef.listAll().addOnSuccessListener { listResult ->
            listResult.items.forEach { item ->
                imageRefs.add(item)
            }
            notifyDataSetChanged()
        }.addOnFailureListener {
            it.printStackTrace()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        return QuoteViewHolder(
            QuoteItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = imageRefs.size

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        if (position < imageRefs.size) {
         val imageRef = imageRefs[position]
         imageRef.downloadUrl.addOnSuccessListener { uri ->
             holder.bind(uri.toString())
         }.addOnFailureListener {
             it.printStackTrace()
         }
        }
    }

    init {
        fetchImagesRefs()
    }
}