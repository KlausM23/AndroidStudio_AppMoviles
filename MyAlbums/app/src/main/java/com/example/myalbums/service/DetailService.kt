package com.example.myalbums.service

import com.example.myalbums.entity.Detail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailService {
    @GET("albums/{id}")
    fun getDetailInfo(@Path(value = "id") name:String): Call<Detail>
}