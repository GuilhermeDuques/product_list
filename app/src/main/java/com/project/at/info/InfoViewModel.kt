package com.project.at.info

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.at.models.Jogador
import com.project.at.models.JogadorRepository
import kotlinx.coroutines.launch

class InfoViewModel(private val id: Long) : ViewModel() {

    var jogador = MutableLiveData<Jogador?>()
    init {
         pegarJogadorPorId()
    }
    fun pegarJogadorPorId() {
        viewModelScope.launch {
            jogador.value = JogadorRepository.buscarPor(id)
            Log.d("BuscarJogador", "Jogador retornado.")
            Log.d("BuscarJogador", "${jogador.value?.nome}")

        }
    }
}
