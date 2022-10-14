package com.kodego.activity.app.inventoryappsebastian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kodego.activity.app.inventoryappsebastian.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Binding Username and Password button.
        binding.btnLoginbutton.setOnClickListener() {

            //Login
            var userName: String = binding.etUsername.text.toString()
            var password: String = binding.etPassword.text.toString()
            checkCredential(userName, password)
        }
    }
    //private fun checkCredential to be used within the class only...
    private fun checkCredential(userName: String, password: String): Boolean{
        val correctUserName: String = "admin"
        val correctPassword: String = "admin123"

        if ((correctUserName == userName)&&(correctPassword == password)) {
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
            finish()
            Toast.makeText(applicationContext, "Logging in...", Toast.LENGTH_SHORT).show()
            return true

        }else{
            Toast.makeText(applicationContext, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            return false
            //assertEquals(checkCredentials("admin","Admin123"),true
        }
    }
}