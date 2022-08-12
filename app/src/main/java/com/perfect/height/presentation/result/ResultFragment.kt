package com.perfect.height.presentation.result

import android.os.Bundle
import android.view.*
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.core.content.ContextCompat
import androidx.core.view.MenuProvider
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.perfect.height.R
import com.perfect.height.databinding.FragmentResultBinding
import com.perfect.height.presentation.adapter.ResultCountryAdapter
import com.perfect.height.utils.GENDER_MALE

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private val args: ResultFragmentArgs by navArgs()
    private val viewModel: ResultViewModel by viewModels()

    private lateinit var shorterAdapter: ResultCountryAdapter
    private lateinit var tallerAdapter: ResultCountryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.assignGender(args.myGender)
        viewModel.assignHeight(args.myHeight)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        initAdapter()

        requireActivity().addMenuProvider(object : MenuProvider {
            lateinit var rootMenu: Menu
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
                menuInflater.inflate(R.menu.result_menu, menu)
                rootMenu = menu
                setGenderIcon(menu[0])
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle the menu selection
                return when (menuItem.itemId) {
                    R.id.switchGenderMenuItem -> {
                        viewModel.switchGender()
                        chooseGender()
                        setGenderIcon(menuItem)
                        return true
                    }

                    // Back Button ID
                    (16908332) -> {
                        return findNavController().popBackStack()
                    }
                    else -> {
                        return true
                    }
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

    }


    private fun setupViews() {
        binding.tallestHeightTextview.setOnClickListener {
            binding.tallestResultCountryRecyclerview.visibility =
                if (viewModel.isTallestExpanded) GONE else VISIBLE
            viewModel.switchCollapseMode(true)
        }

        binding.shortestHeightTextview.setOnClickListener {
            binding.shortestResultCountryRecyclerview.visibility =
                if (viewModel.isShortestExpanded) GONE else VISIBLE
            viewModel.switchCollapseMode(false)
        }
    }

    private fun initAdapter() {
        viewModel.initAdapter()

        if (viewModel.shorterThanCountryHeights.isEmpty()) {
            binding.shortestHeightTextview.visibility = GONE
            binding.shortestResultCountryRecyclerview.visibility = GONE
        } else {
            binding.shortestHeightTextview.visibility = VISIBLE

            binding.shortestResultCountryRecyclerview.visibility =
                if (viewModel.isShortestExpanded) VISIBLE else GONE

        }
        if (viewModel.tallerThanCountryHeights.isEmpty()) {
            binding.tallestHeightTextview.visibility = GONE
            binding.tallestResultCountryRecyclerview.visibility = GONE
        } else {
            binding.tallestHeightTextview.visibility = VISIBLE
            binding.tallestResultCountryRecyclerview.visibility =
                if (viewModel.isTallestExpanded) VISIBLE else GONE
        }


        tallerAdapter = ResultCountryAdapter(viewModel.tallerThanCountryHeights)
        shorterAdapter = ResultCountryAdapter(viewModel.shorterThanCountryHeights)
        binding.shortestResultCountryRecyclerview.adapter = shorterAdapter
        binding.tallestResultCountryRecyclerview.adapter = tallerAdapter

    }

    private fun chooseGender() {
        initAdapter()
    }

    private fun setGenderIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return

        menuItem.icon =
            if (viewModel.gender == GENDER_MALE) ContextCompat.getDrawable(
                this.requireContext(),
                R.drawable.ic_female
            )
            else ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_male)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}