package com.example.jokeprojectbeforemiddleexam.database

import android.content.Context
import androidx.room.Database;
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jokeprojectbeforemiddleexam.Joke

@Database(entities = [Joke::class], version = 1)
abstract class JokeDB: RoomDatabase() {
    abstract fun getJokeDAO():JokeDAO

    companion object{
        private var Instance:JokeDB?=null
        fun getInstance(context: Context):JokeDB{

            if(Instance==null){
                Instance= Room
                    .databaseBuilder(context,JokeDB::class.java,"joke.db").allowMainThreadQueries()
                    .build()
            }
            return Instance as JokeDB
        }
    }
}