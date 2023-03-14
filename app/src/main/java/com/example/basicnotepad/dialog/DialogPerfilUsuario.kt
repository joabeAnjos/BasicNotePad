package com.example.basicnotepad.dialog

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import com.example.basicnotepad.Activities.TelaLogin
import com.example.basicnotepad.databinding.DialogUsuarioBinding
import com.example.basicnotepad.model.BancoDados
import com.google.firebase.auth.FirebaseAuth

class DialogPerfilUsuario(private val activity: Activity) {

    lateinit var dialog: AlertDialog
    lateinit var binding: DialogUsuarioBinding

    fun iniciarPerfilUsuario(){
        val construir = AlertDialog.Builder(activity)
        binding = DialogUsuarioBinding.inflate(activity.layoutInflater)
        construir.setView(binding.root)
        construir.setCancelable(true)
        dialog = construir.create()
        dialog.show()
    }
    fun recuperarDadosUsuario(){
        val nome = binding.txtperfil
        val email = binding.txtEmail
        val curso = binding.txtCurso
        val turma = binding.txtTurma
        val periodo = binding.txtPeriodo
        val db = BancoDados()
        db.recuperarDadosUsuarioPerfil(nome,email,curso,turma,periodo)

        binding.btSair.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(activity,TelaLogin::class.java)
            activity.startActivity(intent)
            activity.finish()
        }
    }
}