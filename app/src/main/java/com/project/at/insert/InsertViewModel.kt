package com.project.at.insert

import androidx.lifecycle.ViewModel
import com.project.at.models.Jogador
import com.project.at.models.JogadorRepository

class InsertViewModel : ViewModel() {
    fun inserirProduto(nome: String, loja: String, preco: Double){
        val jogador = Jogador(nome, loja, preco)
        JogadorRepository.inserir(jogador)
    }
}