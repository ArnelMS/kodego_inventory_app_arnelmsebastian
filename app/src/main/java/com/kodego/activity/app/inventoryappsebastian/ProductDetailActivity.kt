package com.kodego.activity.app.inventoryappsebastian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kodego.activity.app.inventoryappsebastian.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {

    lateinit var binding:ActivityProductDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //data from home activity
        var itemName: String? = intent.getStringExtra("itemName")
        var itemDescription: String? = intent.getStringExtra("itemDescription")
        var imageItem: Int = intent.getIntExtra("itemImage", 0)
        var quantity: Int = intent.getIntExtra("quantity", 0)

        binding.imgvItem2.setImageResource(imageItem)
        binding.txtvItemName2.text = itemName
        binding.txtvDescription2.text = itemDescription
        binding.txtvQuantity2.text = quantity.toString()
//        binding.txtvQuantity2.text = quantity()

    }
}