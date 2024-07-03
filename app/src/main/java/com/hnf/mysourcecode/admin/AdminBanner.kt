package com.hnf.mysourcecode.admin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.hnf.mysourcecode.R
import com.hnf.mysourcecode.databinding.ActivityAdminBannerBinding

class AdminBanner : AppCompatActivity() {

    private lateinit var binding: ActivityAdminBannerBinding
    private lateinit var adapter: AdminBannerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBannerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = AdminBannerAdapter()
        binding.rvAdminBanner.adapter = adapter
        binding.rvAdminBanner.layoutManager = LinearLayoutManager(this)
    }
}