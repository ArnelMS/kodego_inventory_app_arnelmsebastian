package com.kodego.activity.app.inventoryappsebastian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kodego.activity.app.inventoryappsebastian.databinding.ActivityLifeCycleBinding

class LifeCycleActivity : AppCompatActivity() {

    lateinit var binding: ActivityLifeCycleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLifeCycleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener(){
            var intent = Intent(this, LifeCycleActivity2::class.java)
            startActivity(intent)
        }
    }
    override fun onStart(){
        super.onStart()
        Log.i("Activity LifeCycle", "Activity 1 - onStart")
    }
    override fun onResume(){
        super.onResume()
        Log.i("Activity LifeCycle", "Activity 1 - onResume")
    }
    override fun onPause(){
        super.onPause()
        Log.i("Activity LifeCycle", "Activity 1 - onPause")
    }
    override fun onStop(){
        super.onStop()
        Log.i("Activity LifeCycle", "Activity 1 - onStop")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.i("Activity LifeCycle", "Activity 1 - onDestroy")
    }
    override fun onRestart(){
        super.onRestart()
        Log.i("Activity LifeCycle", "Activity 1 - onRestart")
    }
}