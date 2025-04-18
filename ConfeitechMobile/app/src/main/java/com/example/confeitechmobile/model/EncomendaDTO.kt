package com.example.confeitechmobile.model

data class EncomendaDTO(
    var id: Long? = null,
    var preco: Double? = null,
    var observacoes: String? = null,
    var peso: Double? = null,
    var bolo: BoloDTO? = null,
    var adicionais: String? = null,
    var andamento: String? = null,
    var dataCriacao: String? = null,
    var dataRetirada: String? = null
)