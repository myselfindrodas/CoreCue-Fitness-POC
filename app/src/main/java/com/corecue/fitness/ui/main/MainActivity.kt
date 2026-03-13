package com.corecue.fitness.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.corecue.fitness.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private var topInsetPx: Int = 0
    private var bottomInsetPx: Int = 0
    private var leftInsetPx: Int = 0
    private var rightInsetPx: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        applyWindowInsets()
        updateInsetDrivenPadding()
    }

    private fun applyWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            topInsetPx = bars.top
            bottomInsetPx = bars.bottom
            leftInsetPx = bars.left
            rightInsetPx = bars.right
            updateInsetDrivenPadding()
            insets
        }
    }

    private fun updateInsetDrivenPadding() {
        binding.navHostFragment.updatePadding(
            left = leftInsetPx,
            top = topInsetPx,
            right = rightInsetPx,
            bottom = bottomInsetPx
        )
    }
}
