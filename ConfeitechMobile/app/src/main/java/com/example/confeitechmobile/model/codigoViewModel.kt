package com.example.confeitechmobile.model

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.confeitechmobile.ConfeitechApiSla

class codigoViewModel : ViewModel() {

    private val api = ConfeitechApiSla.api

    var chamandoApi = mutableStateOf(false)
        private set

    var erros = mutableStateListOf<String>()
        private set

    fun isChamandoApi(): Boolean = chamandoApi.value

    suspend fun carregarCardapio(){
        chamandoApi.value = true
        erros.clear()

        try {
            val resposta = api.getUsers()
        } catch (e: Exception) {
            erros.add("Erro ao buscar o cardápio: ${e.message}")
        } finally {
            chamandoApi.value = false
        }
    }

    fun limparErros() {
        erros.clear()
    }
}
