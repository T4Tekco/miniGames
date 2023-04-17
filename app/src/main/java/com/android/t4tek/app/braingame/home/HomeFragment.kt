package com.android.t4tek.app.braingame.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.android.t4tek.R
import com.android.t4tek.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import org.w3c.dom.Node

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupTypeGame()
        onClick()
    }

    private fun setupTypeGame() {
        val list = ArrayList<String>()
        list.add("Test Your Memory")
        list.add("Test Your Reflex")
        val adapterArray = ArrayAdapter(requireContext(), R.layout.item_dropdown_gametype, list)
        binding.ddmGameType.setAdapter(adapterArray)

        binding.ddmGameType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(context, "" + list[position], Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

    private fun onClick(){
        binding.let {
            it.btnSetting.setOnClickListener {
                Toast.makeText(context,"Setting",Toast.LENGTH_SHORT).show()
            }
            it.btnNormal.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_listGameFragment)
            }
            it.btnChallenge.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_listGameFragment)
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}