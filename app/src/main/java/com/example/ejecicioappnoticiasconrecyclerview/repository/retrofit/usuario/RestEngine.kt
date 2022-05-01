package com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.usuario

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestEngine {

        companion object{

            fun getRestEngine(): Retrofit {
                val interceptor = HttpLoggingInterceptor()
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

                val cliente = OkHttpClient.Builder().addInterceptor(interceptor).build()

                val retrofit = Retrofit.Builder().baseUrl("https://login-usuario-noticias-default-rtdb.firebaseio.com/")
                    .addConverterFactory(GsonConverterFactory.create()).client(cliente).build()

                return  retrofit
            }
        }
}