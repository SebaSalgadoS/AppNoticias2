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
import com.example.ejecicioappnoticiasconrecyclerview.databinding.FragmentFragCienciaBinding
import com.example.ejecicioappnoticiasconrecyclerview.repository.recyclerview.Adaptador
import com.example.ejecicioappnoticiasconrecyclerview.viewmodel.noticias.CategoriasViewModel


class FragCiencia : Fragment() {

    lateinit var binding: FragmentFragCienciaBinding
    lateinit var categoriasViewModel: CategoriasViewModel

    private lateinit var myRecyclerViewCiencia: RecyclerView
    private lateinit var adaptador: Adaptador

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFragCienciaBinding.inflate(layoutInflater)

        categoriasViewModel = ViewModelProvider(this).get(CategoriasViewModel::class.java)
        observar()

        myRecyclerViewCiencia = binding.myRecyclerViewCiencia
        myRecyclerViewCiencia.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        categoriasViewModel.onBtnMostrarCategoria("science")

        binding.btnmostrarCiencia.setOnClickListener {
            binding.progressBarCiencia.visibility = View.VISIBLE
            categoriasViewModel.onBtnMostrarCategoria("science")
        }

        return binding.root
    }

    private fun observar() {
        categoriasViewModel.noticias.observe(viewLifecycleOwner, Observer {
            binding.progressBarCiencia.visibility = View.GONE
            adaptador = Adaptador(requireContext().applicationContext, it.data)
            myRecyclerViewCiencia.adapter = adaptador
        })
    }


}