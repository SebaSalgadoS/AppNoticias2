package com.example.ejecicioappnoticiasconrecyclerview.view.noticias

import android.content.Intent
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

        binding.myWebView.loadUrl(noticia.url)

        binding.shareBtn.setOnClickListener {
            val intent= Intent()
            intent.action=Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,"Mira esta Noticia: "+ noticia.url)
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Compartir Noticia a: "))
        }



    }
}