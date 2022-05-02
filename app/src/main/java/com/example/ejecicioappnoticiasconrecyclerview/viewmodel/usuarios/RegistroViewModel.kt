package com.example.ejecicioappnoticiasconrecyclerview.viewmodel.usuarios

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ejecicioappnoticiasconrecyclerview.repository.interactor.usuario.RegistroUsuarioInteractor
import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.usuario.Usuario
import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.usuario.UsuarioItem
import kotlinx.coroutines.*

class RegistroViewModel: ViewModel() {


    var usuarios: MutableLiveData<Int> = MutableLiveData()
    private val registroInteractor = RegistroUsuarioInteractor()

    fun onBtnValidarUsuarioRegistro(usuarioItem: UsuarioItem){
        CoroutineScope(Dispatchers.IO).launch {

            var x: Usuario? = registroInteractor.validarRegistro(usuarioItem.usuario)

            if(x == null){
                //var cant = registroInteractor.cantidadRegistros()
                val aux: Int =
                    withContext(Dispatchers.Default) {
                        registroInteractor.cantidadRegistros()
                    }

                registroInteractor.registrarUsuario(aux, usuarioItem)
                usuarios.postValue(1)
            }
            else{
                usuarios.postValue(0)
            }

        }

    }


}