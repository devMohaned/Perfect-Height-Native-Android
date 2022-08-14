package com.perfect.height.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.perfect.height.data.CountryDataSource
import com.perfect.height.presentation.home.HeightViewModel
import com.perfect.height.presentation.result.ResultViewModel
import com.perfect.height.utils.GENDER_FEMALE
import com.perfect.height.utils.GENDER_MALE
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class ResultViewModelTests {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun testIfGender_IsMale() {// Default is Male
        val viewModel = ResultViewModel()
        viewModel.gender.observeForever {}
        Assert.assertEquals(GENDER_MALE, viewModel.gender.value)
    }

    @Test
    fun testIfGender_IsFemale() {// Default is Male
        val viewModel = ResultViewModel()
        viewModel.gender.observeForever {}
        viewModel.switchGender()
        Assert.assertEquals(GENDER_FEMALE, viewModel.gender.value)
    }

    @Test
    fun testIf_TallestIsCollapsed() { // Default is true
        val viewModel = ResultViewModel()
        viewModel.isTallestExpanded.observeForever {}
        Assert.assertEquals(true, viewModel.isTallestExpanded.value)
        viewModel.switchCollapseMode(true)
        Assert.assertEquals(false, viewModel.isTallestExpanded.value)
    }

    @Test
    fun testIf_ShortestIsCollapsed() { // Default is true
        val viewModel = ResultViewModel()
        viewModel.isShortestExpanded.observeForever {}
        Assert.assertEquals(true, viewModel.isShortestExpanded.value)
        viewModel.switchCollapseMode(false)
        Assert.assertEquals(false, viewModel.isShortestExpanded.value)
    }

    @Test
    fun test_AssigningHeight() { // Default is true
        val viewModel = ResultViewModel()
        viewModel.height.observeForever {}
        Assert.assertEquals(0f, viewModel.height.value)
        viewModel.assignHeight(175f)
        Assert.assertEquals(175f, viewModel.height.value)
    }

    @Test
    fun test_TallestAverage() { // Default is MALE
        val viewModel = ResultViewModel()
        viewModel.tallerThanList.observeForever {}
        viewModel.shorterThanList.observeForever {}
        viewModel.assignHeight(190f)
        viewModel.makeTallerList()
        viewModel.makeShorterList()
        Assert.assertEquals(
            viewModel.tallerThanList.value!!.size,
            (CountryDataSource.SHORTEST_HEIGHT_INDEX_FOR_MEN - CountryDataSource.TALLEST_HEIGHT_INDEX_FOR_MEN + 1)
        )
        Assert.assertEquals(
            viewModel.shorterThanList.value!!.size,
            0
        )
    }

    @Test
    fun test_shortestAverage() {
        val viewModel = ResultViewModel()
        viewModel.tallerThanList.observeForever {}
        viewModel.shorterThanList.observeForever {}
        viewModel.assignHeight(1f)
        viewModel.makeTallerList()
        viewModel.makeShorterList()
        Assert.assertEquals(
            viewModel.tallerThanList.value!!.size,
            0
        )
        Assert.assertEquals(
            viewModel.shorterThanList.value!!.size,
            (CountryDataSource.SHORTEST_HEIGHT_INDEX_FOR_MEN - CountryDataSource.TALLEST_HEIGHT_INDEX_FOR_MEN + 1)
        )

    }

    @Test
    fun test_MiddleAverage() {
        val viewModel = ResultViewModel()
        viewModel.tallerThanList.observeForever {}
        viewModel.shorterThanList.observeForever {}
        viewModel.assignHeight(167f)
        viewModel.makeTallerList()
        viewModel.makeShorterList()
        Assert.assertTrue(viewModel.tallerThanList.value!!.isNotEmpty())
        Assert.assertTrue(viewModel.shorterThanList.value!!.isNotEmpty())

    }


    @Test
    fun test_tallerThanAllCountryList(){
        val viewModel = ResultViewModel()
        viewModel.tallerThanCountryHeights.observeForever {}
        viewModel.shorterThanCountryHeights.observeForever {}
        viewModel.assignHeight(190f)
        viewModel.initAdapter()
        Assert.assertTrue(viewModel.shorterThanCountryHeights.value!!.isEmpty())
        Assert.assertTrue(viewModel.tallerThanCountryHeights.value!!.size > 0)
    }

    @Test
    fun test_shorterThanAllCountryList(){
        val viewModel = ResultViewModel()
        viewModel.tallerThanCountryHeights.observeForever {}
        viewModel.shorterThanCountryHeights.observeForever {}
        viewModel.assignHeight(1f)
        viewModel.initAdapter()
        Assert.assertTrue(viewModel.tallerThanCountryHeights.value!!.isEmpty())
        Assert.assertTrue(viewModel.shorterThanCountryHeights.value!!.size > 0)
    }

    @Test
    fun test_middleThanAllCountryList(){
        val viewModel = ResultViewModel()
        viewModel.tallerThanCountryHeights.observeForever {}
        viewModel.shorterThanCountryHeights.observeForever {}
        viewModel.assignHeight(167f)
        viewModel.initAdapter()
        Assert.assertTrue(viewModel.tallerThanCountryHeights.value!!.size > 0)
        Assert.assertTrue(viewModel.shorterThanCountryHeights.value!!.size > 0)
    }


}