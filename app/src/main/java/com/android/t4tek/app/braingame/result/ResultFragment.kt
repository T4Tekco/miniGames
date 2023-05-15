package com.android.t4tek.app.braingame.result

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.android.t4tek.R
import com.android.t4tek.databinding.FragmentMathGameBinding

class ResultFragment : Fragment() {
    private lateinit var correct : String
//    private var inputtext: String?=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_result, container, false)
//        inputtext=arguments?.getString("cr")
//        val output= view.findViewById<TextView>(R.id.textviewkq)
//        output.text= inputtext
        return view
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        correct = arguments?.getString("correct").toString()

        var txt = view.findViewById<TextView>(R.id.textviewkq)


        txt.text = correct

    }


}