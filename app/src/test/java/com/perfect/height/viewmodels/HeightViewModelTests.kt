package com.perfect.height.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.perfect.height.presentation.home.HeightViewModel
import com.perfect.height.utils.GENDER_FEMALE
import com.perfect.height.utils.GENDER_MALE
import org.junit.Assert.assertEquals
import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class HeightViewModelTests  {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun testIfGender_IsMale(){
        val viewModel = HeightViewModel()
        viewModel.gender.observeForever {}
        viewModel.updateGender(GENDER_MALE)
        assertEquals(GENDER_MALE, viewModel.gender.value)


    }
    @Test
    fun testIfGender_IsFemale(){
        val viewModel = HeightViewModel()
        viewModel.gender.observeForever {}
        viewModel.updateGender(GENDER_FEMALE)
        assertEquals(GENDER_FEMALE, viewModel.gender.value)

    }

    @Test
    fun testTallestHeight(){
        val viewModel = HeightViewModel()
        viewModel.result.observeForever{}
        viewModel.performPerfection(200f,viewModel.gender.value!!)
        assertTrue(viewModel.result.value!!.contains("tallest"))


        viewModel.performPerfection(1f,viewModel.gender.value!!)
        assertTrue(viewModel.result.value!!.contains("shortest"))

        viewModel.performPerfection(165f,viewModel.gender.value!!)
        assertTrue(viewModel.result.value!!.contains("middle"))
    }

    @Test
    fun testShortestHeight(){
        val viewModel = HeightViewModel()
        viewModel.result.observeForever{}
        viewModel.performPerfection(1f,viewModel.gender.value!!)
        assertTrue(viewModel.result.value!!.contains("shortest"))


    }

    @Test
    fun testMiddleHeight(){
        val viewModel = HeightViewModel()
        viewModel.result.observeForever{}
        viewModel.performPerfection(165f,viewModel.gender.value!!)
        assertTrue(viewModel.result.value!!.contains("middle"))
    }
}