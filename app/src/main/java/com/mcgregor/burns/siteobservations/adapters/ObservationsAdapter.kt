package com.mcgregor.burns.siteobservations.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mcgregor.burns.siteobservations.R
import entities.Observation

class ObservationsAdapter(observations:List<Observation>): RecyclerView.Adapter<ObservationsAdapter.MyViewHolder>() {

    private var _observations: List<Observation>

    private lateinit var mClickListener: View.OnLongClickListener

    init {
        _observations = observations

    }

    public fun setOnLongItemClickListener(itemClickListener: View.OnLongClickListener)
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
        holder.contractorText.text = _observations.get(position).subContractor
        holder.issueText.text = _observations.get(position).issue
        holder.conditionText.text = _observations.get(position).condition
        holder.severityText.text = _observations.get(position).severity
        holder.actionText.text = _observations.get(position).actionTaken

    }


    inner class MyViewHolder(v: View): RecyclerView.ViewHolder(v)
    {

        var contractorText:TextView
        var issueText:TextView
        var conditionText: TextView
        var severityText: TextView
        var actionText: TextView

        init {
            contractorText = v.findViewById(R.id.contractorText)
            issueText = v.findViewById(R.id.issueText)
            conditionText = v.findViewById(R.id.conditionText)
            severityText = v.findViewById(R.id.severityText)
            actionText = v.findViewById(R.id.actionText)

            v.tag = this
            v.setOnLongClickListener(mClickListener)
        }

    }

}