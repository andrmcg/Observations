package com.mcgregor.burns.siteobservations


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mcgregor.burns.siteobservations.adapters.ObservationsAdapter
import com.mcgregor.burns.siteobservations.data.ObservationViewModel
import entities.Observation
import kotlinx.android.synthetic.main.fragment_display_observations.*


/**
 * A simple [Fragment] subclass.
 *
 */
class DisplayObservationsFragment : Fragment(), View.OnLongClickListener {


    private lateinit var navController: NavController
    private lateinit var observationViewModel: ObservationViewModel
    private lateinit var observations: List<Observation>
    private lateinit var observationAdapter: ObservationsAdapter
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display_observations, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        navController = findNavController()

        observationViewModel = ViewModelProviders.of(this).get(ObservationViewModel::class.java)
        observationViewModel.observations.observe(this, Observer { c ->
            c.let {
                if (c.isNotEmpty()) {
                    observations = c
                    observationAdapter = ObservationsAdapter(observations)
                    observations_list.layoutManager = LinearLayoutManager(this.context)
                    observations_list.adapter = observationAdapter
                    observationAdapter.setOnLongItemClickListener(this)
                }
                else {
                    observationAdapter = ObservationsAdapter(c)
                    observations_list.layoutManager = LinearLayoutManager(this.context)
                    observations_list.adapter = observationAdapter
                }
            }
        })


    }

    override fun onLongClick(v: View?): Boolean {
        var viewHolder = v?.tag as RecyclerView.ViewHolder
        if (observations.isNotEmpty()) {
            val position = viewHolder.adapterPosition
            observationViewModel.delete(observations.get(position))
            observationAdapter.notifyItemRemoved(position)
            return true
        }
        else return false
    }


}
