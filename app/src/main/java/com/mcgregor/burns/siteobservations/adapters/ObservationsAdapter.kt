package com.mcgregor.burns.siteobservations.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.mcgregor.burns.siteobservations.R
import entities.Observation

class ObservationsAdapter(observations:List<Observation>): RecyclerView.Adapter<ObservationsAdapter.MyViewHolder>() {

    private var _observations: List<Observation> = observations

    private lateinit var mClickListener: View.OnLongClickListener

    fun setOnLongItemClickListener(itemClickListener: View.OnLongClickListener)
    {
        mClickListener = itemClickListener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.observation_item_view, parent,false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return _observations.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.contractorText.text = _observations[position].subContractor
        holder.issueText.text = _observations[position].issue
        holder.conditionText.text = _observations[position].condition
        holder.severityText.text = _observations[position].severity
        holder.actionText.text = _observations[position].actionTaken

    }


    inner class MyViewHolder(v: View): RecyclerView.ViewHolder(v)
    {

        var contractorText:TextView = v.findViewById(R.id.contractorText)
        var issueText:TextView
        var conditionText: TextView
        var severityText: TextView
        //var actionText: TextView
        var actionText: MaterialTextView

        init {
            issueText = v.findViewById(R.id.issueText)
            conditionText = v.findViewById(R.id.conditionText)
            severityText = v.findViewById(R.id.severityText)
            actionText = v.findViewById(R.id.actionText)

            v.tag = this
            v.setOnLongClickListener(mClickListener)
        }

    }

}