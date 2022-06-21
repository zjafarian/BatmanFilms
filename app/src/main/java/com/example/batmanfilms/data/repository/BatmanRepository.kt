package com.example.batmanfilms.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.batmanfilms.data.network.NetworkParams
import com.example.batmanfilms.data.network.RetrofitClientInstance
import com.example.batmanfilms.models.ResponseFilm
import com.example.batmanfilms.models.SearchItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object BatmanRepository {

    //value of batmanFilms
    val batmanFilmsList =
        MutableLiveData<ArrayList<SearchItem>>()

    //value of detialFilm
    val detailBatmanFilm = MutableLiveData<ResponseFilm>()

    val resultResponse = MutableLiveData<Boolean>()


    //this function is for getting list of batman films
    fun fetchGetBatmanFilmsList() {
        CoroutineScope(Dispatchers.IO).launch {

            //connect to server and get list of batman films
            val response = RetrofitClientInstance
                .retrofitService
                .fetchGetListFilms(
                    NetworkParams.API_KEY,
                    NetworkParams.SEARCH_BATMAN_FILM)

            if (response.code() == 200)
                resultResponse.postValue(true)
            else resultResponse.postValue(false)

            //set filmsItem from body in mutableLiveData
            response.body()?.search?.let { searchItems ->
                batmanFilmsList.postValue(searchItems)
            }


        }

    }


    //this function is for getting detail of every film
    fun fetchGetDetailOfFilm(id: String) {
        CoroutineScope(Dispatchers.IO).launch {

            //connect to server and get detail of batman films
            val response = RetrofitClientInstance
                .retrofitService
                .fetchGetFilm(NetworkParams.API_KEY,id)


            //set detail of every film in mutableLiveData
            detailBatmanFilm.postValue(response.body())
        }
    }
}