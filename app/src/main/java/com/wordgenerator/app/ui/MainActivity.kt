package com.wordgenerator.app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.wordgenerator.app.R
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // init database
        Paper.init(applicationContext)

        // connect bottom navigation with navigation controller for this flow
        val navController = Navigation.findNavController(this, R.id.tabsNavigationHostFragment)
        bottomNavigation.setupWithNavController(navController)
    }
}