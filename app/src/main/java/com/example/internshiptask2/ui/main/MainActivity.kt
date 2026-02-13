package com.example.internshiptask2.ui.main

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.internshiptask2.R
import com.example.internshiptask2.ui.guides.GuidesFragment
import com.example.internshiptask2.ui.profile.ProfileFragment
import com.example.internshiptask2.ui.home.HomeFragment
import com.example.internshiptask2.ui.settings.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView
    private lateinit var topBarTitle: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottom_navigation)
        topBarTitle = findViewById(R.id.top_bar_title)


        if (savedInstanceState == null) {
            openFragment(HomeFragment(), "Home")
        }

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    openFragment(HomeFragment(), "Home")
                    true
                }

                R.id.nav_guides -> {
                    openFragment(GuidesFragment(), "Guides")
                    true
                }

                R.id.nav_profile -> {
                    openFragment(ProfileFragment(), "Profile")
                    true
                }

                R.id.nav_setting -> {
                    openFragment(SettingFragment(), "Setting")
                    true
                }

                else -> false
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun openFragment(fragment: Fragment, title: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
        topBarTitle.text = title
    }
}