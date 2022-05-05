package com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.noticias

import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.Noticias
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NoticiasAPIService {


    @GET("news?access_key=e4197edbe84b087bbb0090977bb6339a")
    fun obtenerNoticias(@Query("languages") languages: String): Call<Noticias>


    @GET("news?languages=es&access_key=e4197edbe84b087bbb0090977bb6339a")
    fun obtenerNoticiasDeporte(@Query("categories") categoria: String,@Query("languages") languages: String): Call<Noticias>

    @GET("news?access_key=e4197edbe84b087bbb0090977bb6339a")
    fun buscarPalabraClave(@Query("keywords") keywords: String): Call<Noticias>
}