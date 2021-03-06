package com.android.vishnu.apps.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.android.vishnu.apps.AndroidUtils
import com.android.vishnu.apps.R
import com.google.android.material.button.MaterialButton

class QuestionTwoFragment : Fragment() {


    private lateinit var next: MaterialButton
    private lateinit var viewPager: ViewPager
    private lateinit var playerSelect: RadioGroup
    private lateinit var playerSelectRadio: RadioButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.question2,container,false)
        next=view.findViewById(R.id.next)
        viewPager=activity!!.findViewById(R.id.viewPager)
        playerSelect=view.findViewById(R.id.selectPlayer)
        next.setOnClickListener {
            val selectId=playerSelect.checkedRadioButtonId
           if(selectId!=-1){
               playerSelectRadio=view.findViewById(selectId)
               AndroidUtils.setString(requireContext(),AndroidUtils.BEST_CRICKETER,playerSelectRadio.text.toString())
               viewPager.currentItem=2
           }
            else{
               Toast.makeText(requireContext(),"Select any one option",Toast.LENGTH_SHORT).show()
           }


        }
        return view;
    }

}