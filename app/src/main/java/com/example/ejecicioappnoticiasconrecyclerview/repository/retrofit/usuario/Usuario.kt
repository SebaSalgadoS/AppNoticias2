package com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.usuario

class Usuario: ArrayList<UsuarioItem>()

data class UsuarioItem(
    val nombre: String,
    val usuario: String,
    val pass: String,
    val email: String
)