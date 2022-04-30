package com.example.appchallenge2_retrofit

import com.google.gson.annotations.SerializedName

class Pokemon (
    val name: String,
    val height: Int,
    val weight: Int,
    //@SerializedName("front_default")
    //val frontDefault: String
    val sprites: Sprites

    )

class Sprites(
    @SerializedName("front_default")
    val frontDefault: String
)
