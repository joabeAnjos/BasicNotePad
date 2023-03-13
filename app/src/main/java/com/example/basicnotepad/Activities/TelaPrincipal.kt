package com.example.basicnotepad.Activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.basicnotepad.R
import com.example.basicnotepad.databinding.ActivityTelaPrincipalBinding
import com.google.firebase.auth.FirebaseAuth

class TelaPrincipal : AppCompatActivity() {

    private lateinit var binding: ActivityTelaPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.parseColor("#FF000000")
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
           // R.id.perfil -> iniciarDialogperfil()
            R.id.sair -> deslogarUsuario()
        }
        return super.onOptionsItemSelected(item)
    }

    fun deslogarUsuario(){
        FirebaseAuth.getInstance().signOut()
        val intent = Intent(this,TelaLogin::class.java)
        startActivity(intent)
        finish()
    }
}