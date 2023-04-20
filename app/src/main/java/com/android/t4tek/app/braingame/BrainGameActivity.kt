package com.android.t4tek.app.braingame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.t4tek.R
import com.android.t4tek.app.braingame.login.ChangePassFragment
import com.android.t4tek.app.braingame.login.LoginFragment
import com.android.t4tek.app.braingame.signup.SignUpFragment
import com.android.t4tek.app.braingame.start.StartFragment

class BrainGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brain_game)
        val frmHome = StartFragment()
        supportFragmentManager.beginTransaction().replace(R.id.frm,frmHome).commit()
    }
}