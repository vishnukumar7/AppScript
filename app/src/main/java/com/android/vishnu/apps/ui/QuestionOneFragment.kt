package com.android.vishnu.apps.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.android.vishnu.apps.R
import com.google.android.material.button.MaterialButton

class QuestionOneFragment : Fragment(), View.OnClickListener {

    private lateinit var userName: AppCompatEditText
    private lateinit var next: MaterialButton
    private lateinit var viewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.question1, container, false)
        userName = view.findViewById(R.id.userName)
        viewPager = activity!!.findViewById(R.id.viewPager)
        next = view.findViewById(R.id.next)
        next.setOnClickListener(this)
        return view

    }

    override fun onClick(view: View?) {
        if(userName.text.isNullOrEmpty() || userName.text!!.isBlank()){
            userName.error="Enter the your name";
        }
        else{
            viewPager.currentItem = 1
        }
    }


}