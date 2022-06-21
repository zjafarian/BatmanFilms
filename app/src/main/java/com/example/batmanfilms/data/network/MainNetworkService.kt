package com.example.batmanfilms.data.network

import com.example.batmanfilms.models.ResponseBatmanSearch
import com.example.batmanfilms.models.ResponseFilm
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MainNetworkService {

    //get list of batman films
    @GET(".")
    suspend fun fetchGetListFilms(
        @Query("apikey") apiKey: String,
        @Query("s") search: String
    ): Response<ResponseBatmanSearch>


    //get detail of every film (batman)
    @GET(".")
    suspend fun fetchGetFilm( @Query("apikey") apiKey: String,
                              @Query("i") imdbID: String): Response<ResponseFilm>


}