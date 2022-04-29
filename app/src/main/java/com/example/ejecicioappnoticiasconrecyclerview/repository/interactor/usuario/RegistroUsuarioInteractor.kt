package com.example.ejecicioappnoticiasconrecyclerview.repository.interactor.usuario

import android.widget.Toast
import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.noticias.RestEngine
import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.usuario.RestEngineUsuario
import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.usuario.Usuario
import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.usuario.UsuarioAPIService
import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.usuario.UsuarioItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call

class RegistroUsuarioInteractor {

    //CONSEGUIR Q EL METODO RETORNE UN USUARIOITEM
   /* fun registrarUsuario(x: Int,usuarioItem: UsuarioItem): UsuarioItem?{

        CoroutineScope(Dispatchers.IO).launch {
            val llamada: UsuarioAPIService = RestEngineUsuario.getRestEngineUsuario().create(UsuarioAPIService::class.java)
            val resultado: Call<UsuarioItem> = llamada.agregarUsuario(x,usuarioItem)
            val u:UsuarioItem? = resultado.execute().body()

            if(u != null){
            }
        }


    } */

    fun validarRegistro(usuario: String, email: String): Usuario?{

        val llamada: UsuarioAPIService = RestEngineUsuario.getRestEngineUsuario().create(UsuarioAPIService::class.java)
        val resultado: Call<Usuario> = llamada.obtenerUsuarios("bd.json")
        val u: Usuario? = resultado.execute().body()

        for (i in u!!){
            if (i.usuario == usuario && i.email == email){
                return u
            }
        }
        return null

    }

    private fun cantidadRegistros():Int {
        val llamada: UsuarioAPIService =
            RestEngine.getRestEngine().create(UsuarioAPIService::class.java)
        val resultado: Call<Usuario> = llamada.obtenerUsuarios("bd.json")
        val u:Usuario? = resultado.execute().body()
        return u!!.size
    }


}