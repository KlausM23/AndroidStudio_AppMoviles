package com.example.myalbums.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myalbums.entity.Detail

@Database(entities = [Detail::class], version = 1)
abstract class DetailDB: RoomDatabase() {
    abstract fun getJokeDAO():DetailDAO

    companion object{
        private var Instance:DetailDB?=null
        fun getInstance(context: Context):DetailDB{

            if(Instance==null){
                Instance= Room
                    .databaseBuilder(context,DetailDB::class.java,"joke.db").allowMainThreadQueries()
                    .build()
            }
            return Instance as DetailDB
        }
    }
}