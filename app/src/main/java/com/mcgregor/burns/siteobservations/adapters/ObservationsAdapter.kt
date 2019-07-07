package com.mcgregor.burns.siteobservations.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mcgregor.burns.siteobservations.R
import entities.Observation

class ObservationsAdapter(observations:List<Observation>): RecyclerView.Adapter<ObservationsAdapter.MyViewHolder>() {

    private lateinit var _observations: List<Observation>

    init {
        _observations = observations
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.observation_item_view, parent,false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return _observations.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.firstText.text = _observations.get(position).subContractor
        holder.secondText.text = _observations.get(position).issue
    }

    inner class MyViewHolder(v: View): RecyclerView.ViewHolder(v)
    {

        lateinit var firstText:TextView
        lateinit var secondText:TextView
        init {
            firstText = v.findViewById(R.id.contractor)
            secondText = v.findViewById(R.id.issue)
        }
    }

}