package com.android.t4tek.app.base

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

open class BaseActivity : AppCompatActivity() {
    fun findNav(id: Int): NavController {
        val navHostFragment =
            supportFragmentManager.findFragmentById(id) as NavHostFragment?
        return navHostFragment!!.navController
    }
}