package com.example.petsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.petsapp.R
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)




        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val drawLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.homepage_fragment,R.id.Login))
        setupActionBarWithNavController(navController, appBarConfiguration)

        findViewById<NavigationView>(R.id.nav_view).setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return  navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}