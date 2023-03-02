package com.example.chatappkot

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chatappkot.model.User

class UserAdapter(val context : Context,val userList : ArrayList<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.id.userlayout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentUser=userList[position]
        holder.textName.text=currentUser.name
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val textName= itemView.findViewById<TextView>(R.id.nametext)

    }

}