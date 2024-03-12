package com.sandhyagill.instalayoutdesign.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.sandhyagill.instalayoutdesign.R
import com.sandhyagill.instalayoutdesign.modules.HighLights

class RecyclerHighLightsAdapter(var highLightsList: List<HighLights>) : RecyclerView.Adapter<RecyclerHighLightsAdapter.ViewHolder>() {
    class ViewHolder(var view: View):RecyclerView.ViewHolder(view){
        var personId = view.findViewById<TextView>(R.id.personId)
        var image = view.findViewById<ShapeableImageView>(R.id.ivImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.highlights,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
     return highLightsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personId.text = highLightsList[position].personId
        holder.image.setImageResource(highLightsList[position].image)
    }
}