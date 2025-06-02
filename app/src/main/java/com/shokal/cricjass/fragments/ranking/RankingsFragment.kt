package com.shokal.cricjass.fragments.ranking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.shokal.cricjass.adapters.viewPagerAdapter.RankingsTabAdapter
import com.shokal.cricjass.databinding.FragmentRankingsBinding
import com.shokal.cricjass.viewmodels.CricketViewModel

class RankingsFragment : Fragment() {
    private lateinit var viewModel: CricketViewModel
    private var _binding: FragmentRankingsBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[CricketViewModel::class.java]
        _binding = FragmentRankingsBinding.inflate(inflater, container, false)
        navController = findNavController()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tabLayout = binding.rankingTabLayout
        val viewpage = binding.rankingViewPager
        val tabAdapter = RankingsTabAdapter(childFragmentManager, lifecycle)
        viewpage.adapter = tabAdapter
        TabLayoutMediator(tabLayout, viewpage) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "BatsMan"
                }
                1 -> {
                    tab.text = "Bowler"
                }
                2 -> {
                    tab.text = "AllRounder"
                }
                else -> {
                    tab.text = "Teams"
                }
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}