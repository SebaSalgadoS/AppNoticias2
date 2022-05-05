package com.example.ejecicioappnoticiasconrecyclerview.view.fragnoticias

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ejecicioappnoticiasconrecyclerview.R
import com.example.ejecicioappnoticiasconrecyclerview.databinding.FragmentFragSaludBinding
import com.example.ejecicioappnoticiasconrecyclerview.repository.recyclerview.Adaptador
import com.example.ejecicioappnoticiasconrecyclerview.viewmodel.noticias.CategoriasViewModel


class FragSalud : Fragment() {

    lateinit var binding: FragmentFragSaludBinding
    lateinit var categoriasViewModel: CategoriasViewModel

    private lateinit var myRecyclerViewSalud: RecyclerView
    private lateinit var adaptador: Adaptador

    lateinit var idioma:String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFragSaludBinding.inflate(layoutInflater)


        categoriasViewModel = ViewModelProvider(this).get(CategoriasViewModel::class.java)
        observar()

        myRecyclerViewSalud = binding.myRecyclerViewSalud
        myRecyclerViewSalud.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        categoriasViewModel.onBtnMostrarCategoria("health", idioma)

        binding.btnMostrarSalud.setOnClickListener {
            binding.progressBarSalud.visibility = View.VISIBLE
            categoriasViewModel.onBtnMostrarCategoria("health", idioma)
        }

        return binding.root
    }

    private fun observar() {
        categoriasViewModel.noticias.observe(viewLifecycleOwner, Observer {
            binding.progressBarSalud.visibility = View.GONE
            adaptador = Adaptador(requireContext().applicationContext, it.data)
            myRecyclerViewSalud.adapter = adaptador
        })
    }


}