package com.android.vishnu.apps

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

class TestComplete : AppCompatActivity() {

    private lateinit var finishButton: MaterialButton
    private lateinit var historyButton: MaterialButton
    private lateinit var userName: MaterialTextView
    private lateinit var answerBest: MaterialTextView
    private lateinit var answerColor: MaterialTextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_complete)

        finishButton=findViewById(R.id.finish)
        historyButton=findViewById(R.id.history)
        userName=findViewById(R.id.userName)
        answerBest=findViewById(R.id.answer1)
        answerColor=findViewById(R.id.answer2)
        userName.text="Hello "+AndroidUtils.getString(this,AndroidUtils.USER_NAME)
        answerBest.text="Answer "+AndroidUtils.getString(this,AndroidUtils.BEST_CRICKETER)
        answerColor.text="Answer "+AndroidUtils.getString(this,AndroidUtils.NATION_FLAG_COLOR)
        finishButton.setOnClickListener {
            val intent=Intent(this@TestComplete,MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }
        historyButton.setOnClickListener { startActivity(Intent(this@TestComplete,HistoryActivity::class.java)) }
    }
}