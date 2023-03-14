package com.example.basicnotepad.Activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.basicnotepad.databinding.ActivityTelaCadastroBinding
import com.example.basicnotepad.model.BancoDados
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class TelaCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityTelaCadastroBinding
    val DB = BancoDados()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.parseColor("#FF000000")
        supportActionBar!!.hide()

        binding.btCadastro.setOnClickListener {

            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()
            val nome = binding.editNome.text.toString()
            val curso = binding.editCurso.text.toString()
            val turma = binding.editTurma.text.toString()
            val periodo = binding.editPeriodo.text.toString()

            if (email.isEmpty() || senha.isEmpty()){
                val snackbar = Snackbar.make(it,"Preencha todos os Dados!",Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.parseColor("#FF000000"))
                snackbar.setAnchorView(it)
                snackbar.show()
            }else{
                cadastro(it,email,senha,nome,curso,turma,periodo)
            }
        }
    }
    private fun cadastro(view: View, email: String,senha: String,nome: String,curso: String,turma: String,periodo: String){

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha).addOnCompleteListener {
            if (it.isSuccessful){
                DB.salvarDadosUsuario(nome,curso,turma,periodo)
                binding.progressBar.visibility = View.VISIBLE
                val snackbar = Snackbar.make(view,"Cadastro realizado com Sucesso!",Snackbar.LENGTH_SHORT)
                snackbar.setAnchorView(view)
                snackbar.show()
                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent(this,TelaPrincipal::class.java)
                    startActivity(intent)
                },1500)
            }
        }.addOnFailureListener {
            val erro = when(it){
                is FirebaseAuthWeakPasswordException -> "Necessário senha com no mínimo 6 caracteres!"
                is FirebaseAuthUserCollisionException -> "Este E-mail já foi usado!"
                is FirebaseNetworkException -> "Sem conexão com a Internet!"
                else -> "Erro ao cadastrar o usuário!"
            }
            val snackbar = Snackbar.make(view,erro,Snackbar.LENGTH_SHORT)
            snackbar.setBackgroundTint(Color.parseColor("#FF000000"))
            snackbar.setAnchorView(view)
            snackbar.show()
        }
    }
}