package com.example.ejecicioappnoticiasconrecyclerview.view.usuario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ejecicioappnoticiasconrecyclerview.databinding.ActivityLoginBinding
import com.example.ejecicioappnoticiasconrecyclerview.view.noticias.MainActivity
import com.example.ejecicioappnoticiasconrecyclerview.viewmodel.usuarios.LoginViewModel

class Login : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        observar()


        binding.btnLogin.setOnClickListener {

            var usuario = binding.txtUsuarioLogin.text.toString()
            var pass = binding.txtPassLogin.text.toString()

            loginViewModel.onBtnValidarUsuario(usuario,pass)

        }

        binding.btnRegistrar.setOnClickListener {
            val intent = Intent(applicationContext, Registro::class.java)
            startActivity(intent)
        }


    }

    private fun observar() {
        loginViewModel.usuarios.observe(this, Observer {
            binding.progressBar2.visibility = View.GONE
            if (it != null){
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(applicationContext,"Usuario no Registrado",Toast.LENGTH_SHORT).show()
            }
        })


    }
}