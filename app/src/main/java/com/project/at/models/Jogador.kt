package com.project.at.models


class Jogador (
    val nome: String,
    val time: String,
    val preco: Double,
    var id: Long = 0


    )
{
    override fun toString() = "$nome / $time (R$ $preco)"
}