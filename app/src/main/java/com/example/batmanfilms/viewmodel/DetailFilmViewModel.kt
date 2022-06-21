package com.example.batmanfilms.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.batmanfilms.data.repository.BatmanRepository
import com.example.batmanfilms.models.ResponseFilm

class DetailFilmViewModel : ViewModel(){

    val detailFilm = BatmanRepository.detailBatmanFilm as LiveData<ResponseFilm>
    fun fetchGetDetailOfFilm(imdbId : String){
        BatmanRepository.fetchGetDetailOfFilm(imdbId)
    }

}