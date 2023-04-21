package com.android.t4tek.app.braingame.mathgame

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.android.t4tek.R
import com.android.t4tek.databinding.FragmentMathGameBinding
import org.json.JSONObject

class MathGameFragment : Fragment() {
    private var binding: FragmentMathGameBinding? = null

    private lateinit var countDownTimer: CountDownTimer
    private var timeLeftInMillis: Long = 60000 // 1 minute
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMathGameBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSpinner()
        onClick()
        startCountDown()
    }

    private fun startCountDown() {
        countDownTimer = object : CountDownTimer(timeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished
                updateCountDownText()
            }
            override fun onFinish() {
                // Do something when the countdown finishes
            }
        }.start()
    }

    private fun updateCountDownText() {
        val minutes = (timeLeftInMillis / 1000) / 60
        val seconds = (timeLeftInMillis / 1000) % 60

        val timeLeftFormatted = String.format("%02d:%02d", minutes, seconds)
        binding?.btnTimer?.text = timeLeftFormatted
    }

    private fun onClick() {
     binding?.let {

         it.btns1.setOnClickListener{
             val pt = binding?.txtkq?.text.toString() + "1"
             binding?.txtkq?.text = pt
         }

         it.btns2.setOnClickListener{
             val pt = binding?.txtkq?.text.toString() + "2"
             binding?.txtkq?.text = pt
         }

         it.btnNumber3.setOnClickListener{
             val pt = binding?.txtkq?.text.toString() + "3"
             binding?.txtkq?.text = pt
         }

         it.btnNumber4.setOnClickListener{
             val pt = binding?.txtkq?.text.toString() + "4"
             binding?.txtkq?.text = pt
         }
         it.btns5.setOnClickListener{
             val pt = binding?.txtkq?.text.toString() + "5"
             binding?.txtkq?.setText(pt)
         }
         it.btns6.setOnClickListener{
             val pt = binding?.txtkq?.text.toString() + "6"
             binding?.txtkq?.setText(pt)
         }

         it.btns7.setOnClickListener{
             val pt = binding?.txtkq?.text.toString() + "7"
             binding?.txtkq?.text = pt
         }
         it.btns8.setOnClickListener{
             val pt = binding?.txtkq?.text.toString() + "8"
             binding?.txtkq?.setText(pt)
         }
         it.btns9.setOnClickListener{
             val pt = binding?.txtkq?.text.toString() + "9"
             binding?.txtkq?.setText(pt)
         }
         it.btns0.setOnClickListener{
             val pt = binding?.txtkq?.text.toString() + "0"
             binding?.txtkq?.setText(pt)
         }
         it.btnDel.setOnClickListener {
             binding?.txtkq?.setText(null)
         }
     }
    }

    private fun setSpinner() {
        val list = resources.getStringArray(R.array.number)
        ArrayAdapter.createFromResource(requireContext(), R.array.number, android.R.layout.simple_spinner_item)
            .also {adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding?.spinner?.adapter=adapter
        }
        binding?.spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?,
                                        p1: View?,
                                        p2: Int,
                                        p3: Long) {
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }



}