package com.example.ejecicioappnoticiasconrecyclerview.repository.recyclerview

import android.content.Context
import android.content.Intent
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejecicioappnoticiasconrecyclerview.R
import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.Article
import com.example.ejecicioappnoticiasconrecyclerview.view.MainActivity
import com.example.ejecicioappnoticiasconrecyclerview.view.NoticiaView
import com.google.gson.Gson

class Adaptador (var context: Context?, var listaNoticias: List<Article>,var actividad: MainActivity): RecyclerView.Adapter<Adaptador.ViewHolderDatos>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDatos {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_recycler, null, false)
        return ViewHolderDatos(view)
    }

    override fun onBindViewHolder(holder: ViewHolderDatos, position: Int) {
        holder.itemView.animation =
            AnimationUtils.loadAnimation(context, R.anim.fade_transition)
        holder.titulo.text = Html.fromHtml(listaNoticias[position].title)
        holder.descripcion.text = Html.fromHtml(listaNoticias[position].description)

        Glide.with(context!!)
            .load(listaNoticias[position].urlToImage)
            .error(R.drawable.sin_imagen)
            .into(holder.imagen);

        holder.itemView.setOnClickListener {
            var detalle = Gson().toJson(listaNoticias[holder.layoutPosition])

            var intent = Intent(actividad, NoticiaView::class.java)
            intent.putExtra("data", detalle)
            actividad.startActivity(intent)
        }
    }



    override fun getItemCount(): Int {
        return listaNoticias.size
    }

    inner class ViewHolderDatos(itemView: View)
        : RecyclerView.ViewHolder(itemView) {
        var imagen: ImageView
        var titulo: TextView
        var descripcion: TextView

        //contexto
        var con: Context

        init {
            imagen = itemView.findViewById(R.id.imgMenuNoticia)
            titulo = itemView.findViewById(R.id.txtMenuNoticia)
            descripcion = itemView.findViewById(R.id.txtMenuDescripcion)
            con = context!!
        }
    }

}