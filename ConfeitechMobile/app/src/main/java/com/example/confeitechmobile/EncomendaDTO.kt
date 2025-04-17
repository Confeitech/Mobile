package com.example.confeitechmobile

import com.example.confeitechmobile.model.Bolo


data class EncomendaDTO(
    var id: Long? = null,
    var preco: Double? = null,
    var observacoes: String? = null,
    var peso: Double? = null,
    var bolo: Bolo? = null,
    var adicionais: String? = null,
    var andamento: String? = null,
    var dataCriacao: String? = null,
    var dataRetirada: String? = null
)
