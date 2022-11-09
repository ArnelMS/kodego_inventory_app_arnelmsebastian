package com.kodego.activity.app.inventoryappsebastian

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import com.kodego.activity.app.inventoryappsebastian.databinding.ActivityTest4Binding
import com.kodego.activity.app.inventoryappsebastian.databinding.SampleCustomDialogBinding

class TestActivity4 : AppCompatActivity() {

    private lateinit var binding: ActivityTest4Binding
    private val image :String = "https://www.clipartmax.com/png/middle/46-466388_iron-man-png.png"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTest4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCustomDialog.setOnClickListener() {
            showCustomDialog()
        }
        binding.btnBuiltIn.setOnClickListener() {
            showBuiltInDialog()
        }
        binding.btnCamera.setOnClickListener() {
            showCamera()
        }

        binding.btnOpenGallery.setOnClickListener() {
            showGallery()
        }

        Glide.with(this)
            .load(image)
//            .circleCrop()
            .into(binding.imgImage)

    }

    private fun showGallery() {
        Dexter.withContext(this).withPermission(
            Manifest.permission.READ_EXTERNAL_STORAGE
        ).withListener(object : PermissionListener {
            override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                val galleryIntent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                galleryLauncher.launch(galleryIntent)
//                Toast.makeText(applicationContext, "Gallery Permission Granted", Toast.LENGTH_SHORT).show()
            }

            override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                Toast.makeText(applicationContext, "Gallery Permission Denied", Toast.LENGTH_SHORT)
                    .show()
                gotoSettings()
            }

            override fun onPermissionRationaleShouldBeShown(
                request: PermissionRequest?,
                token: PermissionToken?
            ) {
                token?.continuePermissionRequest()
            }

        }).onSameThread().check()
    }

    // USING CAMERA
    private fun showCamera() {
        Dexter.withContext(this).withPermission(
            Manifest.permission.CAMERA
        ).withListener(object : PermissionListener{
            override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//                startActivity(cameraIntent)
                cameraLauncher.launch(cameraIntent)
                Toast.makeText(applicationContext, "Camera Permission Approved", Toast.LENGTH_SHORT).show()
            }

            override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                Toast.makeText(applicationContext, "Camera Permission Denied", Toast.LENGTH_SHORT).show()
                gotoSettings()
            }

            override fun onPermissionRationaleShouldBeShown(
                request: PermissionRequest?,
                token: PermissionToken?
            ) {
                token?.continuePermissionRequest()
            }

        }).onSameThread().check()
    }

    private fun gotoSettings() {
        AlertDialog.Builder(this).setMessage("It seems that your permission has been denied. Go to settings to enable permission")
            .setPositiveButton("Got to settings"){dialog, item ->
                val intent = Intent(Settings.ACTION_APPLICATION_SETTINGS)
                var uri = Uri.fromParts("package", packageName, null)
                intent.data = uri
                startActivity(intent)
            }.setNegativeButton("Cancel"){dialog, item ->
                dialog.dismiss()
            }.show()
    }

    private fun showBuiltInDialog() {
        AlertDialog.Builder(this).setMessage("This is a Dialog Builder")
            .setPositiveButton("Positive") { dialog, item ->
                Toast.makeText(applicationContext, "Positive Button Pressed", Toast.LENGTH_SHORT)
                    .show()
            }
            .setNegativeButton("Negative") { dialog, item ->
                Toast.makeText(applicationContext, "Negative Button Pressed", Toast.LENGTH_SHORT)
                    .show()
            }.show()

    }

    private fun showCustomDialog() {
        val customDialog: Dialog = Dialog(this)
        var dialogBinding: SampleCustomDialogBinding =
            SampleCustomDialogBinding.inflate(layoutInflater)
        customDialog.setContentView(dialogBinding.root)

        dialogBinding.btnYes.setOnClickListener() {
            Toast.makeText(applicationContext, "Dialog box now closed", Toast.LENGTH_SHORT).show()
            customDialog.dismiss()
        }
        dialogBinding.btnNo.setOnClickListener() {
            Toast.makeText(applicationContext, "Ok... Enjoy dialog box", Toast.LENGTH_SHORT).show()
        }

        customDialog.show()

    }

    //handles images from the camera
    val cameraLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                result.data?.extras.let {
                    val image: Bitmap = result.data?.extras?.get("data") as Bitmap
                    binding.imgImage.setImageBitmap(image)
                }
            }
        }

    //handles images from gallery
    val galleryLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                result.data?.let {
                    val selectedImages = result.data?.data
                    binding.imgImage.setImageURI(selectedImages)
                }

            }
        }
}