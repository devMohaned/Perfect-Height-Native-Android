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
import androidx.lifecycle.Observer
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

        viewModel.gender.observe(viewLifecycleOwner, Observer { newGender ->
            handleRecyclerViewStates()
        })

        viewModel.isTallestExpanded.observe(viewLifecycleOwner, Observer { isTallestExpanded ->
            binding.tallestResultCountryRecyclerview.visibility =
                if (isTallestExpanded) VISIBLE else GONE
        })

        viewModel.isShortestExpanded.observe(viewLifecycleOwner, Observer { isShortestExpanded ->
            binding.shortestResultCountryRecyclerview.visibility =
                if (isShortestExpanded) VISIBLE else GONE

        })

        viewModel.tallerThanCountryHeights.observe(viewLifecycleOwner, Observer {
            tallerAdapter = ResultCountryAdapter(it)
            binding.tallestResultCountryRecyclerview.adapter = tallerAdapter

        })

        viewModel.shorterThanCountryHeights.observe(viewLifecycleOwner, Observer {
            shorterAdapter = ResultCountryAdapter(it)
            binding.shortestResultCountryRecyclerview.adapter = shorterAdapter
        })


    }


    private fun setupViews() {
        binding.tallestHeightTextview.setOnClickListener {
            viewModel.switchCollapseMode(true)
        }

        binding.shortestHeightTextview.setOnClickListener {
            viewModel.switchCollapseMode(false)
        }
    }

    private fun handleRecyclerViewStates() {
        viewModel.initAdapter()

        if (viewModel.shorterThanCountryHeights.value!!.isEmpty()) {
            binding.shortestHeightTextview.visibility = GONE
            binding.shortestResultCountryRecyclerview.visibility = GONE
        } else {
            binding.shortestHeightTextview.visibility = VISIBLE

            binding.shortestResultCountryRecyclerview.visibility =
                if (viewModel.isShortestExpanded.value!!) VISIBLE else GONE

        }
        if (viewModel.tallerThanCountryHeights.value!!.isEmpty()) {
            binding.tallestHeightTextview.visibility = GONE
            binding.tallestResultCountryRecyclerview.visibility = GONE
        } else {
            binding.tallestHeightTextview.visibility = VISIBLE
            binding.tallestResultCountryRecyclerview.visibility =
                if (viewModel.isTallestExpanded.value!!) VISIBLE else GONE
        }


    }

    private fun chooseGender() {
    }

    private fun setGenderIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return

        menuItem.icon =
            if (viewModel.gender.value!! == GENDER_MALE) ContextCompat.getDrawable(
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