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
            var name: String = binding.etvName.text.toString().uppercase()
            binding.txtViewName.text = "Hi $name!"

            binding.rgButtonGroup.setOnCheckedChangeListener { rgButton, checkedOptions ->
                when (checkedOptions) {
                    R.id.rb_Button01 -> Toast.makeText(applicationContext,"Button 1 Selected!", Toast.LENGTH_SHORT).show()
                    R.id.rb_Button02 -> Toast.makeText(applicationContext,"Button 2 Selected!", Toast.LENGTH_SHORT).show()
                    R.id.rb_Button03 -> Toast.makeText(applicationContext,"Button 3 Selected!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}