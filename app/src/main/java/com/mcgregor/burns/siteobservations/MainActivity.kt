package com.mcgregor.burns.siteobservations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.observation_layout.*


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.nav_host_fragment)

        bottom_nav.setupWithNavController(navController)
        bottom_nav.menu.findItem(R.id.dateEntryMenuItem).setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener { item ->
            navController.navigate(R.id.observationFragment)
            true
        })

        bottom_nav.menu.findItem(R.id.dataDisplayMenuItem).setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener { item ->
            navController.navigate(R.id.observationFragment)
            true
        })

    }

    override fun onSupportNavigateUp(): Boolean = navController.navigateUp() || super.onSupportNavigateUp()

}
