package com.sandhyagill.instalayoutdesign.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sandhyagill.instalayoutdesign.R
import com.sandhyagill.instalayoutdesign.modules.Posts

class RecyclerPostAdapter(var postList: List<Posts>) : RecyclerView.Adapter<RecyclerPostAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val ivImage= view.findViewById<ImageView>(R.id.ivImage)
        val personId = view.findViewById<TextView>(R.id.personId)
        val ivPost = view.findViewById<ImageView>(R.id.ivPost)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_post,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ivImage.setImageResource(postList[position].profileImage)
        holder.personId.text = (postList[position].personId)
        holder.ivPost.setImageResource(postList[position].post)
    }
}