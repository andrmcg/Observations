package com.mcgregor.burns.siteobservations


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.mcgregor.burns.siteobservations.data.ObservationViewModel
import entities.Observation
import kotlinx.android.synthetic.main.observation_layout.*


class ObservationFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var observationViewModel: ObservationViewModel
    private lateinit var observations: List<Observation>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.observation_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        navController = findNavController()

        populateControls()
        setUpButtons()

        observationViewModel = ViewModelProviders.of(this).get(ObservationViewModel::class.java)
        observationViewModel?.observations?.observe(this, Observer { c ->
            c.let {
                if (c.isNotEmpty()) {
                    observations = c
                }
            }
        })

    }

    private fun setUpButtons() {

        save_button.setOnClickListener { v ->
            var obs = Observation().apply {
                trade = trade_spinner.selectedItem.toString()
                subContractor = contractor_spinner.selectedItem.toString()
                issue = issue_spinner.selectedItem.toString()
                severity = severity_spinner.selectedItem.toString()
                condition = condition_spinner.selectedItem.toString()
                actionTaken = actionTaken_editText.text.toString()
            }

            observationViewModel?.insert(obs)
        }
        save_new_button.setOnClickListener { v ->

            var obs = Observation().apply {
                trade = trade_spinner.selectedItem.toString()
                subContractor = contractor_spinner.selectedItem.toString()
                issue = issue_spinner.selectedItem.toString()
                severity = severity_spinner.selectedItem.toString()
                condition = condition_spinner.selectedItem.toString()
                actionTaken = actionTaken_editText.text.toString()
            }

            observationViewModel?.insert(obs)

            clearFields()
        }
        cancel_button.setOnClickListener { v ->
            clearFields()
        }

    }

    private fun clearFields() {
        trade_spinner.setSelection(0, true)
        condition_spinner.setSelection(0, true)
        issue_spinner.setSelection(0, true)
        contractor_spinner.setSelection(0, true)
        actionTaken_editText.text.clear()
    }

    private fun populateControls() {

        val tradeAdapter = ArrayAdapter(context, R.layout.spinner_list, trades)
        val conditionsAdapter = ArrayAdapter(context, R.layout.spinner_list, conditions)
        val severityAdapter = ArrayAdapter(context, R.layout.spinner_list, Severity.values())
        val issuesAdapter = ArrayAdapter(context, R.layout.spinner_list, issues)
        val contractorsAdapter = ArrayAdapter(context, R.layout.spinner_list, contractors)
        trade_spinner.adapter = tradeAdapter
        condition_spinner.adapter = conditionsAdapter
        severity_spinner.adapter = severityAdapter
        issue_spinner.adapter = issuesAdapter
        contractor_spinner.adapter = contractorsAdapter
    }


}
