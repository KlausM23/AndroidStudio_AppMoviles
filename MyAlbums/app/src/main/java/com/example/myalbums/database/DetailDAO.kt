package com.example.myalbums.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myalbums.entity.Detail

@Dao
interface DetailDAO {
    @Insert
    fun insertDetail(vararg detail: Detail)

    @Query("SELECT * FROM details ")
    fun getAllDetails(): List<Detail>

    @Delete
    fun deleteDetails(vararg detail: Detail)
}