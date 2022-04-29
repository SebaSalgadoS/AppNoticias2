package com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.noticias

import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.Noticias
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NoticiasAPIService {

    @Headers(
        value = [
            "X-Api-Key: 9738b6dbd20541cea12db936316fec43",
            "content-type: application/json; charset=utf-8"
        ]
    )
    @GET("everything?q=chile")
    fun obtenerNoticias(@Query("language") languages: String): Call<Noticias>
}