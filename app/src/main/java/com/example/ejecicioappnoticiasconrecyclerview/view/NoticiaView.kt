package com.example.ejecicioappnoticiasconrecyclerview.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.ejecicioappnoticiasconrecyclerview.R
import com.example.ejecicioappnoticiasconrecyclerview.databinding.ActivityMainBinding
import com.example.ejecicioappnoticiasconrecyclerview.databinding.ActivityNoticiaViewBinding
import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.Article
import com.google.gson.Gson
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.internal.notifyAll

class NoticiaView : AppCompatActivity() {
    lateinit var binding: ActivityNoticiaViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticiaViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val texto = intent.extras?.getString("data")

        val noticia: Article = Gson().fromJson(texto, Article::class.java)

        binding.txtTitular.text = noticia.title
        binding.txtDescripcion.text = noticia.description
        binding.txtAutor.text = "Autor: " + noticia.author
        binding.txtFecha.text = noticia.publishedAt
        binding.txtFuente.text = " Fuente: " + noticia.url


        Glide.with(applicationContext)
            .load(noticia.urlToImage)
            .error(R.drawable.sin_imagen)
            .into(binding.appImage);

    }
}