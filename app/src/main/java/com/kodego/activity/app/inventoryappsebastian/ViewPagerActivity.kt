package com.kodego.activity.app.inventoryappsebastian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.R
import com.google.android.material.tabs.TabLayoutMediator
import com.kodego.activity.app.inventoryappsebastian.databinding.ActivityViewPagerBinding
import layout.ViewPagerAdapter

class ViewPagerActivity : AppCompatActivity() {

    lateinit var binding: ActivityViewPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val images = listOf(
            R.drawable.ic_clock_black_24dp,"This is a Black Clock",
            R.drawable.ic_m3_chip_close,"This is an X",
            R.drawable.ic_mtrl_checked_circle,"This is a Check Mark",
            R.drawable.ic_keyboard_black_24dp, "This is a Keyboard"
        )
        val adapter = ViewPagerAdapter("Test", "Test Message")
        binding.viewPagerView.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPagerView) { tab, position ->
            tab.text = "Tab ${position + 1}"
        }.attach()
    }
}