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
import com.example.ejecicioappnoticiasconrecyclerview.databinding.FragmentFragDeportesBinding
import com.example.ejecicioappnoticiasconrecyclerview.repository.recyclerview.Adaptador
import com.example.ejecicioappnoticiasconrecyclerview.viewmodel.noticias.CategoriasViewModel


class FragDeportes : Fragment() {

    lateinit var binding: FragmentFragDeportesBinding
    lateinit var categoriasViewModel: CategoriasViewModel

    private lateinit var myRecyclerViewDeportes: RecyclerView
    private lateinit var adaptador: Adaptador

    lateinit var idioma: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentFragDeportesBinding.inflate(layoutInflater)


        categoriasViewModel = ViewModelProvider(this).get(CategoriasViewModel::class.java)
        observar()

        myRecyclerViewDeportes = binding.myRecyclerViewDeportes
        myRecyclerViewDeportes.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        categoriasViewModel.onBtnMostrarCategoria("sports", idioma)

        binding.btnMostrarDeporte.setOnClickListener {
            binding.progressBarDeportes.visibility = View.VISIBLE
            categoriasViewModel.onBtnMostrarCategoria("sports", idioma)
        }


        return binding.root
    }

    private fun observar() {
        categoriasViewModel.noticias.observe(viewLifecycleOwner, Observer {
            binding.progressBarDeportes.visibility = View.GONE
            adaptador = Adaptador(requireContext().applicationContext, it.data)
            myRecyclerViewDeportes.adapter = adaptador
        })
    }


}