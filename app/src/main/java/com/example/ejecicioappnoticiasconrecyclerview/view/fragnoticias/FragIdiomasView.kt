package com.example.ejecicioappnoticiasconrecyclerview.view.fragnoticias

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.ejecicioappnoticiasconrecyclerview.R
import com.example.ejecicioappnoticiasconrecyclerview.databinding.FragmentFragIdiomasViewBinding


class FragIdiomasView : Fragment() {

    lateinit var binding: FragmentFragIdiomasViewBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFragIdiomasViewBinding.inflate(layoutInflater)


        binding.btnIdioma.setOnClickListener {

            Toast.makeText(requireContext().applicationContext,escogerIdioma(),Toast.LENGTH_SHORT).show()
            var bundle = Bundle()
            bundle.putString("idioma",escogerIdioma())

            val fragment = FragHomeNoticias()
            fragment.arguments = bundle
            val fm: FragmentManager = requireActivity().supportFragmentManager
            val ft: FragmentTransaction = fm.beginTransaction()
            ft.replace(R.id.myFrame, fragment)
            ft.addToBackStack(null)
            ft.commit()

        }

        return binding.root
    }

    fun escogerIdioma():String{
        var idioma = ""
        if(binding.checkSpanish.isChecked){
            idioma = "es"
        }
        if (binding.checkIngles.isChecked){
            idioma = "en"
        }
        if (binding.checkIt.isChecked){
            idioma = "it"
        }
        if (binding.checkRuso.isChecked){
            idioma = "ru"
        }
        return idioma

    }



}