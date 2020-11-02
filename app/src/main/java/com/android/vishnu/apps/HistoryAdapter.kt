package com.android.vishnu.apps

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.vishnu.apps.databinding.ListHistoryBinding
import com.android.vishnu.apps.db.UserDetail


class HistoryAdapter(userDetail: List<UserDetail>) : RecyclerView.Adapter<HistoryAdapter.CustomViewHolder>() {

    private var userDetailList: List<UserDetail> = userDetail

    class CustomViewHolder(itemView: ListHistoryBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        var listHistoryBinding: ListHistoryBinding = itemView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val binding= DataBindingUtil.inflate<ListHistoryBinding>(
            LayoutInflater.from(parent.context),
            R.layout.list_history,
            parent,
            false
        )

        return CustomViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return userDetailList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val userDetail= userDetailList[position]
        println("//user details : "+userDetail.uid)
        println("//user details : "+userDetail.bestCricket)
        println("//user details : "+userDetail.colors)
        println("//user details : "+userDetail.userName)
        holder.listHistoryBinding.user=userDetail
    }
}

