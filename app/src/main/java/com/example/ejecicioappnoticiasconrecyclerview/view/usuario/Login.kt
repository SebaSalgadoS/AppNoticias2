package com.example.ejecicioappnoticiasconrecyclerview.view.usuario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ejecicioappnoticiasconrecyclerview.R
import com.example.ejecicioappnoticiasconrecyclerview.databinding.ActivityLoginBinding
import com.example.ejecicioappnoticiasconrecyclerview.viewmodel.LoginViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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


    }

    private fun observar() {
        loginViewModel.usuarios.observe(this, Observer {
            binding.progressBar2.visibility = View.GONE
            if (loginViewModel.usuarios != null){
                Toast.makeText(applicationContext,"funciona",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext,"no funciona",Toast.LENGTH_SHORT).show()
            }
        })


    }
}