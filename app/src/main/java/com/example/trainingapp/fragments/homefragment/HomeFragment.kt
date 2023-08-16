package com.example.trainingapp.fragments.homefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.trainingapp.R
import com.example.trainingapp.data.models.TrainingViewModel
import com.example.trainingapp.databinding.FragmentHomeBinding
import com.example.trainingapp.ui.bindSessionRecyclerView
import kotlinx.coroutines.launch

const val TAG = "HomeFragment"

class HomeFragment : Fragment() {
    private var binding: FragmentHomeBinding? = null
    private val viewModel: TrainingViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentHomeBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        //binding?.lifecycleOwner = this
        //binding?.homeFragment = this
        binding?.viewModel = viewModel
       /*val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.title = getString(R.string.overview)*/
        //lifecycleScope.launch { viewModel.populateTestData() }

        setAdapter()

        return fragmentBinding.root
    }

    private fun setAdapter(){
        binding?.apply {
            val adapter = SessionListAdapter { item ->
                //Todo: add on click
            }
            homeList.adapter = adapter
            viewModel?.sessions?.observe(viewLifecycleOwner) { items ->
                adapter.submitList(items)
            }
        }
        bindSessionRecyclerView(binding?.homeList!! , viewModel.sessions.value)
    }

}