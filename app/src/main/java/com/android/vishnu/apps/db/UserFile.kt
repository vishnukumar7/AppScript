package com.android.vishnu.apps.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserFile{

    @Insert
    fun insert(userDetail: UserDetail)

    @Query("select * from user")
    fun getAllUser() : List<UserDetail>


    @Query("select * from user")
    fun getAllUserLiveData() : LiveData<List<UserDetail>>

}