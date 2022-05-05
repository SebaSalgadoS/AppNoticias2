package com.example.ejecicioappnoticiasconrecyclerview.view.fragnoticias

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentResultListener
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ejecicioappnoticiasconrecyclerview.databinding.FragmentFragHomeNoticiasBinding
import com.example.ejecicioappnoticiasconrecyclerview.repository.recyclerview.Adaptador
import com.example.ejecicioappnoticiasconrecyclerview.viewmodel.noticias.MainViewModel

class FragHomeNoticias : Fragment() {

    lateinit var binding: FragmentFragHomeNoticiasBinding
    lateinit var homeViewModel: MainViewModel

    private lateinit var myRecyclerView1: RecyclerView
    private lateinit var adaptador: Adaptador

    lateinit var idioma:String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFragHomeNoticiasBinding.inflate(layoutInflater)

        var bundle: Bundle? = arguments
        if(bundle != null){
            idioma = bundle!!.getString("idioma", "es")
        }
        else{
            idioma = "es"
        }

        homeViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        observar()

        myRecyclerView1 = binding.myRecyclerView
        myRecyclerView1.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        homeViewModel.onBtnMostrarNoticias(idioma)

        binding.btnMostrarNoticia.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            homeViewModel.onBtnMostrarNoticias(idioma)
        }

        binding.btnBuscarNoticia.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            homeViewModel.onBtnTraerKeywords(binding.textView.text.toString())
        }


        return binding.root
    }

    private fun observar() {
        homeViewModel.noticias.observe(viewLifecycleOwner, Observer {
            binding.progressBar.visibility = View.GONE
            //binding.txtJson.text = "Noticias: \n"
            //binding.txtJson.append("${Gson().toJson(it)}")
            adaptador = Adaptador(requireContext().applicationContext, it.data)
            myRecyclerView1.adapter = adaptador

        })
    }



}