package com.android.vishnu.apps

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
class UserDetail {

    @PrimaryKey(autoGenerate = true)
    lateinit var uid: String

    @ColumnInfo(name = "UserName")
    lateinit var userName: String

    @ColumnInfo(name = "timeDate")
    lateinit var timeDate: String

    @ColumnInfo(name = "Best_Cricketer")
    lateinit var bestCricket: String

    @ColumnInfo(name = "colors")
    lateinit var colors: String
}
