package com.android.t4tek.app.braingame

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.android.t4tek.R
import com.android.t4tek.app.base.BaseActivity
import com.android.t4tek.databinding.ActivityBrainGameBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BrainGameActivity : BaseActivity() {

    private var binding : ActivityBrainGameBinding? = null
    private lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //supportActionBar?.hide()
        binding = ActivityBrainGameBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        navController = findNav(R.id.navHostFragmentBrain)

        setSupportActionBar(binding?.toolbar)
        supportActionBar?.hide()
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()  || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("EXIT")
            .setMessage("Do you want to exit ?")
            .setCancelable(true)
            .setPositiveButton("Yes") { _, _ -> finish() }
            .setNegativeButton("No", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })
            .show()
    }
}