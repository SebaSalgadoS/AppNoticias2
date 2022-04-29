package com.example.ejecicioappnoticiasconrecyclerview.repository.interactor.usuario

import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.usuario.RestEngineUsuario
import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.usuario.Usuario
import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.usuario.UsuarioAPIService
import retrofit2.Call

class LoginUsuarioInteractor {

    fun validarUsuario(usuario: String, password: String): Usuario?{

        val llamada: UsuarioAPIService = RestEngineUsuario.getRestEngineUsuario().create(UsuarioAPIService::class.java)
        val resultado: Call<Usuario> = llamada.obtenerUsuarios("bd.json")
        val u: Usuario? = resultado.execute().body()

        for (i in u!!){
            if (i.usuario == usuario && i.pass == password){
                return u
            }
        }
        return null

    }

}