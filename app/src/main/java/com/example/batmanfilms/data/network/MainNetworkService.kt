package com.example.batmanfilms.data.network

import com.example.batmanfilms.models.ResponseBatmanSearch
import com.example.batmanfilms.models.ResponseFilm
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MainNetworkService {

    //get list of batman films
    @GET("${NetworkParams.SEARCH_PARAM}{s}")
    suspend fun fetchGetListFilms(@Path("s") filmName: String) : Response<ResponseBatmanSearch>


    //get detail of every film (batman)
    @GET("${NetworkParams.GET_FILM_PARAM}{i}")
    suspend fun fetchGetFilm(@Path("i") filmId: String) : Response<ResponseFilm>


}