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
        val linearLayoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        binding?.rvListGame?.layoutManager = linearLayoutManager
        adapter = ListGameAdapter()
        adapter.setHasStableIds(true)
        adapter.getListGame(loadListGame())
        binding?.rvListGame?.adapter = adapter
    }


    private fun loadListGame() : List<ListGame> {
        val starBlack = R.drawable.baseline_star_border_24_black
        val starYellow = R.drawable.baseline_star_24

        val listGame = ArrayList<ListGame>()
        listGame.add(ListGame(1,"1:00",starBlack,starBlack,starBlack))
        listGame.add(ListGame(2,"00:05",starYellow,starYellow,starYellow))
        listGame.add(ListGame(3,"00:30",starYellow,starYellow,starBlack))
        listGame.add(ListGame(4,"00:10",starYellow,starYellow,starYellow))
        listGame.add(ListGame(5,"00:15",starYellow,starYellow,starBlack))
        listGame.add(ListGame(5,"00:35",starBlack,starBlack,starBlack))
        listGame.add(ListGame(6,"01:00",starBlack,starBlack,starBlack))
        listGame.add(ListGame(7,"01:00",starBlack,starBlack,starBlack))
        listGame.add(ListGame(8,"01:00",starBlack,starBlack,starBlack))
        listGame.add(ListGame(9,"01:00",starBlack,starBlack,starBlack))
        listGame.add(ListGame(10,"01:00",starBlack,starBlack,starBlack))
        return listGame
    }
}