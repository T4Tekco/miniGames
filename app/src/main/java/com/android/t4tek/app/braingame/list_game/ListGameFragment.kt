package com.android.t4tek.app.braingame.list_game

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    lateinit var id : Array<Int>
    lateinit var time: Array<String>
    lateinit var starOne: Array<Int>
    lateinit var starTwo: Array<Int>
    lateinit var starThree: Array<Int>


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
        adapter.getListGame(listGame)
        binding?.rvListGame?.adapter = adapter
    }


    private fun loadListGame(){
        val starBlack = R.drawable.baseline_star_border_24_black
        val starYellow = R.drawable.baseline_star_24
        listGame = arrayListOf<ListGame>()
//        listGame.add(ListGame(1,"1:00",starBlack,starBlack,starBlack))
//        listGame.add(ListGame(2,"00:05",starYellow,starYellow,starYellow))
//        listGame.add(ListGame(3,"00:30",starYellow,starYellow,starBlack))
//        listGame.add(ListGame(4,"00:10",starYellow,starYellow,starYellow))
//        listGame.add(ListGame(5,"00:15",starYellow,starYellow,starBlack))
//        listGame.add(ListGame(6,"00:35",starBlack,starBlack,starBlack))
//        listGame.add(ListGame(7,"01:00",starBlack,starBlack,starBlack))
//        listGame.add(ListGame(8,"01:00",starBlack,starBlack,starBlack))
//        listGame.add(ListGame(9,"01:00",starBlack,starBlack,starBlack))
//        listGame.add(ListGame(10,"01:00",starBlack,starBlack,starBlack))

        id = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        time = arrayOf(
            "01:00","00:05","00:30","00:10","00:15","00:35","01:00","01:00","01:00","01:00"
        )

        starOne = arrayOf(
            starBlack,starYellow,starYellow,starYellow,starYellow,starBlack,starBlack,starBlack,starBlack,starBlack
        )

        starTwo = arrayOf(
            starBlack,starYellow,starYellow,starYellow,starYellow,starBlack,starBlack,starBlack,starBlack,starBlack
        )

        starThree = arrayOf(
            starBlack,starYellow,starBlack,starYellow,starBlack,starBlack,starBlack,starBlack,starBlack,starBlack
        )

        for (i in id.indices){
            val list = ListGame(id[i],time[i],starOne[i],starTwo[i],starThree[i])
            listGame.add(list)
        }
    }
}