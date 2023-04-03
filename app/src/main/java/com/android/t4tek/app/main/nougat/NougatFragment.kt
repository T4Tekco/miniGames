package com.android.t4tek.app.main.nougat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.t4tek.R
import com.android.t4tek.app.base.BaseFragment
import com.android.t4tek.databinding.FragmentNougatBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class NougatFragment : BaseFragment() {

    companion object {
        fun newInstance() = NougatFragment()
    }
    private var binding: FragmentNougatBinding? = null
    private val viewModel: NougatViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNougatBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val argInt = it.getInt(getString(R.string.nav_arg_to_nougat_int))
            val argString = it.getString(getString(R.string.nav_arg_to_nougat_string))
            Timber.i("OreoFragment arguments int: $argInt")
            Timber.i("OreoFragment sarguments string: $argString")
        }
        onclick()
    }
    private fun onclick(){
        binding?.let{
            it.btnToPie.setOnClickListener {
//                clear all fragment stack by flag: POP_BACK_STACK_INCLUSIVE
                parentFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)

                val bundle = bundleOf(
                    getString(R.string.nav_arg_to_pie_int) to 4,
                    getString(R.string.nav_arg_to_pie_string) to "from NougatFragment to PIE",
                )

                findNavController().navigate(R.id.action_nougatFragment_to_pieFragment, bundle)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        Timber.i("NougatFragment onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("NougatFragment onDestroy")
    }

}