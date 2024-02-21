package com.prates.roomdatabasecomkotlin.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.prates.roomdatabasecomkotlin.database.models.User

@Dao
interface UserDao {

    @Insert
     fun insert(user: User)

    @Query("SELECT COUNT(uid) FROM user")
     fun getTotalItens() : Long

}