package com.example.ejecicioappnoticiasconrecyclerview.repository.interactor.usuario


import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.usuario.RestEngineUsuario
import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.usuario.Usuario
import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.usuario.UsuarioAPIService
import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.usuario.UsuarioItem
import retrofit2.Call

class RegistroUsuarioInteractor {

    //CONSEGUIR Q EL METODO RETORNE UN USUARIOITEM
    fun registrarUsuario(x: Int, usuarioItem: UsuarioItem){
        val llamada: UsuarioAPIService = RestEngineUsuario.getRestEngine().create(UsuarioAPIService::class.java)
        val resultado: Call<UsuarioItem> = llamada.agregarUsuario(x, usuarioItem)
        val u: UsuarioItem? = resultado.execute().body()

    }

    fun validarRegistro(usuario: String): Usuario?{
        val llamada: UsuarioAPIService = RestEngineUsuario.getRestEngine().create(UsuarioAPIService::class.java)
        val resultado: Call<Usuario> = llamada.obtenerUsuarios("bd.json")
        val u: Usuario? = resultado.execute().body()

        for (i in u!!){
            if (i.usuario == usuario){
                return u
            }
        }
        return null
    }

    fun cantidadRegistros():Int {
        val llamada: UsuarioAPIService =
            RestEngineUsuario.getRestEngine().create(UsuarioAPIService::class.java)
        val resultado: Call<Usuario> = llamada.obtenerUsuarios("bd.json")
        val u: Usuario? = resultado.execute().body()
        return u!!.size
    }


}