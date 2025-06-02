package com.shokal.cricjass.adapters.viewPagerAdapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.shokal.cricjass.fragments.player.BattingCareerFragment
import com.shokal.cricjass.fragments.player.BowlingCareerFragment
import com.shokal.cricjass.fragments.player.PlayerInfoMainFragment
import com.shokal.cricjass.models.fixtures.Lineup

class PlayerInfoTabAdapter(
    fragmentManager: FragmentManager, lifecycle: Lifecycle, private val player: Lineup
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                val fragment = PlayerInfoMainFragment()
                val args = Bundle()
                player.id?.let { args.putInt("playerId", it) }
                fragment.arguments = args
                fragment
            }
            1 -> {
                val fragment = BattingCareerFragment()
                val args = Bundle()
                player.id?.let { args.putInt("playerId", it) }
                fragment.arguments = args
                fragment
            }
            else -> {
                val fragment = BowlingCareerFragment()
                val args = Bundle()
                player.id?.let { args.putInt("playerId", it) }
                fragment.arguments = args
                fragment
            }
        }


    }
}