package com.corecue.fitness.ui.main

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.corecue.fitness.R
import com.corecue.fitness.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private var topInsetPx: Int = 0
    private var bottomInsetPx: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        applyWindowInsets()

        val navHost = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHost.navController
        binding.bottomNav.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val showBottomNav = when (destination.id) {
                R.id.homeFragment, R.id.historyFragment, R.id.profileFragment -> android.view.View.VISIBLE
                else -> android.view.View.GONE
            }
            binding.bottomNav.visibility = showBottomNav
            updateInsetDrivenPadding(showBottomNav == View.VISIBLE)
        }
    }

    private fun applyWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            topInsetPx = bars.top
            bottomInsetPx = bars.bottom
            updateInsetDrivenPadding(binding.bottomNav.visibility == View.VISIBLE)
            insets
        }
    }

    private fun updateInsetDrivenPadding(showBottomNav: Boolean) {
        binding.navHostFragment.updatePadding(
            top = topInsetPx,
            bottom = if (showBottomNav) 0 else bottomInsetPx
        )
        binding.bottomNav.updatePadding(bottom = bottomInsetPx)
    }
}
