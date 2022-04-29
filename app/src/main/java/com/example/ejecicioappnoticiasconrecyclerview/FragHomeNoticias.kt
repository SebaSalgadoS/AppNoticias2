package com.example.ejecicioappnoticiasconrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ejecicioappnoticiasconrecyclerview.databinding.FragmentFragHomeNoticiasBinding
import com.example.ejecicioappnoticiasconrecyclerview.repository.recyclerview.Adaptador
import com.example.ejecicioappnoticiasconrecyclerview.view.MainActivity
import com.example.ejecicioappnoticiasconrecyclerview.viewmodel.MainViewModel

class FragHomeNoticias : Fragment() {

    lateinit var binding: FragmentFragHomeNoticiasBinding
    lateinit var homeViewModel: MainViewModel

    private lateinit var myRecyclerView1: RecyclerView
    private lateinit var adaptador: Adaptador


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFragHomeNoticiasBinding.inflate(layoutInflater)

        homeViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        observar()

        myRecyclerView1 = binding.myRecyclerView
        myRecyclerView1.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        return binding.root
    }

    private fun observar() {
        homeViewModel.noticias.observe(viewLifecycleOwner, Observer {
            binding.progressBar.visibility = View.GONE
            //binding.txtJson.text = "Noticias: \n"
            //binding.txtJson.append("${Gson().toJson(it)}")
            binding.progressBar.visibility = View.GONE
            adaptador = Adaptador(requireContext(), it.articles, MainActivity())
            myRecyclerView1.adapter = adaptador

        })
    }

}