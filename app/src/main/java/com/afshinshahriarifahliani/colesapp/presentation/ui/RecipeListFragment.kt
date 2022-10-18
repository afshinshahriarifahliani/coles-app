package com.afshinshahriarifahliani.colesapp.presentation.ui

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.afshinshahriarifahliani.colesapp.databinding.FragmentRecipeListBinding
import com.afshinshahriarifahliani.colesapp.presentation.adapter.RecipeAdapter
import com.afshinshahriarifahliani.colesapp.presentation.viewmodel.ColesViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RecipeListFragment : Fragment() {
    private lateinit var colesViewModel: ColesViewModel
    private lateinit var recipeAdapter: RecipeAdapter
    private var _binding: FragmentRecipeListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRecipeListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        colesViewModel = (activity as MainActivity).colesViewModel
        recipeAdapter = (activity as MainActivity).recipeAdapter
        recipeAdapter.setOnItemClickListener {
            val action =
                RecipeListFragmentDirections.actionRecipeListFragmentToRecipeDetailsFragment(it)
            findNavController().navigate(action)

        }
        initRecyclerView()
        viewRecipeList()

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val orientationLand = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE
    }
    private fun initRecyclerView() {
        binding.recipeListRecyclerView.apply {
            adapter = recipeAdapter
            layoutManager = LinearLayoutManager(activity)

        }
    }

    private fun viewRecipeList() {

        colesViewModel.getSampleRecipeList()
        colesViewModel.recipeList.observe(viewLifecycleOwner) {
            recipeAdapter.swapData(it.recipes)
            Log.i("TAG", "viewRecipeList:${it.recipes[0].dynamicTitle} ")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}