package com.perfect.height.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.perfect.height.data.CountryDataSource.Companion.SHORTEST_HEIGHT_INDEX_FOR_MEN
import com.perfect.height.data.CountryDataSource.Companion.SHORTEST_HEIGHT_INDEX_FOR_WOMEN
import com.perfect.height.data.CountryDataSource.Companion.TALLEST_HEIGHT_INDEX_FOR_MEN
import com.perfect.height.data.CountryDataSource.Companion.TALLEST_HEIGHT_INDEX_FOR_WOMEN
import com.perfect.height.presentation.country.CountryViewModel
import com.perfect.height.utils.GENDER_FEMALE
import com.perfect.height.utils.GENDER_MALE
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test


class CountryViewModelTests {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Test
    fun testLayout_isLinearLayout(){
        // Default Case true
        val countryViewModel = CountryViewModel()
        countryViewModel.isLinearLayoutManager.observeForever{}
        assertEquals(countryViewModel.isLinearLayoutManager.value,true)
    }

    @Test
    fun testLayout_isGridLayoutAndNotLinearLayout(){
        // Default Case true
        val countryViewModel = CountryViewModel()
        countryViewModel.isLinearLayoutManager.observeForever{}
        assertEquals(countryViewModel.isLinearLayoutManager.value,true)
        countryViewModel.switchLayouts()
        assertEquals(countryViewModel.isLinearLayoutManager.value,false)
    }

    @Test
    fun testLayout_isCollapsed(){
        // Default Case false
        val countryViewModel = CountryViewModel()
        countryViewModel.isCollapsed.observeForever{}
        assertEquals(countryViewModel.isCollapsed.value,false)
    }

    @Test
    fun testLayout_notCollapsedAndisExpanded(){
        // Default Case false
        val countryViewModel = CountryViewModel()
        countryViewModel.isCollapsed.observeForever{}
        countryViewModel.switchCollapse()
        assertEquals(countryViewModel.isCollapsed.value,true)
    }

    @Test
    fun testGender_isMale(){
        // Default Case MALE
        val countryViewModel = CountryViewModel()
        countryViewModel.gender.observeForever{}
        assertEquals(countryViewModel.gender.value, GENDER_MALE)
    }

    @Test
    fun testGender_isFemale(){
        // Default Case MALE
        val countryViewModel = CountryViewModel()
        countryViewModel.gender.observeForever{}
        assertEquals(countryViewModel.gender.value, GENDER_MALE)
        countryViewModel.switchGender()
        assertEquals(countryViewModel.gender.value, GENDER_FEMALE)
    }

    @Test
    fun testList_filterByMaleGender(){
        // Default Case MALE
        val countryViewModel = CountryViewModel()
        countryViewModel.gender.observeForever{}
        countryViewModel.list.observeForever(){}
        assertEquals(countryViewModel.gender.value, GENDER_MALE)
        countryViewModel.chooseGender()
        assertEquals(countryViewModel.list.value!!.size, (SHORTEST_HEIGHT_INDEX_FOR_MEN - TALLEST_HEIGHT_INDEX_FOR_MEN + 1))
    }

    @Test
    fun testList_filterByFemaleGender(){
        // Default Case MALE
        val countryViewModel = CountryViewModel()
        countryViewModel.gender.observeForever{}
        countryViewModel.list.observeForever(){}
        assertEquals(countryViewModel.gender.value, GENDER_MALE)
        countryViewModel.switchGender()
        assertEquals(countryViewModel.gender.value, GENDER_FEMALE)
        countryViewModel.chooseGender()
        assertEquals(countryViewModel.list.value!!.size, (SHORTEST_HEIGHT_INDEX_FOR_WOMEN - TALLEST_HEIGHT_INDEX_FOR_WOMEN + 1))
    }


}