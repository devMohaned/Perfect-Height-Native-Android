package com.perfect.height.presentation.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.perfect.height.R
import com.perfect.height.databinding.FragmentHeightBinding
import com.perfect.height.presentation.adapter.AverageHeightAdapter
import com.perfect.height.utils.GENDER_FEMALE
import com.perfect.height.utils.GENDER_MALE
import com.perfect.height.utils.hideKeyboard

class HeightFragment : Fragment() {
    private var _binding: FragmentHeightBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HeightViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_height,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.updateGender(readGenderToSharedPrefs())
        binding.apply {
            heightViewModel = viewModel
            heightFragment = this@HeightFragment
            genderMale = GENDER_MALE
            genderFemale = GENDER_FEMALE
            lifecycleOwner = viewLifecycleOwner
        }

    }

    fun genderClick(gender: Int){
        viewModel.updateGender(gender)
        saveGenderToSharedPrefs()
    }
    fun performPerfectionCalculation(){
        try {
            hideKeyboard()
            val heightInCm = (binding.heightEditText.text.toString()).toFloat()
            binding.heightTextInput.error = null
            viewModel.performPerfection(heightInCm, viewModel.gender.value!!)
            createDialog(heightInCm, viewModel.gender.value!!, viewModel.result.value!!).show()
        } catch (exception: NumberFormatException) {
            binding.heightTextInput.error = getString(R.string.incorrect_number)
        }

    }

    fun navigateToCountry(){
        val action =
            HeightFragmentDirections.actionHeightFragmentToCountryFragment(viewModel.gender.value!!)
        findNavController().navigate(action)
    }

    private fun createDialog(heightInCM: Float, gender: Int, message: String): AlertDialog {
        val builder = AlertDialog.Builder(requireContext())
        builder.setMessage(message)
            .setPositiveButton(
                R.string.view_result
            ) { _, _ ->
                val action = HeightFragmentDirections.actionHeightFragmentToResultFragment(gender)
                action.myHeight = heightInCM
                findNavController().navigate(action)

            }
            .setNegativeButton(
                R.string.cancel
            ) { _, _ -> }
        return builder.create()
    }

    private fun saveGenderToSharedPrefs() {
        val sharedPref = activity?.getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE
        )

        with(sharedPref!!.edit()) {
            putInt(getString(R.string.gender_key), viewModel.gender.value!!)
            apply()
        }
    }

    private fun readGenderToSharedPrefs(): Int {
        val sharedPref = activity?.getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE
        ) ?: return GENDER_MALE
        return sharedPref.getInt(getString(R.string.gender_key), GENDER_MALE)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}