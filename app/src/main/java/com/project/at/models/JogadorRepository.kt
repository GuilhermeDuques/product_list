package com.project.at.models

import kotlinx.coroutines.delay

object JogadorRepository {


    private val jogadors: MutableList<Jogador> = mutableListOf()


    fun inserir(jogador: Jogador){
        var nextId: Long = 1
        if (jogadors.isNotEmpty())
            nextId = jogadors.last().id + 1
        jogador.id = nextId
        jogadors.add(jogador)
    }

    fun listar() = jogadors
    suspend fun buscarPor(id: Long) : Jogador{
        delay(10 * 100)
        return jogadors.filter { prod -> prod.id == id }.first()
    }
}