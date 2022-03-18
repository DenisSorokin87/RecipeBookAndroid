package com.denis.recipebookandroid.view.ui.create_recipe

import android.icu.number.IntegerWidth
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.denis.recipebookandroid.R
import com.denis.recipebookandroid.databinding.RecipeCreateFragmentBinding
import com.denis.recipebookandroid.model.data.CookingProcess
import com.denis.recipebookandroid.model.data.Ingredient
import com.denis.recipebookandroid.model.data.IngredientAmountUnit
import com.google.android.material.datepicker.OnSelectionChangedListener

class RecipeCreateFragment : Fragment(R.layout.recipe_create_fragment) {

    private lateinit var viewModel: RecipeCreateViewModel
//    private lateinit var recipeName: EditText
//    private lateinit var dishType: Spinner
//    private lateinit var dishDescription: EditText
//    private lateinit var dishImage: ImageView
//    private lateinit var ingredient: EditText
//    private lateinit var ingredientAmount: EditText
//    private lateinit var ingredientAmountUnit: Spinner
//    private lateinit var addIngredientBtn: Button
//    private lateinit var ingredientsList: ListView
//    private lateinit var cookingProcess: EditText
//    private lateinit var addCookProcessBtn: Button
//    private lateinit var cookingProcessesList: ListView
//    private lateinit var commitBtn: Button

    private val cookingProcessesList: ArrayList<CookingProcess> = ArrayList()
    private val ingredientList: ArrayList<Ingredient> = ArrayList()


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

        val ingredientAmountUnitAdapter: ArrayAdapter<CharSequence> = ArrayAdapter(requireContext(),R.layout.ingredient_unit_item, getIngredientAmountUnitsArray())
        ingredientAmountUnitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.ingredientUnits.adapter = ingredientAmountUnitAdapter


        viewModel = ViewModelProvider(requireActivity(), RecipeCreateViewModelFactory(requireActivity().application))[RecipeCreateViewModel::class.java]

        viewModelObserve()

        addIngredientBtnListener()
        addCookingProcessBtnListener()
        submitBtnListener()

    }

    private fun getIngredientAmountUnitsArray(): List<String> {
        val strArray: ArrayList<String> = ArrayList()
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
            ingredientList.add(Ingredient(binding.ingredient.text.toString(), Integer.valueOf(binding.ingredientAmount.text.toString()), spinnerItem))
            val processString = cookingProcessesList.last().toString() + "\n"
            binding.processesList.text = processString
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
