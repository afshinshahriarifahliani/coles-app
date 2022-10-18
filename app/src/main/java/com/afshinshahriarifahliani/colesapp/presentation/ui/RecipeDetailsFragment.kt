package com.afshinshahriarifahliani.colesapp.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.afshinshahriarifahliani.colesapp.databinding.FragmentRecipeDetailsBinding
import com.afshinshahriarifahliani.colesapp.domain.repository.util.BASE_URL
import com.afshinshahriarifahliani.colesapp.domain.repository.util.getCircularProgress
import com.afshinshahriarifahliani.colesapp.domain.repository.util.loadImage
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class RecipeDetailsFragment : Fragment() {

    private var _binding: FragmentRecipeDetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRecipeDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: RecipeDetailsFragmentArgs by navArgs()

        val selectedRecipe = args.selectedRecipe

        val colesViewModel = (activity as MainActivity).colesViewModel

        binding.apply {

            recipeTitle.text = selectedRecipe.dynamicTitle

            recipeDescription.text = selectedRecipe.dynamicDescription

            dynamicThumbnail.loadImage(
                BASE_URL + selectedRecipe.dynamicThumbnail,
                getCircularProgress(dynamicThumbnail.context)
            )

            recipeServesLabel.text = selectedRecipe.recipeDetails?.amountLabel ?: "Serves"
            recipeServesAmount.text = selectedRecipe.recipeDetails?.amountNumber.toString()

            recipePrepLabel.text = selectedRecipe.recipeDetails?.prepLabel ?: "Serves"
            recipePrepTime.text = selectedRecipe.recipeDetails?.prepTime.toString()

            recipeCookingLabel.text = selectedRecipe.recipeDetails?.cookingLabel ?: "Serves"
            recipeCookingTime.text = selectedRecipe.recipeDetails?.cookingTime.toString()

            val ingredientList = selectedRecipe.ingredients
            val ingredientString = StringBuilder()
            ingredientList?.forEach { item ->
                ingredientString.append("> ")
                    .append(item.ingredient)
                    .append("\n\n")
            }
            recipeIngredients.text = ingredientString.toString()

        }

        binding.fab.setOnClickListener { fabView ->

            colesViewModel.saveRecipe(selectedRecipe)
            colesViewModel.saveRecipeResult.observe(viewLifecycleOwner) {
                if (it > 0) {
                    Snackbar.make(
                        fabView,
                        "Recipe added to favorites successfully",
                        Snackbar.LENGTH_LONG
                    ).setAction("Ok") { snackbar->
                        snackbar.visibility = View.GONE
                    }.show()
                }
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}