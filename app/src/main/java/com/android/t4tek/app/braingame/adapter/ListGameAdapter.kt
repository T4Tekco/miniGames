package com.android.t4tek.app.braingame.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.t4tek.app.braingame.model.ListGame
import com.android.t4tek.databinding.ItemListGameBinding

class ListGameAdapter : RecyclerView.Adapter<ListGameAdapter.LGViewHolder>() {

    private lateinit var listGame : List<ListGame>

    fun getListGame(listGame: List<ListGame>){
        this.listGame = listGame
    }

    class LGViewHolder(private val binding : ItemListGameBinding):RecyclerView.ViewHolder(binding.root) {
        fun bin(list : ListGame){
            binding.let {
                it.tvSTT.text = list.stt.toString()
                it.tvTime.text = list.time
                it.starOne.setImageResource(list.starOne)
                it.starTwo.setImageResource(list.starTwo)
                it.starThree.setImageResource(list.starThree)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LGViewHolder {
        val binding = ItemListGameBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LGViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listGame.size
    }

    override fun onBindViewHolder(holder: LGViewHolder, position: Int) {
        holder.bin(listGame[position])
    }
}