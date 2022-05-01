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
import com.example.ejecicioappnoticiasconrecyclerview.databinding.FragmentFragEntretenimientoBinding
import com.example.ejecicioappnoticiasconrecyclerview.repository.recyclerview.Adaptador
import com.example.ejecicioappnoticiasconrecyclerview.viewmodel.noticias.CategoriasViewModel


class FragEntretenimiento : Fragment() {

    lateinit var binding: FragmentFragEntretenimientoBinding
    lateinit var categoriasViewModel: CategoriasViewModel

    private lateinit var myRecyclerViewEntretenimiento: RecyclerView
    private lateinit var adaptador: Adaptador

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFragEntretenimientoBinding.inflate(layoutInflater)

        categoriasViewModel = ViewModelProvider(this).get(CategoriasViewModel::class.java)
        observar()

        myRecyclerViewEntretenimiento = binding.myRecyclerViewEntretenimiento
        myRecyclerViewEntretenimiento.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        categoriasViewModel.onBtnMostrarCategoria("entertainment")

        binding.btnMostrarEntretenimiento.setOnClickListener {
            binding.progressBarEntretenimiento.visibility = View.VISIBLE
            categoriasViewModel.onBtnMostrarCategoria("entertainment")
        }

        return binding.root
    }

    private fun observar() {
        categoriasViewModel.noticias.observe(viewLifecycleOwner, Observer {
            binding.progressBarEntretenimiento.visibility = View.GONE
            adaptador = Adaptador(requireContext().applicationContext, it.data)
            myRecyclerViewEntretenimiento.adapter = adaptador
        })
    }


}