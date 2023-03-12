package com.example.basicnotepad.Activities

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.basicnotepad.databinding.ActivityTelaCadastroBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class TelaCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityTelaCadastroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.parseColor("#FF000000")
        supportActionBar!!.hide()

        binding.btCadastro.setOnClickListener {

            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            if (email.isEmpty() || senha.isEmpty()){
                val snackbar = Snackbar.make(it,"Preencha todos os Dados!",Snackbar.LENGTH_SHORT)
                snackbar.setAnchorView(it)
                snackbar.show()
            }else{
                cadastro(it,email,senha)
            }
        }
    }
    private fun cadastro(view: View, email: String,senha: String){

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha).addOnCompleteListener {
            if (it.isSuccessful){
                val snackbar = Snackbar.make(view,"Cadastro realizado com Sucesso!",Snackbar.LENGTH_SHORT)
                snackbar.setAnchorView(view)
                snackbar.show()
            }
        }.addOnFailureListener {
            val erro = when(it){
                is FirebaseAuthWeakPasswordException -> "Necessário uma senha com no mínimo 6 caracteres!"
                is FirebaseAuthUserCollisionException -> "Este E-mail já foi usado!"
                is FirebaseNetworkException -> "Sem conexão com a Internet!"
                else -> "Erro ao cadastrar o usuário!"
            }
            val snackbar = Snackbar.make(view,erro,Snackbar.LENGTH_SHORT)
            snackbar.setAnchorView(view)
            snackbar.show()
        }
    }
}