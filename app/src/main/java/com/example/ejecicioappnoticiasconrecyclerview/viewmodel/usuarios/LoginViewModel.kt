package com.example.ejecicioappnoticiasconrecyclerview.viewmodel.usuarios

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ejecicioappnoticiasconrecyclerview.repository.interactor.usuario.LoginUsuarioInteractor
import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.usuario.Usuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    var usuarios: MutableLiveData<Usuario> = MutableLiveData()
    private val interactorUsuario = LoginUsuarioInteractor()


    fun onBtnValidarUsuario(usuario: String, pass: String){
        CoroutineScope(Dispatchers.IO).launch {
          usuarios.postValue(interactorUsuario.validarUsuario(usuario, pass))
        }
    }
}