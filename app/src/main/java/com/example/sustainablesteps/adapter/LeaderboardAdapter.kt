package com.example.sustainablesteps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sustainablesteps.databinding.LeaderboardItemBinding

class LeaderboardAdapter(private val leaderboardUserNames : ArrayList<String>, private val LeaderboardUserPoints: ArrayList<String>,
                                  private val LeaderboardUserLevels: ArrayList<String>, private val LeaderboardProfilePictures: ArrayList<Int>) :
    RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaderboardViewHolder {
        val binding = LeaderboardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LeaderboardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LeaderboardViewHolder, position: Int) {
        holder.bind(leaderboardUserNames[position], LeaderboardUserPoints[position], LeaderboardProfilePictures[position], LeaderboardUserLevels[position])

    }

    override fun getItemCount(): Int = leaderboardUserNames.size

    class LeaderboardViewHolder(private val binding: LeaderboardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(userName: String, userPoints: String, profilePic: Int, userLevel: String) {
            binding.leaderboardsusername.text = userName
            binding.leaderboardpointsnumber.text = userPoints + " points"
            binding.profileLeaderboards.setImageResource(profilePic)
            binding.leaderboardslevel.text = "Level "+userLevel

        }

    }
}