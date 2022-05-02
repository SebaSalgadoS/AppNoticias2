package com.example.ejecicioappnoticiasconrecyclerview.repository.recyclerview

import android.content.Context
import android.content.Intent
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejecicioappnoticiasconrecyclerview.R

import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.Data
import com.example.ejecicioappnoticiasconrecyclerview.view.noticias.MainActivity
import com.example.ejecicioappnoticiasconrecyclerview.view.noticias.NoticiaView
import com.google.gson.Gson

class Adaptador (var context: Context, var listaNoticias: List<Data>): RecyclerView.Adapter<Adaptador.ViewHolderDatos>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDatos {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_recycler, null, false)
        return ViewHolderDatos(view)
    }

    override fun onBindViewHolder(holder: ViewHolderDatos, position: Int) {
        holder.itemView.animation =
            AnimationUtils.loadAnimation(context, R.anim.fade_transition)
        holder.titulo.text = Html.fromHtml(listaNoticias[position].title)
        holder.descripcion.text = Html.fromHtml(listaNoticias[position].description)

        Glide.with(context)
            .load(listaNoticias[position].image)
            .error(R.drawable.sin_imagen)
            .into(holder.imagen);

        holder.itemView.setOnClickListener {
            var detalle = Gson().toJson(listaNoticias[holder.layoutPosition])
            var intent = Intent(context, NoticiaView::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra("data", detalle)
            context.startActivity(intent)
        }

        //BOTON DE COMPARTIR NOTICIA
        /*
        holder.btnshare.setOnClickListener {
            var detalle = Html.fromHtml(listaNoticias[holder.layoutPosition].url)
            var intent = Intent()
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.action = Intent.ACTION_SEND
            intent.putExtra("data", detalle)
            intent.type="text/plain"
            context.startActivity(Intent.createChooser(intent, null))
        } */

    }



    override fun getItemCount(): Int {
        return listaNoticias.size
    }

    inner class ViewHolderDatos(itemView: View)
        : RecyclerView.ViewHolder(itemView) {
        var imagen: ImageView
        var titulo: TextView
        var descripcion: TextView
        //BOTON DE COMPARTIR NOTICIA
       // var btnshare: Button

        //contexto
        var con: Context

        init {
            imagen = itemView.findViewById(R.id.imgMenuNoticia)
            titulo = itemView.findViewById(R.id.txtMenuNoticia)
            descripcion = itemView.findViewById(R.id.txtMenuDescripcion)
            con = context

           //btnshare = itemView.findViewById(R.id.btnShare)
        }
    }

}