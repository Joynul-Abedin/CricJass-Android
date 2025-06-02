package com.shokal.cricjass.fragments.team

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.shokal.cricjass.adapters.TeamsRankingAdapter
import com.shokal.cricjass.databinding.FragmentTeamsRankingBinding
import com.shokal.cricjass.utlis.ProgressBar
import com.shokal.cricjass.viewmodels.CricketViewModel

class TeamsRankingFragment : Fragment() {
    private lateinit var viewModel: CricketViewModel
    private var _binding: FragmentTeamsRankingBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[CricketViewModel::class.java]
        _binding = FragmentTeamsRankingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val progressDialog = ProgressBar.ProgressBarSingleton.showProgressBar(
            requireContext(), "Team Loading..."
        )
        val handler = Handler()
        handler.postDelayed({
            ProgressBar.ProgressBarSingleton.hideProgressBar(progressDialog)
        }, 2000)
        viewModel.getTeamWithRanking()
        viewModel.cachedTeamsList.observe(viewLifecycleOwner) {
            binding.teamRankingRecycleView.adapter = TeamsRankingAdapter(it[0])
        }
        binding.testFilter.setOnClickListener {
            viewModel.cachedTeamsList.observe(viewLifecycleOwner) {
                binding.teamRankingRecycleView.adapter = TeamsRankingAdapter(it[0])
            }
        }
        binding.odiFilter.setOnClickListener {
            viewModel.cachedTeamsList.observe(viewLifecycleOwner) {
                binding.teamRankingRecycleView.adapter = TeamsRankingAdapter(it[1])
            }
        }
        binding.t20Filter.setOnClickListener {
            viewModel.cachedTeamsList.observe(viewLifecycleOwner) {
                binding.teamRankingRecycleView.adapter = TeamsRankingAdapter(it[2])
            }
        }

    }
}