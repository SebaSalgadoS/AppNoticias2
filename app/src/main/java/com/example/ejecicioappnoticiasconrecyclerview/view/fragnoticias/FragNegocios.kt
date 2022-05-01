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
import com.example.ejecicioappnoticiasconrecyclerview.databinding.FragmentFragNegociosBinding
import com.example.ejecicioappnoticiasconrecyclerview.repository.recyclerview.Adaptador
import com.example.ejecicioappnoticiasconrecyclerview.viewmodel.noticias.CategoriasViewModel

class FragNegocios : Fragment() {

    lateinit var binding: FragmentFragNegociosBinding
    lateinit var categoriasViewModel: CategoriasViewModel

    private lateinit var myRecyclerViewNegocios: RecyclerView
    private lateinit var adaptador: Adaptador

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFragNegociosBinding.inflate(layoutInflater)

        categoriasViewModel = ViewModelProvider(this).get(CategoriasViewModel::class.java)
        observar()

        myRecyclerViewNegocios = binding.myRecyclerViewNegocios
        myRecyclerViewNegocios.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        categoriasViewModel.onBtnMostrarCategoria("business")

        binding.btnMostrarNegocios.setOnClickListener {
            binding.progressBarNegocios.visibility = View.VISIBLE
            categoriasViewModel.onBtnMostrarCategoria("business")
        }

        return binding.root
    }

    private fun observar() {
        categoriasViewModel.noticias.observe(viewLifecycleOwner, Observer {
            binding.progressBarNegocios.visibility = View.GONE
            adaptador = Adaptador(requireContext().applicationContext, it.data)
            myRecyclerViewNegocios.adapter = adaptador
        })
    }


}