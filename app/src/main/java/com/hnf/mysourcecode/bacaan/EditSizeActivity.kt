package com.hnf.mysourcecode.bacaan

import android.os.Bundle
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hnf.mysourcecode.R
import com.hnf.mysourcecode.databinding.ActivityEditSizeBinding

class EditSizeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditSizeBinding
    private lateinit var seekBar: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEditSizeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.seekbarArab.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val newTextSize = 34 + progress
                binding.tvReview.textSize = newTextSize.toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
    }
}