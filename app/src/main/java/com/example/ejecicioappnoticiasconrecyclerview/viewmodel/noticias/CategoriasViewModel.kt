package com.example.ejecicioappnoticiasconrecyclerview.viewmodel.noticias

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ejecicioappnoticiasconrecyclerview.repository.interactor.noticias.NoticiaCategoriasInteractor
import com.example.ejecicioappnoticiasconrecyclerview.repository.retrofit.Noticias
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriasViewModel: ViewModel() {

    val noticias: MutableLiveData<Noticias> = MutableLiveData()
    private val interactor = NoticiaCategoriasInteractor()

    fun onBtnMostrarCategoria(categoria: String){
        CoroutineScope(Dispatchers.IO).launch {
            noticias.postValue(interactor.traerNoticiasDeporte(categoria))
        }
    }

}