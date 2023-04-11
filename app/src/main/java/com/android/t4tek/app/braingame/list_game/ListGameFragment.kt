package com.android.t4tek.app.braingame.list_game

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.compose.ui.graphics.Color
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.t4tek.R
import com.android.t4tek.app.base.BaseFragment
import com.android.t4tek.app.braingame.adapter.ListGameAdapter
import com.android.t4tek.app.braingame.model.ListGame
import com.android.t4tek.databinding.FragmentListGameBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListGameFragment : BaseFragment() {

    private var binding : FragmentListGameBinding? = null
    private lateinit var adapter : ListGameAdapter
    private lateinit var listGame : ArrayList<ListGame>

//    lateinit var id : Array<Int>
//    lateinit var time: Array<String>
//    lateinit var starOne: Array<Int>
//    lateinit var starTwo: Array<Int>
//    lateinit var starThree: Array<Int>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListGameBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        loadListGame()
        val linearLayoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        binding?.rvListGame?.layoutManager = linearLayoutManager
        adapter = ListGameAdapter()
        adapter.setHasStableIds(true)
        adapter.getListGame(listGame, object : ListGameAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
//                val builder = AlertDialog.Builder(context)
//                builder.setTitle("GAME NUMBER: " + (position + 1))
//                    .setMessage("Tiếp tục")
//                    .setCancelable(true)
//                    .setPositiveButton("Yes") { _, _ -> activity?.finish() }
//                    .setNegativeButton("No", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })
//                    .show()
                openDialog(listGame,position,Gravity.CENTER)
            }
        })
        binding?.rvListGame?.adapter = adapter
    }

    private fun openDialog(listgame: List<ListGame>,position: Int,gravity: Int){
        val dialog: Dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.layou_dialog_in_game)

        val window: Window = dialog.window ?: return
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT)

        val windowAttribustes: WindowManager.LayoutParams = window.attributes
        windowAttribustes.gravity = gravity
        window.attributes = windowAttribustes

        val stt = dialog.findViewById<TextView>(R.id.tvNumber_game)
        val bestTime = dialog.findViewById<TextView>(R.id.tvBestTime)
        val bestResult = dialog.findViewById<TextView>(R.id.tvNumberB_Result)
        val btnViewResult = dialog.findViewById<Button>(R.id.btnViewAnswer)
        val btnPlay = dialog.findViewById<Button>(R.id.btnPlay)
        val btnExit = dialog.findViewById<ImageView>(R.id.btnExit)

        stt.text = listgame[position].stt.toString()
        bestTime.text = listgame[position].time
        bestResult.text = listgame[position].result.toString()

        btnViewResult.setOnClickListener {
            Toast.makeText(context,"View",Toast.LENGTH_SHORT).show()
        }
        btnPlay.setOnClickListener {
            Toast.makeText(context,"Play",Toast.LENGTH_SHORT).show()
        }
        btnExit.setOnClickListener {
            Toast.makeText(context,"Close",Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun loadListGame(){
        val starBlack = R.drawable.baseline_star_border_24_black
        val starYellow = R.drawable.baseline_star_24
        listGame = arrayListOf<ListGame>()
        listGame.add(ListGame(1,"10:00",40,starBlack,starBlack,starBlack))
        listGame.add(ListGame(2,"04:05",50,starYellow,starYellow,starYellow))
        listGame.add(ListGame(3,"07:30",50,starYellow,starYellow,starBlack))
        listGame.add(ListGame(4,"05:00",45,starYellow,starYellow,starYellow))
        listGame.add(ListGame(5,"07:15",40,starYellow,starYellow,starBlack))
        listGame.add(ListGame(6,"10:35",35,starBlack,starBlack,starBlack))
        listGame.add(ListGame(7,"00:00",0,starBlack,starBlack,starBlack))
        listGame.add(ListGame(8,"00:00",0,starBlack,starBlack,starBlack))
        listGame.add(ListGame(9,"00:00",0,starBlack,starBlack,starBlack))
        listGame.add(ListGame(10,"00:00",0,starBlack,starBlack,starBlack))

//        id = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//
//        time = arrayOf(
//            "01:00","00:05","00:30","00:10","00:15","00:35","01:00","01:00","01:00","01:00"
//        )
//
//        starOne = arrayOf(
//            starBlack,starYellow,starYellow,starYellow,starYellow,starBlack,starBlack,starBlack,starBlack,starBlack
//        )
//
//        starTwo = arrayOf(
//            starBlack,starYellow,starYellow,starYellow,starYellow,starBlack,starBlack,starBlack,starBlack,starBlack
//        )
//
//        starThree = arrayOf(
//            starBlack,starYellow,starBlack,starYellow,starBlack,starBlack,starBlack,starBlack,starBlack,starBlack
//        )
//
//        for (i in id.indices){
//            val list = ListGame(id[i],time[i],starOne[i],starTwo[i],starThree[i])
//            listGame.add(list)
//        }
    }

}