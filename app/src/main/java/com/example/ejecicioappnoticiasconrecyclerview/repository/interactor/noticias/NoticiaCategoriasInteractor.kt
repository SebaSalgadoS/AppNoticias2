package com.example.ejecicioappnoticiasconrecyclerview.repository.interactor.noticias

import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.Noticias
import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.noticias.NoticiasAPIService
import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.noticias.RestEngine
import retrofit2.Call

class NoticiaCategoriasInteractor {

    fun traerNoticiasDeporte(categoria: String): Noticias?{
        val llamada: NoticiasAPIService = RestEngine.getRestEngine().create(NoticiasAPIService::class.java)
        val resultado: Call<Noticias> = llamada.obtenerNoticiasDeporte(categoria)
        val p: Noticias? = resultado.execute().body()

        return p
    }
}