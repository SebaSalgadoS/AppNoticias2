package com.example.ejecicioappnoticiasconrecyclerview.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ejecicioappnoticiasconrecyclerview.repository.interactor.noticias.NoticiasInteractor
import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.Noticias
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel(){

    val noticias: MutableLiveData<Noticias> = MutableLiveData()
    private val interactor = NoticiasInteractor()

    fun onBtnMostrarNoticias(){
        CoroutineScope(Dispatchers.IO).launch {
            noticias.postValue(interactor.traerRespuesta("es"))
        }
    }

}