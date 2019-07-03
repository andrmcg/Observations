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

        val adapter = ArrayAdapter(applicationContext,0,trades)
        trade_spinner.adapter = adapter

    }
}
