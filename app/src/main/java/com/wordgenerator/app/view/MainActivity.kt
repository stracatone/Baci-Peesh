package com.wordgenerator.app.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.wordgenerator.app.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // connect bottom navigation with navigation controller for this flow
        val navController = Navigation.findNavController(this, R.id.tabsNavigationHostFragment)
        bottomNavigation.setupWithNavController(navController)
    }
}