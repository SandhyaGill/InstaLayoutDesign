package com.sandhyagill.instalayoutdesign.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sandhyagill.instalayoutdesign.R
import com.sandhyagill.instalayoutdesign.modules.Stories

class RecyclerStoriesAdapter(var storiesList: List<Stories>) : RecyclerView.Adapter<RecyclerStoriesAdapter.ViewHolder>() {
    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view){
        var personId = view.findViewById<TextView>(R.id.personId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_stories,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return storiesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personId.text = storiesList[position].personId

    }
}