package com.example.basicnotepad.Activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.basicnotepad.R
import com.example.basicnotepad.databinding.ActivityTelaEntrarBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class TelaEntrar : AppCompatActivity() {

    private lateinit var binding: ActivityTelaEntrarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaEntrarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        window.statusBarColor = Color.parseColor("#FF000000")

        binding.btEntrar.setOnClickListener {
            logarUsuario()
        }
    }

    fun logarUsuario(){

        val email = binding.editEmail.text.toString()
        val senha = binding.editSenha.text.toString()

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,senha).addOnSuccessListener {
            val intent = Intent(this,TelaPrincipal::class.java)
            startActivity(intent)
        }.addOnFailureListener {

        }
    }
}