package com.perfect.height.presentation.result

import androidx.lifecycle.ViewModel
import com.perfect.height.data.CountryDataSource
import com.perfect.height.models.AverageCountryHeight
import com.perfect.height.models.CountryHeight
import com.perfect.height.utils.GENDER_FEMALE
import com.perfect.height.utils.GENDER_MALE

class ResultViewModel : ViewModel() {


    private var _gender: Int
    val gender: Int
        get() = _gender

    private var _height: Float
    val height: Float
        get() = _height

    private var _isTallestExpanded: Boolean
    val isTallestExpanded: Boolean
        get() = _isTallestExpanded
    private var _isShortestExpanded: Boolean
    val isShortestExpanded: Boolean
        get() = _isShortestExpanded

    private lateinit var _tallerThanList: List<AverageCountryHeight>
    val tallerThanList: List<AverageCountryHeight>
        get() = _tallerThanList

    private lateinit var _shorterThanList: List<AverageCountryHeight>
    val shorterThanList: List<AverageCountryHeight>
        get() = _shorterThanList

    private lateinit var _tallerThanCountryHeights: MutableList<CountryHeight>
    val tallerThanCountryHeights: MutableList<CountryHeight>
        get() = _tallerThanCountryHeights

    private lateinit var _shorterThanCountryHeights: MutableList<CountryHeight>
    val shorterThanCountryHeights: MutableList<CountryHeight>
        get() = _shorterThanCountryHeights

    init {
        _gender = GENDER_MALE
        _height = 0f
        _isTallestExpanded = true
        _isShortestExpanded = true
    }


    private var isGenderAssigned = false
    fun assignGender(newGender: Int) {
        if (!isGenderAssigned) _gender = newGender
        isGenderAssigned = true
    }

    fun switchGender() {
        if (gender == GENDER_MALE)
            _gender = GENDER_FEMALE
        else
            _gender = GENDER_MALE
    }

    private var isHeightAssigned = false
    fun assignHeight(newHeight: Float) {
        if (!isHeightAssigned) _height = newHeight
        isHeightAssigned = true
    }

    fun switchCollapseMode(isTallest: Boolean) {
        if (isTallest)
            _isTallestExpanded = !isTallestExpanded
        else
            _isShortestExpanded = !isShortestExpanded
    }


    fun initAdapter() {
        _tallerThanList = CountryDataSource.countryAverageCountryHeights.filter {
            height > it.height.height && it.height.gender == gender
        }

        _shorterThanList = CountryDataSource.countryAverageCountryHeights.filter {
            height < it.height.height && it.height.gender == gender
        }

        _tallerThanCountryHeights = mutableListOf()
        tallerThanList.forEach { averageCountryHeight ->
            averageCountryHeight.country.forEach {
                tallerThanCountryHeights.add(CountryHeight(it, averageCountryHeight.height.height))
            }
        }

        _shorterThanCountryHeights = mutableListOf()
        shorterThanList.forEach { averageCountryHeight ->
            averageCountryHeight.country.forEach {
                shorterThanCountryHeights.add(CountryHeight(it, averageCountryHeight.height.height))
            }
        }
    }

}