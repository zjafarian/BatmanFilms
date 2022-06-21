package com.example.batmanfilms.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.batmanfilms.data.repository.BatmanRepository

class SplashViewModel : ViewModel() {
    val result = BatmanRepository.resultResponse as LiveData<Boolean>

    //fetch list of batman films
    fun fetchGetBatmanFilms(){
        BatmanRepository.fetchGetBatmanFilmsList()
    }

}