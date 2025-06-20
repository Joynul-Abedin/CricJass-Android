package com.shokal.cricjass.adapters.viewPagerAdapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.shokal.cricjass.fragments.fixture.CompetitionsFragment
import com.shokal.cricjass.fragments.team.TeamsFragment

class SeriesTabAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                val fragment = TeamsFragment()
                val args = Bundle()
                args.putString("type", "teams")
                fragment.arguments = args
                fragment
            }
            else -> {
                val fragment = CompetitionsFragment()
                val args = Bundle()
                args.putString("type", "competitions")
                fragment.arguments = args
                fragment
            }
        }
    }
}