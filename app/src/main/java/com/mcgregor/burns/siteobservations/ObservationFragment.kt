package com.mcgregor.burns.siteobservations


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout
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

        save_button.setOnClickListener {
            if (checkFields()) {
                val obs = Observation().apply {
                    trade = trade_text.editText?.text.toString()
                    subContractor = contractor_text.editText?.text.toString()
                    issue = issue_text.editText?.text.toString()
                    severity = severity_text.editText?.text.toString()
                    condition = condition_text.editText?.text.toString()
                    actionTaken = action_text.editText?.text.toString()
                }

                observationViewModel.insert(obs)
            }
        }

        save_new_button.setOnClickListener {
            if (checkFields()) {
                val obs = Observation().apply {
                    trade = trade_text.editText?.text.toString()
                    subContractor = contractor_text.editText?.text.toString()
                    issue = issue_text.editText?.text.toString()
                    severity = severity_text.editText?.text.toString()
                    condition = condition_text.editText?.text.toString()
                    actionTaken = action_text.editText?.text.toString()
                }

                observationViewModel.insert(obs)

                clearFields()
            }
        }

        cancel_button.setOnClickListener {
            clearFields()
        }

    }

    private fun clearFields() {
        trade_text.editText?.text?.clear()
        contractor_text.editText?.text?.clear()
        issue_text.editText?.text?.clear()
        severity_text.editText?.text?.clear()
        condition_text.editText?.text?.clear()
        action_text.editText?.text?.clear()
    }

    private fun populateControls() {

        val tradeAdapter = ArrayAdapter(context!!, R.layout.dropdown_menu_popup_item, trades)
        val conditionsAdapter = ArrayAdapter(context!!, R.layout.dropdown_menu_popup_item, conditions)
        val severityAdapter = ArrayAdapter(context!!, R.layout.dropdown_menu_popup_item, Severity.values())
        val issuesAdapter = ArrayAdapter(context!!, R.layout.dropdown_menu_popup_item, issues)
        val contractorsAdapter = ArrayAdapter(context!!, R.layout.dropdown_menu_popup_item, contractors.sorted())

        val autoTrade: AutoCompleteTextView = view!!.findViewById(R.id.trade_spinner)
        autoTrade.setAdapter(tradeAdapter)

        val autoContractor: AutoCompleteTextView = view!!.findViewById(R.id.contractor_spinner)
        autoContractor.setAdapter(contractorsAdapter)

        val autoIssue: AutoCompleteTextView = view!!.findViewById(R.id.issue_spinner)
        autoIssue.setAdapter(issuesAdapter)

        val autoCondition: AutoCompleteTextView = view!!.findViewById(R.id.condition_spinner)
        autoCondition.setAdapter(conditionsAdapter)

        val autoSeverity: AutoCompleteTextView = view!!.findViewById(R.id.severity_spinner)
        autoSeverity.setAdapter(severityAdapter)

    }

    //  function to check for empty text
    private fun checkFields(): Boolean {

        var noErrors = true
        val textInputs = listOf<TextInputLayout>(trade_text, contractor_text, issue_text, condition_text, severity_text, action_text)
        for (textInputLayout in textInputs)
        {
            if (textInputLayout.editText?.text.toString().isEmpty())
            {
                textInputLayout.error = resources.getString(R.string.error_string)
                noErrors = false
            }
            else
            {
                textInputLayout.error = null
            }
        }

        return noErrors
    }

}
