package com.mcgregor.burns.siteobservations


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
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
        observationViewModel.observations.observe(this, Observer { c ->
            c.let {
                if (c.isNotEmpty()) {
                    observations = c
                }
            }
        })

    }

    private fun setUpButtons() {

        save_button.setOnClickListener { _ ->
            if (checkFields()) {
                var obs = Observation().apply {
                    trade = trade_spinner.selectedItem.toString()
                    subContractor = contractor_spinner.selectedItem.toString()
                    issue = issue_spinner.selectedItem.toString()
                    severity = severity_spinner.selectedItem.toString()
                    condition = condition_spinner.selectedItem.toString()
                    actionTaken = actionTaken_editText.text.toString()
                }

                observationViewModel.insert(obs)
            }
        }
        save_new_button.setOnClickListener { _ ->

            if (checkFields()) {
                var obs = Observation().apply {
                    trade = trade_spinner.selectedItem.toString()
                    subContractor = contractor_spinner.selectedItem.toString()
                    issue = issue_spinner.selectedItem.toString()
                    severity = severity_spinner.selectedItem.toString()
                    condition = condition_spinner.selectedItem.toString()
                    actionTaken = actionTaken_editText.text.toString()
                }

                observationViewModel.insert(obs)

                clearFields()
            }
        }

        cancel_button.setOnClickListener { _ ->
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

        val tradeAdapter = ArrayAdapter(context!!, R.layout.spinner_list, trades.sorted())
        val conditionsAdapter = ArrayAdapter(context!!, R.layout.spinner_list, conditions)
        val severityAdapter = ArrayAdapter(context!!, R.layout.spinner_list, Severity.values())
        val issuesAdapter = ArrayAdapter(context!!, R.layout.spinner_list, issues)
        val contractorsAdapter = ArrayAdapter(context!!, R.layout.spinner_list, contractors.sorted())
        trade_spinner.adapter = tradeAdapter
        condition_spinner.adapter = conditionsAdapter
        severity_spinner.adapter = severityAdapter
        issue_spinner.adapter = issuesAdapter
        contractor_spinner.adapter = contractorsAdapter
    }

    //  function to check for empty text
    private fun checkFields(): Boolean {
        if (trade_spinner.selectedItem == ""){
            trade_text.setTextColor(resources.getColor(R.color.errorColor, resources.newTheme()))
            return false
        }
        else{
            trade_text.setTextColor(resources.getColor(R.color.primary_material_dark, resources.newTheme()))
        }
        if (contractor_spinner.selectedItem == ""){
            contractor_text.setTextColor(resources.getColor(R.color.errorColor, resources.newTheme()))
            return false
        }
        else{
            contractor_text.setTextColor(resources.getColor(R.color.primary_material_dark, resources.newTheme()))
        }
        if (issue_spinner.selectedItem == ""){
            issue_text.setTextColor(resources.getColor(R.color.errorColor, resources.newTheme()))
            return false
        }
        else{
            issue_text.setTextColor(resources.getColor(R.color.primary_material_dark, resources.newTheme()))
        }
        if (condition_spinner.selectedItem == ""){
            condition_text.setTextColor(resources.getColor(R.color.errorColor, resources.newTheme()))
            return false
        }
        else{
            condition_text.setTextColor(resources.getColor(R.color.primary_material_dark, resources.newTheme()))
        }
        if (actionTaken_editText.text.toString() == ""){
            action_text.setTextColor(resources.getColor(R.color.errorColor, resources.newTheme()))
            return false
        }
        else{
            action_text.setTextColor(resources.getColor(R.color.primary_material_dark, resources.newTheme()))
        }
        return true
    }

}
