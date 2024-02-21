package com.prates.roomdatabasecomkotlin.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(

    @ColumnInfo(name = "firt_name") val firtName: String,
    @ColumnInfo(name = "last_name") val lastName: String
){
    @PrimaryKey(autoGenerate = true)
    var uid : Int = 0
}