package com.example.jokeprojectbeforemiddleexam

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface JokeService {

    //@GET("")
    //fun getJoke(): Call<Joke>

    @GET("api")
    fun getJoke(@Query("format") format: String): Call<Joke>
}