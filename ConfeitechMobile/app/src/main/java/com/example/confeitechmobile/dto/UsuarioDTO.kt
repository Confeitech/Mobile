package com.example.confeitechmobile.dto

data class UsuarioDTO(
    var id: Long? = null,
    var nome: String? = null,
    var senha: String? = null,
    var telefone: String? = null,
    var dtNasc: String? = null,
    var ativo: Boolean? = null,
    var email: String? = null,
    var cep: String? = null
)
