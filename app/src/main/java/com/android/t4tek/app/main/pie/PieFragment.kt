package com.android.t4tek.app.main.pie

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
import com.android.t4tek.app.main.MainActivityVM
import com.android.t4tek.app.main.fragment.MainViewModel
import com.android.t4tek.app.utils.Status
import com.android.t4tek.databinding.ActivityMainBinding
import com.android.t4tek.databinding.FragmentPieBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject
import kotlin.random.Random

@AndroidEntryPoint
class PieFragment : BaseFragment() {
    private val TAG = "PieFragment"
    companion object {
        fun newInstance() = PieFragment()
    }

    private var binding: FragmentPieBinding? = null
    private val viewModel: PieViewModel by viewModels()
    private val actViewModel: MainActivityVM by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPieBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        obServe()
        arguments?.let {
            val argInt = it.getInt(getString(R.string.nav_arg_to_pie_int))
            val argString = it.getString(getString(R.string.nav_arg_to_pie_string))
            Timber.i("arguments int: $argInt")
            Timber.i("arguments string: $argString")
        }
        onclick()
    }

    private fun obServe() {
        viewModel.personLoader.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    binding?.loading?.visibility = View.GONE
                    val data = it.data.toString()
                    binding?.tvData?.text = data
                    Timber.tag(TAG).i(data)
                }
                Status.ERROR -> {
                    binding?.tvData?.text = it.message
                    binding?.loading?.visibility = View.GONE
                }
                Status.LOADING -> {
                    Timber.tag(TAG).i("loading")
                    binding?.tvData?.text = ""
                    binding?.loading?.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun onclick() {
        binding?.let {
            it.btnFetchApi.setOnClickListener {
                viewModel.fetchPerson()
            }
            it.btnToOreo.setOnClickListener {
                val bundle = bundleOf(
                    getString(R.string.nav_arg_to_oreo_int) to 1,
                    getString(R.string.nav_arg_to_oreo_string) to "from PieFragment to Oreo",
                )
                findNavController().navigate(R.id.action_pieFragment_to_oreoFragment, bundle)
            }
            it.btnToNougat.setOnClickListener {
                val bundle = bundleOf(
                    getString(R.string.nav_arg_to_nougat_int) to 2,
                    getString(R.string.nav_arg_to_nougat_string) to "from PieFragment to Nougat",
                )
                findNavController().navigate(R.id.action_pieFragment_to_homeFragment, bundle)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("PieFragment onCreate")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("PieFragment onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("PieFragment onDestroy")
    }
}