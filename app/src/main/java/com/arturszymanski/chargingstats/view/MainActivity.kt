package com.arturszymanski.chargingstats.view

import android.view.LayoutInflater
import androidx.navigation.findNavController
import com.arturszymanski.chargingstats.R
import com.arturszymanski.chargingstats.databinding.ActivityMainBinding
import com.arturszymanski.chargingstats.view.base.BaseActivity
import dagger.android.AndroidInjection

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun createViewBinding(inflater: LayoutInflater): ActivityMainBinding =
        ActivityMainBinding.inflate(inflater)

    override fun injectDependencies() {
        AndroidInjection.inject(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.mainNavHostFragment).navigateUp()
    }
}