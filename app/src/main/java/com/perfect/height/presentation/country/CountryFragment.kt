package com.perfect.height.presentation.country

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.core.view.get
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.perfect.height.R
import com.perfect.height.databinding.FragmentCountryBinding
import com.perfect.height.presentation.adapter.AverageHeightAdapter

class CountryFragment : Fragment() {
    private var _binding: FragmentCountryBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CountryViewModel by viewModels()
    private val args: CountryFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.assignGender(args.myGender)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.chooseGender()
        initAdapter()

        requireActivity().addMenuProvider(object : MenuProvider {
            lateinit var rootMenu: Menu
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.country_height_menu, menu)
                rootMenu = menu
                setGenderIcon(menu[2])
                setCollapseOrCollisionIcon(menu[1])
                setLayoutIcon(menu[0])
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.switchLayoutMenuItem -> {
                        viewModel.switchLayouts()
                        switchAdapterLayout()
                        setLayoutIcon(menuItem)
                        return true
                    }
                    R.id.switchGenderMenuItem -> {
                        viewModel.switchGender()
                        viewModel.chooseGender()
                        initAdapter()
                        setGenderIcon(menuItem)
                        return true
                    }
                    R.id.switchCollapseMenuItem -> {
                        viewModel.switchCollapse()
                        switchToCollapseOrCollide()
                        setCollapseOrCollisionIcon(menuItem)
                        return true
                    }
                    // Back Button ID
                    16908332 -> return findNavController().popBackStack()

                    else -> return true

                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun initAdapter() {
        viewModel.initAdapter()
        binding.countryRecyclerview.adapter = viewModel.adapter
    }

    private fun switchAdapterLayout() {
        (binding.countryRecyclerview.adapter!! as AverageHeightAdapter).updateLayoutManager()
    }


    private fun setLayoutIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return

        menuItem.icon =
            if (viewModel.isLinearLayoutManager)
                ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_linear_layout)
    }


    private fun setGenderIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return

        menuItem.icon =
            if (viewModel.isMale()) ContextCompat.getDrawable(
                this.requireContext(),
                R.drawable.ic_female
            )
            else ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_male)
    }


    private fun switchToCollapseOrCollide() {
        (binding.countryRecyclerview.adapter!! as AverageHeightAdapter).collapaseOrCollide(
            viewModel.isCollapsed
        )
    }

    private fun setCollapseOrCollisionIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return

        menuItem.icon =
            if (viewModel.isCollapsed) ContextCompat.getDrawable(
                this.requireContext(),
                R.drawable.ic_collide
            )
            else ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_collapse)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}