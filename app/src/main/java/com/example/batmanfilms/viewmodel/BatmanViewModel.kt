package com.example.batmanfilms.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.batmanfilms.data.repository.BatmanRepository
import com.example.batmanfilms.models.SearchItem

class BatmanViewModel : ViewModel() {

    val batmanFilms = BatmanRepository.batmanFilmsList as LiveData<ArrayList<SearchItem>>




}