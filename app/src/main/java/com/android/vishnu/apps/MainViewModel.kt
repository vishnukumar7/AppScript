package com.android.vishnu.apps

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData


class MainViewModel(application: Application) : AndroidViewModel(application) {
   private var userDetailLiveData: LiveData<List<UserDetail>>

    init {
        val useFileDao= AppDatabases.getDatabase(application)!!.userFile()
        userDetailLiveData=useFileDao.getAllUserLiveData()

        //applicationLiveData = LiveDataReport.applicationLiveData
    }

    fun getUSerDetailLiveData() : LiveData<List<UserDetail>>{
        return userDetailLiveData;
    }
}