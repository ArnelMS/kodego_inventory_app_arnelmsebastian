package com.kodego.activity.app.inventoryappsebastian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kodego.activity.app.inventoryappsebastian.databinding.ActivityTest2Binding

class TestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTest2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTest2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetName.setOnClickListener() {
//            Toast.makeText(applicationContext, "Hello from Toast", Toast.LENGTH_LONG).show()
            var name : String = binding.etvName.text.toString().uppercase()
            binding.textName.text = "Hi $name!"
        }
    }
}