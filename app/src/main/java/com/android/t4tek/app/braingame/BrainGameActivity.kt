package com.android.t4tek.app.braingame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.t4tek.R
import com.android.t4tek.app.braingame.home.HomeFragment
import com.android.t4tek.app.braingame.list_game.ListGameFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BrainGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brain_game)

        val frmHome = ListGameFragment()

        supportFragmentManager.beginTransaction().replace(R.id.frm,frmHome).commit()
    }
}