package com.example.basicnotepad.model

import android.util.Log
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class BancoDados {

    fun salvarDadosUsuario(nomes: String,cursos: String,turmas: String,periodos: String){

        val banco = FirebaseFirestore.getInstance()
        val uidUsuario = FirebaseAuth.getInstance().currentUser!!.uid

        val usuario = hashMapOf(
            "nome" to nomes,
            "curso" to cursos,
            "turma" to turmas,
            "periodo" to periodos
        )
        val documentoReferencia: DocumentReference = banco.collection("Dados").document(uidUsuario)
        documentoReferencia.set(usuario).addOnSuccessListener {
            Log.d("D","Sucesso!")
        }.addOnFailureListener {
            Log.d("erro","Erro ao salvar os dados ${it.printStackTrace()}")
        }
    }

    fun recuperarDadosUsuarioPerfil(nome: TextView, emailUser: TextView,curso: TextView,turma: TextView,periodo: TextView){
        val usuarioID = FirebaseAuth.getInstance().currentUser!!.uid
        val email = FirebaseAuth.getInstance().currentUser!!.email
        val bancoPerfilModel = FirebaseFirestore.getInstance()

        val documentReference: DocumentReference = bancoPerfilModel.collection("Dados").document(usuarioID)
        documentReference.addSnapshotListener { value, error ->
            if (value != null){
                nome.text = value.getString("nome")
                curso.text = value.getString("curso")
                turma.text = value.getString("turma")
                periodo.text = value.getString("periodo")
                emailUser.text = email
            }
        }
    }
}