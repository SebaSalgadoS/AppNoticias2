package com.example.ejecicioappnoticiasconrecyclerview.view.noticias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.ejecicioappnoticiasconrecyclerview.R
import com.example.ejecicioappnoticiasconrecyclerview.databinding.ActivityNoticiaViewBinding
import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.Data
import com.google.gson.Gson

class NoticiaView : AppCompatActivity() {
    lateinit var binding: ActivityNoticiaViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticiaViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val texto = intent.extras?.getString("data")

        val noticia: Data = Gson().fromJson(texto, Data::class.java)

        binding.txtTitular.text = noticia.title
        binding.txtDescripcion.text = noticia.description
        binding.txtAutor.text = "Autor: " + noticia.author
        binding.txtFecha.text = noticia.published_at
        binding.txtFuente.text = " Fuente: " + noticia.url


        Glide.with(applicationContext)
            .load(noticia.image)
            .error(R.drawable.sin_imagen)
            .into(binding.appImage);

    }
}