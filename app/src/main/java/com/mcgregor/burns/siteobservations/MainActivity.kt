package com.mcgregor.burns.siteobservations

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.nav_host_fragment)

        navController.addOnDestinationChangedListener(NavController.OnDestinationChangedListener{c,_,_ ->
            val destination = (c.currentDestination as FragmentNavigator.Destination).className
            when(destination){
                "com.mcgregor.burns.siteobservations.ObservationFragment" -> {
                    bottom_nav.menu.findItem(R.id.dateEntryMenuItem).isEnabled = false
                    bottom_nav.menu.findItem(R.id.dataDisplayMenuItem).isEnabled = true
                }
                "com.mcgregor.burns.siteobservations.DisplayObservationsFragment" -> {
                    bottom_nav.menu.findItem(R.id.dateEntryMenuItem).isEnabled = true
                    bottom_nav.menu.findItem(R.id.dataDisplayMenuItem).isEnabled = false
                }
            }
        })

        bottom_nav.setupWithNavController(navController)
        bottom_nav.menu.findItem(R.id.dateEntryMenuItem)
            .setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener { _ ->
                navController.navigate(R.id.observationFragment)
                true
            })

        bottom_nav.menu.findItem(R.id.dataDisplayMenuItem)
            .setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener { _ ->
                navController.navigate(R.id.displayObservationsFragment)
                true
            })

    }

    override fun onSupportNavigateUp(): Boolean = navController.navigateUp() || super.onSupportNavigateUp()

}
