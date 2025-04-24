package com.example.confeitechmobile.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.confeitechmobile.ConfeitechApiSla
import com.example.confeitechmobile.dto.AndamentoDTO
import com.example.confeitechmobile.dto.AndamentoEncomenda
import com.example.confeitechmobile.dto.EncomendaDTO
import kotlinx.coroutines.launch

class EncomendaViewModel : ViewModel() {

    private val api = ConfeitechApiSla.api

    var lista = mutableStateListOf<EncomendaDTO>()
        private set

    var erros = mutableStateListOf<String>()
        private set

    var chamandoApi = mutableStateOf(false)
        private set

    init {
        atualizarLista()
    }

    fun isChamandoApi(): Boolean = chamandoApi.value

    fun atualizarLista() {
        erros.clear()
        viewModelScope.launch {
            chamandoApi.value = true
            try {
                var resposta = api.get()
                if (resposta.isNotEmpty()) {
                    lista.clear()
                    lista.addAll(resposta)
                }
            } catch (e: Exception) {
                lista.clear()
                erros.add("Erro ao buscar dados: ${e.message}")
            } finally {
                chamandoApi.value = false
            }
        }
    }

    fun carregarEncomendasAceitas() {
        erros.clear()
        viewModelScope.launch {
            chamandoApi.value = true
            try {
                var resposta = api.getAceitas()

                    lista.clear()
                    lista.addAll(resposta)
            } catch (e: Exception) {
                lista.clear()
                erros.add("Erro ao buscar encomendas aceitas: ${e.message}")
            } finally {
                chamandoApi.value = false
            }
        }
    }

    fun limparErros() {
        erros.clear()
    }

    fun atualizarAndamentoEncomenda(id: Long, novoAndamento: AndamentoEncomenda) {
        viewModelScope.launch {
            chamandoApi.value = true
            try {
                val andamentoDTO = AndamentoDTO(novoAndamento)
                api.atualizarAndamento(id, andamentoDTO)
            } catch (e: Exception) {
                erros.add("Erro ao atualizar andamento: ${e.message}")
            } finally {
                chamandoApi.value = false
            }
        }
    }

    fun carregarEncomendasPorUsuario() {
        erros.clear()
        viewModelScope.launch {
            chamandoApi.value = true
            try {
                val resposta = api.getEncomendasByUsuario()
                if (resposta.isNotEmpty()) {
                    lista.clear()
                    lista.addAll(resposta)
                }
            } catch (e: Exception) {
                erros.add("Erro ao buscar encomendas do usuário: ${e.message}")
            } finally {
                chamandoApi.value = false
            }
        }
    }
}

