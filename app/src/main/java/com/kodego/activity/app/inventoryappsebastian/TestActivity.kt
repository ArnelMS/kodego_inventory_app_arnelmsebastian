package com.kodego.activity.app.inventoryappsebastian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.kodego.activity.app.inventoryappsebastian.databinding.ActivityTest2Binding

class TestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTest2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTest2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //  button, editext and texview
        binding.btnGetName.setOnClickListener() {
            //  Toast.makeText(applicationContext, "Hello from Toast", Toast.LENGTH_LONG).show()
            var name: String = binding.etvName.text.toString().uppercase()
            binding.txtViewName.text = "Hi $name!"

            var spinnerItem: String = binding.spinnerId.selectedItem.toString()
            Toast.makeText(applicationContext,spinnerItem,Toast.LENGTH_SHORT).show()

        }

        // radiogroup and radio button
        binding.rgButtonGroup.setOnCheckedChangeListener { rgButton, checkedOptions ->
            when (checkedOptions) {
                R.id.rb_Button01 -> Toast.makeText(
                    applicationContext,
                    "Button 1 Selected!",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.rb_Button02 -> Toast.makeText(
                    applicationContext,
                    "Button 2 Selected!",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.rb_Button03 -> Toast.makeText(
                    applicationContext,
                    "Button 3 Selected!",
                    Toast.LENGTH_SHORT
                ).show()
            }

            binding.chkbox01.setOnClickListener() {
                if (binding.chkbox01.isChecked) {
                    Toast.makeText(applicationContext, "Checkbox 1 is checked!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, "Checkbox 1 is Unchecked!", Toast.LENGTH_SHORT).show()

                }
            binding.chkbox02.setOnClickListener() {
                if (binding.chkbox02.isChecked) {
                   Toast.makeText(applicationContext, "Checkbox 2 is checked!",Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, "Checkbox 2 is Unchecked!",Toast.LENGTH_SHORT).show()
                    }
                }
                // spinner (drop down box)
                val data = arrayListOf<String>("Option 1", "Option 2", "Option 3")
                val adapterParent = ArrayAdapter(applicationContext, R.layout.textview_xml, data)

                binding.spinnerId.adapter = adapterParent

                // switch or toggle
                binding.switchButton.setOnClickListener(){
                    if(binding.switchButton.isChecked) {
                        Toast.makeText(applicationContext, "On",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(applicationContext, "Off",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}