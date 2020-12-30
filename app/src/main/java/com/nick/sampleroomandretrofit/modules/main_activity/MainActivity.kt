package com.nick.sampleroomandretrofit.modules.main_activity

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.nick.sampleroomandretrofit.R
import com.nick.sampleroomandretrofit.databinding.ActivityMainBinding
import com.nick.sampleroomandretrofit.utils.base_classes.BaseActivity

class MainActivity : BaseActivity() {

    private lateinit var navController: NavController
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        initNavigationToFragment()
    }

    private fun initNavigationToFragment() {
        navController = Navigation.findNavController(this, R.id.fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null)
    }
}