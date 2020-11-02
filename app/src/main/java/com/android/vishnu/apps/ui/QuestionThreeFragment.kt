package com.android.vishnu.apps.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.android.vishnu.apps.AndroidUtils
import com.android.vishnu.apps.R
import com.android.vishnu.apps.TestComplete
import com.android.vishnu.apps.db.AppDatabases
import com.android.vishnu.apps.db.UserDetail
import com.google.android.material.button.MaterialButton
import com.google.android.material.checkbox.MaterialCheckBox
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class QuestionThreeFragment :Fragment(){

    private lateinit var next: MaterialButton
    private lateinit var viewPager: ViewPager
    private lateinit var colorWhite: MaterialCheckBox
    private lateinit var colorRed: MaterialCheckBox
    private lateinit var colorOrange: MaterialCheckBox
    private lateinit var colorYellow: MaterialCheckBox
    private lateinit var colorBlue: MaterialCheckBox
    private lateinit var colorViolet: MaterialCheckBox
    private lateinit var colorGreen: MaterialCheckBox


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.question3,container,false)
        next=view.findViewById(R.id.next)
        viewPager=activity!!.findViewById(R.id.viewPager)
        colorWhite=view.findViewById(R.id.white)
        colorRed=view.findViewById(R.id.red)
        colorOrange=view.findViewById(R.id.orange)
        colorYellow=view.findViewById(R.id.yellow)
        colorBlue=view.findViewById(R.id.blue)
        colorViolet=view.findViewById(R.id.violet)
        colorGreen=view.findViewById(R.id.green)

        next.setOnClickListener {
            var result = StringBuffer()
            result=getString(colorBlue,result)
            result=getString(colorGreen,result)
            result=getString(colorWhite,result)
            result=getString(colorRed,result)
            result=getString(colorYellow,result)
            result=getString(colorViolet,result)
            result=getString(colorOrange,result)
            if(result.toString().isNullOrEmpty()){
                Toast.makeText(requireContext(),"You can select more than one option", Toast.LENGTH_SHORT).show()
            }
            else{
                AndroidUtils.setString(requireContext(),AndroidUtils.NATION_FLAG_COLOR,result.toString())
                val userFile=AppDatabases.getDatabase(requireContext())!!.userFile()
                val userDetail=UserDetail()
                userDetail.bestCricket= AndroidUtils.getString(requireContext(),AndroidUtils.BEST_CRICKETER)!!
                userDetail.colors= AndroidUtils.getString(requireContext(),AndroidUtils.NATION_FLAG_COLOR)!!
                userDetail.userName= AndroidUtils.getString(requireContext(),AndroidUtils.USER_NAME)!!

                val originalFormat: DateFormat = SimpleDateFormat("dd MMMM hh:mm a", Locale.ENGLISH)

                userDetail.timeDate=originalFormat.format(System.currentTimeMillis())
                userFile.insert(userDetail)
                requireContext().startActivity(Intent(requireContext(),TestComplete::class.java))
            }


        }
        return view;
    }

    fun getString(checkBox: MaterialCheckBox,result: StringBuffer): StringBuffer{
        if(checkBox.isChecked){
            if(result.toString().isNotEmpty()){
                result.append(",").append(checkBox.text.toString())
            }
            else
                result.append(checkBox.text.toString())
        }
        return result
    }


}