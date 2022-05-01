package com.example.ejecicioappnoticiasconrecyclerview.view.fragnoticias

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ejecicioappnoticiasconrecyclerview.R
import com.example.ejecicioappnoticiasconrecyclerview.databinding.FragmentFragTecnologiaBinding
import com.example.ejecicioappnoticiasconrecyclerview.repository.recyclerview.Adaptador
import com.example.ejecicioappnoticiasconrecyclerview.viewmodel.noticias.CategoriasViewModel


class FragTecnologia : Fragment() {

    lateinit var  binding: FragmentFragTecnologiaBinding
    lateinit var categoriasViewModel: CategoriasViewModel

    private lateinit var myRecyclerViewTecnologia: RecyclerView
    private lateinit var adaptador: Adaptador

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFragTecnologiaBinding.inflate(layoutInflater)

        categoriasViewModel = ViewModelProvider(this).get(CategoriasViewModel::class.java)
        observar()

        myRecyclerViewTecnologia = binding.myRecyclerViewTecnologia
        myRecyclerViewTecnologia.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        categoriasViewModel.onBtnMostrarCategoria("technology")

        binding.btnMostrarTecnologia.setOnClickListener {
            binding.progressBarTecnologia.visibility = View.VISIBLE
            categoriasViewModel.onBtnMostrarCategoria("technology")
        }

        return binding.root
    }

    private fun observar() {
        categoriasViewModel.noticias.observe(viewLifecycleOwner, Observer {
            binding.progressBarTecnologia.visibility = View.GONE
            adaptador = Adaptador(requireContext().applicationContext, it.data)
            myRecyclerViewTecnologia.adapter = adaptador
        })
    }


}