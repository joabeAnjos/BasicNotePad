package com.example.basicnotepad.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basicnotepad.R
import com.example.basicnotepad.databinding.ActivityTelaEntrarBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class TelaEntrar : AppCompatActivity() {

    private lateinit var binding: ActivityTelaEntrarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaEntrarBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun logarUsuario(){
    }
}