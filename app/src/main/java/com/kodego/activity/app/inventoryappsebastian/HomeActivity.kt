package com.kodego.activity.app.inventoryappsebastian

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kodego.activity.app.inventoryappsebastian.databinding.ActivityHomeBinding
import com.kodego.activity.app.inventoryappsebastian.databinding.AddDialogBinding
import com.kodego.activity.app.inventoryappsebastian.databinding.QuantityDialogBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var productList: MutableList<Products> = mutableListOf<Products>(
            Products(
                R.drawable.itemariel,
                "Ariel",
                "Hand wash and semi-automatic washing machines offers great stain removal.",
                15
            ),
            Products(
                R.drawable.itemchocnut,
                "ChocNut",
                "A confectionery, small bars, made with cocoa powder, peanuts and sugar.",
                10
            ),
            Products(
                R.drawable.itemclear,
                "Clear Shampoo",
                "Triple Anti Dandruff Technology, wherein it combines scalp care and skin care.",
                10
            ),
            Products(
                R.drawable.itemcloseup,
                "Close-Up",
                "first brand of toothpaste that combines the power of pastes and mouthwash.",
                20
            ),
            Products(
                R.drawable.itemcolgate,
                "Colgate",
                "With clinically-proven, unique formula that fights bacteria build-up for up to 12 hrs.",
                15
            ),
            Products(
                R.drawable.itemdelmonteketchup,
                "Del Monte Ketchup",
                "perfect blend of sweetness and tomato goodness for delicious dips.",
                10
            ),
            Products(
                R.drawable.itemheinz,
                "Heinz Ketchup",
                "made only from sweet, juicy, red ripe tomatoes.",
                12
            ),
            Products(
                R.drawable.itempalmolive,
                "Palmolive Shampoo",
                "actively treats and nourishes each strand for strong, shiny hair.",
                10
            ),
            Products(
                R.drawable.itemsafeguard,
                "Safeguard",
                "Antibacterial body wash is effective at killing germs.",
                18
            ),
            Products(
                R.drawable.itemtide,
                "Tide",
                "made out of surfactant molecules, water friendly and anti-water.",
                10
            ),
        )

        // pass data source to adapter
        adapter = ProductAdapter(productList)
        adapter.onItemClick = {
            val intent = Intent(this, ProductDetailActivity::class.java)
            intent.putExtra("itemName", it.itemName)
            intent.putExtra("itemDescription", it.itemDescription)
            intent.putExtra("itemImage", it.imageName)
            intent.putExtra("quantity", it.quantity)
            startActivity(intent)


            //            Toast.makeText(applicationContext,it.itemName,Toast.LENGTH_SHORT).show()
        }
        adapter.onUpdateButtonClick = { item: Products, position: Int ->
            showUpdateDialog(item, position)
        }
        adapter.onDeleteButtonClick = { item: Products, position: Int ->
            adapter.products.removeAt(position)
            adapter.notifyDataSetChanged()
        }

        binding.floatingActionButton.setOnClickListener() {
            showAddDialog()
//            Toast.makeText(applicationContext,"TEST",Toast.LENGTH_SHORT).show() // OK-WOKING

        }

        binding.myRecycler.adapter = adapter
        binding.myRecycler.layoutManager = LinearLayoutManager(this)
    }

    fun showUpdateDialog(item: Products, position: Int) {
        val dialog = Dialog(this)
        val binding: QuantityDialogBinding = QuantityDialogBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)
        dialog.show()

        binding.btnUpdateQuantity.setOnClickListener() {
            var newQuantity: Int = binding.etxtQtyDialog.text.toString().toInt()
            adapter.products[position].quantity = newQuantity
            adapter.notifyDataSetChanged()
            dialog.dismiss()
        }
    }

    fun showAddDialog() {
        val dialog = Dialog(this)
        val binding: AddDialogBinding = AddDialogBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)
        dialog.show()

        val images = arrayListOf<String>(
            "itemariel",
            "itemchocnut",
            "itemclear",
            "itemcloseup",
            "itemcolgate",
            "itemdelmonteketchup",
            "itemheinz",
            "itempalmolive",
            "itemsafeguard",
            "itemtide"
        )
        val spinnerAdapter = ArrayAdapter(applicationContext, R.layout.textview_xml, images)
        binding.spnimage.adapter = spinnerAdapter

        binding.btnAdd.setOnClickListener() {
            var image: Int = resources.getIdentifier(
                (binding.spnimage.selectedItem.toString()),
                "drawable",
                packageName
            )
            var itemName: String = binding.etxtitemnameadd.text.toString()
            var itemDesc: String = binding.etxtitemdescriptionadd.text.toString()
            var itemNewQuantity = binding.etxtquantity.text.toString().toInt()

            adapter.products.add(Products(image, itemName, itemDesc, itemNewQuantity))
            adapter.notifyItemInserted(adapter.itemCount + 1)
            dialog.dismiss()

        }
    }
}