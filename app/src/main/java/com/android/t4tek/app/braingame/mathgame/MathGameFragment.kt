
package com.android.t4tek.app.braingame.mathgame


import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.t4tek.R
import com.android.t4tek.databinding.FragmentMathGameBinding
import com.android.t4tek.domain.json_model.QuestionList
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.*
import java.io.IOException

class MathGameFragment : Fragment() {
    private var binding: FragmentMathGameBinding? = null
    private lateinit var countDownTimer: CountDownTimer
    private var timeLeftInMillis: Long = 60000 // 1 minute

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMathGameBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMathGameBinding.bind(view)

        var currentPosition = 0 // vị trí hiện tại của câu hỏi trong JSON
        var questionList: QuestionList? = null // danh sách câu hỏi lấy từ JSON
        val client = OkHttpClient.Builder().build()
        val request = Request.Builder()
            .url("https://api.tools.bizinfo.one/question.json")
            .build()

        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                //xử lý lỗi
            }

            override fun onResponse(call: Call, response: Response) {
                val json = response.body?.string()
                val moshi = Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()
                val adapter = moshi.adapter(QuestionList::class.java)
                val questionList = adapter.fromJson(json!!)

                // Lấy danh sách các ID của các câu hỏi
                val idList = mutableListOf<String>()
                for (question in questionList!!.questions) {
                    for (q in question.list_question) {
                        idList.add(q.id.toString())
                    }
                }
//ar kq = []

                activity?.runOnUiThread{
                   binding?.txtnumber1?.text = questionList!!.questions[0].list_question[currentPosition].number_1.toString()
                   binding?.txtOperator?.text=questionList.questions[0].list_question[currentPosition].operator
                   binding?.txtnumber2?.text =  questionList!!.questions[0].list_question[currentPosition].number_2.toString()
               }
                binding?.btnOK?.setOnClickListener {
                    currentPosition++
                // tăng vị trí hiện tại lên 1 để lấy câu hỏi tiếp theo trong JSON
                    if (currentPosition < questionList!!.questions[0].list_question.size &&
                        questionList!!.questions[0].list_question[currentPosition].id == currentPosition+1)
                        {
                        binding?.txtnumber1?.text =
                            questionList!!.questions[0].list_question[currentPosition].number_1.toString()
                        binding?.txtOperator?.text =
                            questionList!!.questions[0].list_question[currentPosition].operator
                        binding?.txtnumber2?.text =
                            questionList!!.questions[0].list_question[currentPosition].number_2.toString()
                    }
//                    // Gửi lại request để lấy JSON mới nếu đã lấy hết các câu hỏi trong JSON
                    if (currentPosition >= questionList!!.questions[0].list_question.size) {
                        currentPosition = 0 // trở lại câu hỏi đầu tiên

                        Toast.makeText(requireContext(), "Đã lấy hết dữ liệu từ JSON", Toast.LENGTH_SHORT).show()
                    }


                    // Lấy câu hỏi từ JSON bằng cách sử dụng biến currentPosition
//                    val question = questionList!!.questions[currentPosition].list_question[0]
//
//                    // Đặt giá trị của các TextView dựa trên câu hỏi vừa lấy được từ JSON
//                    binding?.txtnumber1?.text = question.number_1.toString()
//                    binding?.txtoperator?.text = question.operator
//                    binding?.txtnumber2?.text = question.number_2.toString()
                    binding?.txtkq?.text = null
                }
            }
        })
        setSpinner()
        onClick()
        startCountDown()
        resetScreen()
    }

    private fun resetScreen() {
        binding?.btnReset?.setOnClickListener {
            binding?.txtnumber1?.text = null
            binding?.txtnumber2?.text = null
            binding?.btnTimer?.text = null
            binding?.txtkq?.text = null
        }
    }

    private fun startCountDown() {
        val FIVE_MINUTES_IN_MILLIS = 5 * 60 * 1000 // 5 minutes in milliseconds
        timeLeftInMillis = 0 // start from 0 milliseconds

        countDownTimer = object : CountDownTimer(FIVE_MINUTES_IN_MILLIS.toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis += 1000 // increase by 1 second every tick
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
  //     val list = resources.getStringArray(R.array.number)
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
            }
        }
    }



}