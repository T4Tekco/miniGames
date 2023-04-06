package com.android.t4tek.app.braingame.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.android.t4tek.R
import com.android.t4tek.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var binding : FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        val view = binding!!.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupTypeGame()
    }

    private fun setupTypeGame() {
        val list = mutableListOf<String>()
        list.add("Test Your Memory")
        list.add("Test Your Reflex")

//        val adapter = ArrayAdapter(requireContext(),R.layout.fragment_home,list)
//        binding?.spType?.adapter = adapter
//        val list = resources.getStringArray(R.array.game_type)

        val adapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,list)
        binding?.spType?.adapter = adapter

        binding?.spType?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(context,""+ list[position],Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}