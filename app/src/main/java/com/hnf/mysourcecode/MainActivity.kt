package com.hnf.mysourcecode

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hnf.mysourcecode.admin.AdminActivity
import com.hnf.mysourcecode.admin.AdminBanner
import com.hnf.mysourcecode.agenda.Agenda
import com.hnf.mysourcecode.banner.Banner
import com.hnf.mysourcecode.databinding.ActivityMainBinding
import com.hnf.mysourcecode.quote.Quote

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.btSlider.setOnClickListener {
            Intent(this, Banner::class.java)
                .apply { startActivity(this) }
        }

        binding.btQuote.setOnClickListener {
            Intent(this, Quote::class.java)
                .apply { startActivity(this) }
        }

        binding.btAdmin.setOnClickListener {
            Intent(this, AdminActivity::class.java)
                .apply { startActivity(this) }
        }

        binding.btAgenda.setOnClickListener {
            Intent(this, Agenda::class.java)
                .apply { startActivity(this) }
        }
    }
}