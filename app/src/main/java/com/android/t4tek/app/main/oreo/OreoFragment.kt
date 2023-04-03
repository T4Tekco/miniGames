package com.android.t4tek.app.main.oreo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.t4tek.R
import com.android.t4tek.app.base.BaseFragment
import com.android.t4tek.app.main.pie.PieViewModel
import com.android.t4tek.databinding.FragmentOreoBinding
import com.android.t4tek.databinding.FragmentPieBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class OreoFragment : BaseFragment() {

    companion object {
        fun newInstance() = OreoFragment()
    }
    private var binding: FragmentOreoBinding? = null
    private val viewModel: OreoViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOreoBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val argInt = it.getInt(getString(R.string.nav_arg_to_oreo_int))
            val argString = it.getString(getString(R.string.nav_arg_to_oreo_string))
            Timber.i("OreoFragment arguments int: $argInt")
            Timber.i("OreoFragment sarguments string: $argString")
        }
        onclick()
    }
    private fun onclick(){
        binding?.let{
            it.btnToNougat.setOnClickListener {
                val bundle = bundleOf(
                    getString(R.string.nav_arg_to_nougat_int) to 3,
                    getString(R.string.nav_arg_to_nougat_string) to "from OreoFragment to Nougat",
                )
                findNavController().navigate(R.id.action_oreoFragment_to_nougatFragment, bundle)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        Timber.i("OreoFragment onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("OreoFragment onDestroy")
    }

}