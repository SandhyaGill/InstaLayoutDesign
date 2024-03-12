package com.sandhyagill.instalayoutdesign.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.sandhyagill.instalayoutdesign.R
import com.sandhyagill.instalayoutdesign.modules.ProfilePost

class RecyclerProfilePostAdapter(var profilePostList: List<ProfilePost>) : RecyclerView.Adapter<RecyclerProfilePostAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var profileImage = view.findViewById<ImageView>(R.id.profileImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.profileposts,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return profilePostList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.profileImage.setImageResource(profilePostList[position].image)
    }
}