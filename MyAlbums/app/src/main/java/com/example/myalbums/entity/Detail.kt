package com.example.myalbums.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "details")
class Detail (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val userId : Int,
    val title : String
        ) : Serializable