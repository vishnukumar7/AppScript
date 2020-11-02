package com.android.vishnu.apps
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.vishnu.apps.UserFile


@Database(entities = [UserDetail::class], version = 3, exportSchema = false)
abstract class RoomDatabases : androidx.room.RoomDatabase() {
    abstract fun userFile(): UserFile

    companion object {
        @Volatile
        private var INSTANCE: RoomDatabase? = null
        fun getDatabase(context: Context): RoomDatabase? {
            if (INSTANCE == null) {
                synchronized(RoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                                RoomDatabase::class.java, "appscript")
                                .allowMainThreadQueries()
                                .fallbackToDestructiveMigration()
                                .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}