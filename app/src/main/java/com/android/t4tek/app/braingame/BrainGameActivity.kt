package com.android.t4tek.app.braingame


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.t4tek.R
import com.android.t4tek.app.braingame.mathgame.MathGameFragment

class BrainGameActivity : AppCompatActivity() {
    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brain_game)
        val frmHome = MathGameFragment()
        supportFragmentManager.beginTransaction().replace(R.id.frm,frmHome).commit()
    }
}