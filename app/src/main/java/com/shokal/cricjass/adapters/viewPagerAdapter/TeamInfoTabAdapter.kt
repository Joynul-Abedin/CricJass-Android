package com.shokal.cricjass.adapters.viewPagerAdapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.shokal.cricjass.fragments.team.ScoreBoardTeamInfoFragment
import com.shokal.cricjass.fragments.team.TeamInfoFragment
import com.shokal.cricjass.models.fixtures.Data

class TeamInfoTabAdapter(
    fragmentManager: FragmentManager, lifecycle: Lifecycle, val fixture: Data
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                val fragment = TeamInfoFragment()
                val args = Bundle()
                args.putParcelable("fixture", fixture)
                fragment.arguments = args
                fragment
            }
            else -> {
                val fragment = ScoreBoardTeamInfoFragment()
                val args = Bundle()
                args.putParcelable("fixture", fixture)
                fragment.arguments = args
                fragment
            }
        }
    }
}