package com.android.vishnu.apps

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.vishnu.apps.db.AppDatabases

class HistoryActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var mainViewModel: MainViewModel
    private lateinit var historyAdapter: HistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history_activity)
        val useFileDao = AppDatabases.getDatabase(application)!!.userFile()
       /* if (useFileDao.getAllUser().isEmpty())
            startActivity(Intent(this@HistoryActivity, MainActivity::class.java))*/
        recyclerView = findViewById(R.id.historyRecyclerView)
        recyclerView.setHasFixedSize(false)
        recyclerView.layoutManager = LinearLayoutManager(this)
        // val historyAdapter=HistoryAdapter(user.getAllUserLiveData())

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.getUSerDetailLiveData().observe(
            this, Observer { userDetails ->
                if (userDetails != null) {
                    historyAdapter = HistoryAdapter(userDetails)
                    recyclerView.adapter = historyAdapter
                    historyAdapter.notifyDataSetChanged()
                }
            })
    }



}