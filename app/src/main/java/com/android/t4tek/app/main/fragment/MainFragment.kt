package com.android.t4tek.app.main.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.android.t4tek.R
import com.android.t4tek.app.main.MainActivityVM
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()

    private val actViewModel: MainActivityVM by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
//        actViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        // TODO: Use the ViewModel
        Log.i("MainActivity", "MainFragment isloading: ${actViewModel.isLoadingLiveData.value}")
        actViewModel.isLoadingLiveData.observe(this, {
            Log.i(
                "MainActivity",
                "MainFragment isLoadingLiveData: ${actViewModel.isLoadingLiveData.value}"
            )
        })
        actViewModel.isLoadingLiveData.postValue(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}