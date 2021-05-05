package com.znggis.sampleservicebookingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.root_navigation_container)
        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.homeFragment
        ).build()

      //  setupActionBarWithNavController(navController, appBarConfiguration)

    }
}