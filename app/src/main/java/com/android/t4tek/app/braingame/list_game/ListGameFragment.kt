package com.android.t4tek.app.braingame.list_game

import android.app.Dialog
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.t4tek.R
import com.android.t4tek.app.base.BaseFragment
import com.android.t4tek.app.braingame.BrainGameActivity
import com.android.t4tek.app.braingame.adapter.ListGameAdapter
import com.android.t4tek.app.braingame.model.ListGame
import com.android.t4tek.databinding.FragmentListGameBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListGameFragment : BaseFragment() {

    private var _binding : FragmentListGameBinding? = null
    private val binding get() = _binding!!
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
        _binding = FragmentListGameBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        customToolBar()
        initAdapter()
    }

    private fun customToolBar(){

        val activity: AppCompatActivity = activity as AppCompatActivity
//        val toolbar = binding.tbrListGame
//        activity.setSupportActionBar(toolbar)
        activity.supportActionBar?.let { actionBar ->
            actionBar.title = ""
        }
        binding.tbnBackLG.setOnClickListener{
            findNavController().navigate(R.id.action_listGameFragment_to_homeFragment)
        }
    }

    private fun initAdapter() {
        loadListGame()
        val linearLayoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        binding.rvListGame.layoutManager = linearLayoutManager
        adapter = ListGameAdapter()
        adapter.setHasStableIds(true)
        adapter.getListGame(listGame, object : ListGameAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                openDialog(listGame,position,Gravity.CENTER)
            }
        })
        binding.rvListGame.adapter = adapter
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

            startActivity(Intent(requireContext(), BrainGameActivity::class.java))

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
    }

}