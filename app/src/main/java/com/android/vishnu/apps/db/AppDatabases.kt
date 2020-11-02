package com.android.vishnu.apps.db
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [UserDetail::class], version = 1, exportSchema = false)
abstract class AppDatabases : RoomDatabase() {
    abstract fun userFile(): UserFile

    companion object {

        var INSTANCE: AppDatabases? = null
        fun getDatabase(context: Context): AppDatabases? {
            if (INSTANCE == null) {
                synchronized(AppDatabases::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabases::class.java, "appscript"
                    )
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}
