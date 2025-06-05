package com.example.confeitechmobile.dto

data class EncomendaDTOCriar(
    val id: Long? = null,
    val preco: Double,
    val observacoes: String?,
    val peso: Double?,
    val bolo: Long, // apenas o ID
    val adicionais: String? = null,
    val andamento: String? = null,
    val dataCriacao: String? = null,
    val dataRetirada: String,
    val user: Long // apenas o ID
)

