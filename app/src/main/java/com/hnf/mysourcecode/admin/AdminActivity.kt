package com.hnf.mysourcecode.admin

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hnf.mysourcecode.R
import com.hnf.mysourcecode.banner.Banner
import com.hnf.mysourcecode.databinding.ActivityAdminBinding

class AdminActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btSlider.setOnClickListener {
            Intent(this, AdminBanner::class.java)
                .apply { startActivity(this) }
        }
    }
}