package com.denis.recipebookandroid.view.ui.create_recipe

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.denis.recipebookandroid.R
import com.denis.recipebookandroid.databinding.RecipeCreateFragmentBinding
import com.denis.recipebookandroid.model.data.CookingProcess
import com.denis.recipebookandroid.model.data.Ingredient
import com.denis.recipebookandroid.model.data.IngredientAmountUnit

class RecipeCreateFragment : Fragment(R.layout.recipe_create_fragment) {

    private lateinit var viewModel: RecipeCreateViewModel

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

        viewModel = ViewModelProvider(requireActivity(), RecipeCreateViewModelFactory(requireActivity().application))[RecipeCreateViewModel::class.java]
//
//        viewModelObserve()
//
        addIngredientBtnListener()
//        addCookingProcessBtnListener()
//        submitBtnListener()

    }

    private fun getIngredientAmountUnitsArray(): List<String> {
        val strArray: ArrayList<String> = ArrayList()
        strArray.add(0, "Units")
        IngredientAmountUnit.values().forEach{
            strArray.add(it.toString())
        }
        return strArray
    }


    private fun viewModelObserve() {
        TODO("Not yet implemented")
    }


    private fun addCookingProcessBtnListener() {
       binding.addProcessBtn.setOnClickListener {
           cookingProcessesList.add(CookingProcess(cookingProcessesList.size+1, binding.cookingProcessDescribe.text.toString()))
           val processString = cookingProcessesList.last().toString() + "\n"
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
        TODO("Not yet implemented")
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
