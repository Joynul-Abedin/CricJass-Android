package com.shokal.cricjass.fragments.fixture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shokal.cricjass.adapters.CompetitionsListAdapter
import com.shokal.cricjass.databinding.FragmentCompetitionsBinding
import com.shokal.cricjass.utlis.ProgressBar
import com.shokal.cricjass.viewmodels.CricketViewModel

class CompetitionsFragment : Fragment() {
    private lateinit var viewModel: CricketViewModel
    private lateinit var recyclerView: RecyclerView
    private var _binding: FragmentCompetitionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCompetitionsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this)[CricketViewModel::class.java]
        recyclerView = binding.competitionRecyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.isDrawingCacheEnabled = true
        recyclerView.setItemViewCacheSize(900)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val progressDialog = ProgressBar.ProgressBarSingleton.showProgressBar(
            requireContext(), "Matches are Loading..."
        )
        viewModel.leagues.observe(viewLifecycleOwner) {
            recyclerView.adapter = CompetitionsListAdapter(requireContext(), it)
        }
        ProgressBar.ProgressBarSingleton.hideProgressBar(progressDialog)
    }
}