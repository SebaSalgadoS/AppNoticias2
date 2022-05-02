package com.example.ejecicioappnoticiasconrecyclerview.view.usuario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ejecicioappnoticiasconrecyclerview.R
import com.example.ejecicioappnoticiasconrecyclerview.databinding.ActivityRegistroBinding
import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.usuario.UsuarioItem
import com.example.ejecicioappnoticiasconrecyclerview.viewmodel.usuarios.RegistroViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call

class Registro : AppCompatActivity() {

    lateinit var binding: ActivityRegistroBinding
    lateinit var registroViewModel: RegistroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registroViewModel = ViewModelProvider(this).get(RegistroViewModel::class.java)
        observar()

        binding.btnRegistrarUsuario.setOnClickListener {
            binding.progressBarRegistro.visibility = View.VISIBLE
            CoroutineScope(Dispatchers.IO).launch {
                var user = UsuarioItem(binding.txtRegistroNombre.text.toString(),
                    binding.txtRegistroUsuario.text.toString(),
                    binding.txtRegistroPass.text.toString(), binding.txtRegistroEmail.text.toString())

                registroViewModel.onBtnValidarUsuarioRegistro(user)

            }
        }

    }

    private fun observar() {
        registroViewModel.usuarios.observe(this, Observer {
            binding.progressBarRegistro.visibility = View.GONE
            if (registroViewModel.usuarios != null) {
                val intent = Intent(applicationContext, Login::class.java)
                startActivity(intent)
                Toast.makeText(applicationContext,"Usuario Agregado", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(applicationContext,"No se pudo Registrar el Usuario", Toast.LENGTH_SHORT).show()
            }
        })

    }
}




