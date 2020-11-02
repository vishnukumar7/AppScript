package com.android.vishnu.apps

import UserDetail
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserFile{

    @Insert
    fun insert(userDetail: UserDetail)

    @Query("select * from user")
    fun getAllUser() : List<UserDetail>



}