package com.kodego.activity.app.inventoryappsebastian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kodego.activity.app.inventoryappsebastian.databinding.ActivityTest3Binding

class TestActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityTest3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTest3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentOne = FragmentOne()
        val fragmentTwo = FragmentTwo()
        val fragmentThree = FragmentThree()

        //initial fragment
        supportFragmentManager.beginTransaction().apply {
            replace(binding.fragmentMain.id, fragmentOne)
            commit()
        }

        binding.btnFragment1.setOnClickListener() {
            supportFragmentManager.beginTransaction().apply {
                replace(binding.fragmentMain.id, fragmentOne)
                commit()
            }
        }
        binding.btnFragment2.setOnClickListener() {
            supportFragmentManager.beginTransaction().apply {
                replace(binding.fragmentMain.id, fragmentTwo)
                commit()
            }
        }
        binding.btnFragment3.setOnClickListener() {
            supportFragmentManager.beginTransaction().apply {
                replace(binding.fragmentMain.id, fragmentThree)
                commit()
            }
        }
    }
}
