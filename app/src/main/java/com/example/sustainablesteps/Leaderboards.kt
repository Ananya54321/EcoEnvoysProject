package com.example.sustainablesteps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sustainablesteps.adapter.LeaderboardAdapter
import com.example.sustainablesteps.databinding.ActivityLeaderboardsBinding

class Leaderboards : AppCompatActivity() {
    private  val binding: ActivityLeaderboardsBinding by lazy {
        ActivityLeaderboardsBinding.inflate(layoutInflater)
    }
    private lateinit var LeaderboardAdapter: LeaderboardAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val leaderboardUserName = listOf("Ananya", "Brinda", "Dhruv", "Niharika", "Ram", "Ananya", "Brinda", "Dhruv", "Niharika", "Ram")
        val leaderboardUserPoints = listOf("893", "985", "348", "597", "749", "893", "985", "348", "597", "749")
        val leaderboardImage = listOf(
            R.drawable.profilepicimg,
            R.drawable.profilepicimg,
            R.drawable.profilepicimg,
            R.drawable.profilepicimg,
            R.drawable.profilepicimg,
            R.drawable.profilepicimg,
            R.drawable.profilepicimg,
            R.drawable.profilepicimg,
            R.drawable.profilepicimg,
            R.drawable.profilepicimg
        )
        val leaderboardLevels = listOf("18", "21", "14", "16", "17", "18", "21", "14", "16", "17")

        val adapter = LeaderboardAdapter(
            ArrayList(leaderboardUserName),
            ArrayList(leaderboardUserPoints),
            ArrayList(leaderboardLevels),
            ArrayList(leaderboardImage)
        )
        binding.leaderboardsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.leaderboardsRecyclerView.adapter = adapter

    }
}