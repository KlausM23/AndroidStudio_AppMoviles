package com.example.jokeprojectbeforemiddleexam

import java.time.Instant
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

/*
* class Joke (
    val joke: String,
    var createdAt : String
        )
* */


@Entity(tableName = "jokes")
class Joke (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var createdAt : String,
    val joke: String
) :Serializable