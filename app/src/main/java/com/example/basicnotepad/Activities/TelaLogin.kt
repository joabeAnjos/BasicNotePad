package com.example.basicnotepad.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basicnotepad.R
import com.example.basicnotepad.databinding.ActivityTelaLoginBinding

class TelaLogin : AppCompatActivity() {

    private lateinit var binding: ActivityTelaLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
    }
}