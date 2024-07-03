package com.hnf.mysourcecode.banner

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.hnf.mysourcecode.databinding.ActivityBannerBinding
import kotlin.math.abs

class Banner : AppCompatActivity() {

    private lateinit var binding: ActivityBannerBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: BannerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBannerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        setUpTransformer()

    }


    private fun setUpTransformer() {
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.14f
        }

        viewPager.setPageTransformer(transformer)
    }

    private fun init() {

        viewPager = binding.viewPagerBanner
        adapter = BannerAdapter()
        binding.viewPagerBanner.adapter = adapter

        viewPager.offscreenPageLimit = 3
        viewPager.clipToPadding = false
        viewPager.clipChildren = false
        viewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
    }
}
