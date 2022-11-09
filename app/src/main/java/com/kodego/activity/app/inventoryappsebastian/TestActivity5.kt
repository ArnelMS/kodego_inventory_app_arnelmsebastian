package com.kodego.activity.app.inventoryappsebastian

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import com.kodego.activity.app.inventoryappsebastian.databinding.ActivityTest5Binding

class TestActivity5 : AppCompatActivity() {

    private lateinit var binding : ActivityTest5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTest5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCamera2.setOnClickListener(){
            showCamera()
        }
    }

    private fun showCamera(){
        Dexter.withContext(this).withPermission(
            Manifest.permission.CAMERA
        ).withListener(object: PermissionListener{
            override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//                startActivity(cameraIntent) // only used to access camera

                cameraLauncher.launch(cameraIntent)
                Toast.makeText(applicationContext,"Permission Granted", Toast.LENGTH_SHORT).show()
            }

            override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                Toast.makeText(applicationContext,"Permission Granted", Toast.LENGTH_SHORT).show()
            }

            override fun onPermissionRationaleShouldBeShown(
                request: PermissionRequest?,
                token: PermissionToken?
            ) {
                token?.continuePermissionRequest()
            }

        }).onSameThread().check()
    }
    val cameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if (result.resultCode== Activity.RESULT_OK){
            result.data?.extras.let{
                val image : Bitmap = result.data?.extras?.get("data")as Bitmap
                binding.imgTestProfile.setImageBitmap(image)

            }
        }
    }

}