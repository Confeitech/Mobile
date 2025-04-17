package com.example.confeitechmobile.model

data class Bolo(
    var id: Int? = null,
    var nome: String? = null,
    var preco: Double? = null,
    var descricao: String? = null,
    var ativo: Boolean? = null,
    var adicionais: Any? = null
)
