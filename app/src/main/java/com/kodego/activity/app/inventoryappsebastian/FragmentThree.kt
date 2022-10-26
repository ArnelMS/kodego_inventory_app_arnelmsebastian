package com.kodego.activity.app.inventoryappsebastian

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kodego.activity.app.inventoryappsebastian.databinding.FragmentThreeBinding

class FragmentThree : Fragment() {

    lateinit var binding: FragmentThreeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThreeBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }
}