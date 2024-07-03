package com.hnf.mysourcecode.admin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.hnf.mysourcecode.databinding.AdminBannerItemBinding

class AdminBannerAdapter() : RecyclerView.Adapter<AdminBannerAdapter.AdminBannerViewHolder>() {
    inner class AdminBannerViewHolder(itemView: AdminBannerItemBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        private val binding = itemView
        fun bind(url: String) {
            with(binding) {
                Glide.with(itemView)
                    .load(url)
                    .into(ivAdminBanner)
            }
        }
    }

    private val storage = FirebaseStorage.getInstance()
    private val storageRef = storage.reference
    private val bannersRef = mutableListOf<StorageReference>()

    private fun fetchBanners() {
        val listRef = storageRef.child("banner")
        listRef.listAll()
            .addOnSuccessListener { listResult ->
                listResult.items.forEach { item ->
                    bannersRef.add(item)
                }
                notifyDataSetChanged()
            }.addOnFailureListener {
                it.printStackTrace()
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdminBannerViewHolder {
        return AdminBannerViewHolder(
            AdminBannerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = bannersRef.size

    override fun onBindViewHolder(holder: AdminBannerViewHolder, position: Int) {
        if (position < bannersRef.size) {
            val imageRef = bannersRef[position]
            imageRef.downloadUrl.addOnSuccessListener { uri ->
                holder.bind(uri.toString())
            }.addOnFailureListener {
                it.printStackTrace()
            }
        }
    }

    init {
        fetchBanners()
    }

}