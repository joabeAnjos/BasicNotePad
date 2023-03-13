package com.example.basicnotepad.model

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class BancoDados {

    fun salvarDadosUsuario(nomes: String){

        val banco = FirebaseFirestore.getInstance()
        val uidUsuario = FirebaseAuth.getInstance().currentUser!!.uid

        val usuario = hashMapOf(
            "nome" to nomes
        )
        val documentoReferencia: DocumentReference = banco.collection("Dados").document(uidUsuario)
        documentoReferencia.set(usuario).addOnSuccessListener {
            Log.d("D","Sucesso!")
        }.addOnFailureListener {
            Log.d("erro","Erro ao salvar os dados ${it.printStackTrace()}")
        }
    }
}