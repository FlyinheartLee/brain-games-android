package com.braingames

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class GameAdapter(
    private val games: List<Game>,
    private val onGameClick: (Game) -> Unit
) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.cardView)
        val ivIcon: ImageView = itemView.findViewById(R.id.ivIcon)
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_game, parent, false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = games[position]
        holder.tvName.text = game.name
        holder.tvDescription.text = game.description
        holder.ivIcon.setImageResource(game.iconRes)
        
        holder.cardView.setOnClickListener {
            onGameClick(game)
        }
    }

    override fun getItemCount(): Int = games.size
}
