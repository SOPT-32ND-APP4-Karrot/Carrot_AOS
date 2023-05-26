package com.sumin.android.carrot_aos.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.sumin.android.carrot_aos.R
import com.sumin.android.carrot_aos.databinding.ActivityHomeBinding
import com.sumin.android.carrot_aos.presentation.base.BindingActivity

class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fcv_nav_host) as NavHostFragment
        navController = navHostFragment.navController
        with(binding) {
            bnvMain.itemIconTintList = null
            binding.bnvMain.setupWithNavController(navController)
        }
    }
}