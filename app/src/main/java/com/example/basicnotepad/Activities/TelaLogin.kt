package com.example.basicnotepad.Activities

import android.content.Intent
import android.graphics.Color
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
        window.statusBarColor = Color.parseColor("#FF000000")

        binding.btLogin.setOnClickListener {
            val intent = Intent(this,TelaEntrar::class.java)
            startActivity(intent)
        }
        binding.txtCadastrar.setOnClickListener {
            val intent = Intent(this,TelaCadastro::class.java)
            startActivity(intent)
        }

    }
}