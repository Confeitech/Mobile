package com.example.confeitechmobile.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.confeitechmobile.ConfeitechApiSla
import com.example.confeitechmobile.model.EncomendaDTO
import kotlinx.coroutines.launch

class EncomendaViewModel : ViewModel() {

    private val api = ConfeitechApiSla.api

    private val _lista = mutableStateListOf<EncomendaDTO>()
    private val _erros = mutableStateListOf<String>()
    private var _chamandoApi by mutableStateOf(false)

    init {
        atualizarLista()
    }

    val lista: List<EncomendaDTO>
        get() = _lista.toList()

    val erros: List<String>
        get() = _erros.toList()

    fun isChamandoApi() = _chamandoApi

    private fun atualizarLista() {
        _erros.clear()

        viewModelScope.launch {
            _chamandoApi = true
            Log.d("API", "Chamando API de encomendas...")
            try {
                val resposta = api.get()
                Log.d("API", "Recebido ${resposta.size} encomendas.")
                if (resposta.isNotEmpty()) {
                    _lista.clear()
                    _lista.addAll(resposta)
                }
            } catch (e: Exception) {
                Log.e("API", "Erro ao buscar dados: ${e.message}")
                _erros.add("Erro ao buscar dados: ${e.message}")
            } finally {
                _chamandoApi = false
            }
        }
    }

    fun limparErros() {
        _erros.clear()
    }
}
