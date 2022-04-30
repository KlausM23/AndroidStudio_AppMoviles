package com.example.appchallenge2_retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {
    //@GET("pokemon")
    //fun getPokemonInfo(@Query("limit") limit: Int, @Query("offset")offset: Int): Call<List<Pokemon>>

    @GET("pokemon/{name}")
    fun getPokemonInfo(@Path(value = "name") name:String): Call<Pokemon>

}