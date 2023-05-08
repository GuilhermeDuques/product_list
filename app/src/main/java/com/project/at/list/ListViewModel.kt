package com.project.at.list

import androidx.lifecycle.ViewModel
import com.project.at.models.Jogador
import com.project.at.models.JogadorRepository

class ListViewModel : ViewModel() {
    private var jogadors: MutableList<Jogador>? = null

    init {
        pegarListaProdutos()
    }


    private fun pegarListaProdutos(){
        jogadors = JogadorRepository.listar()
    }
    fun getProdutos() =
        if (jogadors.isNullOrEmpty()) emptyList()
        else jogadors
}