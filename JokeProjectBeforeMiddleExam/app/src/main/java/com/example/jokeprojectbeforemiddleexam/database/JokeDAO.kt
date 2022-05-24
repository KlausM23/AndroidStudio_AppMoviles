package com.example.jokeprojectbeforemiddleexam.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.jokeprojectbeforemiddleexam.Joke

interface JokeDAO {
    @Insert
    fun insertTeam(vararg joke: Joke)

    @Query("SELECT * FROM jokes ")
    fun getAllTeams(): List<Joke>

    @Delete
    fun deleteTeams(vararg joke: Joke)

    @Update
    fun updateTeams(vararg joke: Joke)
}