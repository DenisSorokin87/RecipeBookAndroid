package com.denis.recipebookandroid.view.ui.create_recipe

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.denis.recipebookandroid.R
import com.denis.recipebookandroid.databinding.RecipeCreateFragmentBinding
import com.denis.recipebookandroid.model.data.CookingProcess
import com.denis.recipebookandroid.model.data.Ingredient
import com.denis.recipebookandroid.model.data.IngredientAmountUnit
import com.denis.recipebookandroid.model.data.Recipe
import com.denis.recipebookandroid.model.states.LoadingState

class RecipeCreateFragment : Fragment(R.layout.recipe_create_fragment) {

    private lateinit var recipeViewModel: RecipeCreateViewModel

    private val cookingProcessesList: ArrayList<CookingProcess> = ArrayList()
    private val ingredientList: ArrayList<Ingredient> = ArrayList()
    private lateinit var ingredientListAdapter: ArrayAdapter<Ingredient>
    private var _binding: RecipeCreateFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = RecipeCreateFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ingredientAmountUnitAdapter: ArrayAdapter<CharSequence> = ArrayAdapter(requireContext(),R.layout.spinner_item, getIngredientAmountUnitsArray())
        ingredientAmountUnitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.ingredientUnits.adapter = ingredientAmountUnitAdapter

        ingredientListAdapter = ArrayAdapter(requireContext(), R.layout.list_view_text_style, ingredientList)

        val dishTypeAdapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(requireContext(), R.array.dishType, android.R.layout.simple_spinner_item).
            also {
                it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.dishTypeSpinner.adapter = it
            }

        recipeViewModel = ViewModelProvider(requireActivity(), RecipeCreateViewModelFactory(requireActivity().application))[RecipeCreateViewModel::class.java]

        viewModelObserve()

        addIngredientBtnListener()
        addCookingProcessBtnListener()
        submitBtnListener()

    }



    private fun viewModelObserve() {
        recipeViewModel.recipeLiveData.observe(requireActivity()){
            when(it){
                is LoadingState.LOADING -> binding.loading.visibility = View.VISIBLE
                is LoadingState.LOADED -> {
                    binding.loading.visibility = View.GONE
//                    setRecipeRecycler(it.data as ArrayList<Recipe>)
                }
                is LoadingState.Error -> {
                    binding.loading.visibility = View.GONE
                    Toast.makeText(
                        requireActivity(),
                        it.error,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    private fun addCookingProcessBtnListener() {
        var processString: String? = null
       binding.addProcessBtn.setOnClickListener {
           cookingProcessesList.add(CookingProcess(cookingProcessesList.size+1, binding.cookingProcessDescribe.text.toString()))
           processString = if(processString == null){
               cookingProcessesList.last().toString()
           } else{
               processString + "\n" + cookingProcessesList.last().toString()
           }
           binding.processesList.text = processString
       }
    }

    private fun addIngredientBtnListener() {
        binding.addIngredientBtn.setOnClickListener {
            val spinnerPosition = binding.ingredientUnits.selectedItemPosition
            val spinnerItem = getIngredientAmountUnitsArray()[spinnerPosition]
            ingredientListAdapter.add(Ingredient(binding.ingredient.text.toString(), Integer.valueOf(binding.ingredientAmount.text.toString()), spinnerItem))
            binding.ingredientsList.adapter = ingredientListAdapter
            binding.ingredient.text.clear()
            binding.ingredientAmount.text.clear()
            binding.ingredientUnits.clearFocus()
        }
    }

    private fun submitBtnListener() {

        binding.commitBtn.setOnClickListener {
            recipeViewModel.createNewRecipe(Recipe(binding.recipeName.text.toString(),
                "DishImageUrl",
                binding.dishDescription.text.toString(),
                ingredientList, cookingProcessesList, binding.dishTypeSpinner.selectedItem.toString()))
        }

    }

    private fun getIngredientAmountUnitsArray(): List<String> {
        val strArray: ArrayList<String> = ArrayList()
        strArray.add(0, "Units")
        IngredientAmountUnit.values().forEach{
            strArray.add(it.toString())
        }
        return strArray
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
