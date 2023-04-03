package com.android.t4tek.app.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.android.t4tek.R
import com.android.t4tek.app.base.BaseActivity
import com.android.t4tek.databinding.ActivityMainBinding
import com.android.utils.NetworkHelper
import com.android.utils.SharedPrefsUtils
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private val viewModel: MainActivityVM by viewModels()

    @Inject
    lateinit var shared: SharedPrefsUtils
    private var binding: ActivityMainBinding? = null

    @Inject
    lateinit var networkHelper: NetworkHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, MainFragment.newInstance())
//                .commitNow()
//        }
        Timber.tag("android1912").i(networkHelper.isNetworkConnected().toString())
        findNav(R.id.navHostFragment)
        viewModel.loadUser()
    }
}