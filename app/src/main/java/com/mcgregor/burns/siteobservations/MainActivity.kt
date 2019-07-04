package com.mcgregor.burns.siteobservations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import kotlinx.android.synthetic.main.observation_layout.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.observation_layout)

        val tradeAdapter = ArrayAdapter(applicationContext,R.layout.spinner_list, trades)
        val conditionsAdapter = ArrayAdapter(applicationContext,R.layout.spinner_list, conditions)
        val severityAdapter = ArrayAdapter(this,R.layout.spinner_list, Severity.values())
        val issuesAdapter = ArrayAdapter(this,R.layout.spinner_list, issues)
        val contractorsAdapter = ArrayAdapter(this,R.layout.spinner_list, contractors)
        trade_spinner.adapter = tradeAdapter
        condition_spinner.adapter = conditionsAdapter
        severity_spinner.adapter = severityAdapter
        issue_spinner.adapter = issuesAdapter
        contractor_spinner.adapter = contractorsAdapter

    }
}
