package com.perfect.height.presentation.country

import androidx.lifecycle.ViewModel
import com.perfect.height.data.CountryDataSource
import com.perfect.height.models.AverageCountryHeight
import com.perfect.height.presentation.adapter.AverageHeightAdapter
import com.perfect.height.utils.GENDER_FEMALE
import com.perfect.height.utils.GENDER_MALE

class CountryViewModel : ViewModel() {
    private var _isLinearLayoutManager: Boolean = true
    val isLinearLayoutManager: Boolean
        get() = _isLinearLayoutManager

    private var _isCollapsed: Boolean = false
    val isCollapsed: Boolean
        get() = _isCollapsed

    private var _gender: Int = GENDER_MALE
    private val gender: Int
        get() = _gender

    private var _list: List<AverageCountryHeight>
    private val list: List<AverageCountryHeight>
    get() = _list

    private lateinit var _adapter : AverageHeightAdapter
    val adapter: AverageHeightAdapter
    get() = _adapter

    private val _visitedPositions = mutableMapOf<Int, Boolean>()
    private val visitedPositions
    get() = _visitedPositions


    init {
        _list = mutableListOf<AverageCountryHeight>()
    }

    fun initAdapter(){
        _adapter = AverageHeightAdapter(list,
            isLinearLayoutManager, visitedPositions)
    }

    private var isAssigned = false
    fun assignGender(newGender: Int){
        if(!isAssigned) _gender = newGender
        isAssigned = true
    }
    fun isMale():Boolean{
       return _gender == GENDER_MALE
    }
    fun switchGender() {
        _gender = if (gender == GENDER_MALE)
            GENDER_FEMALE
        else
            GENDER_MALE
    }

    fun chooseGender() {
        _list = CountryDataSource.countryAverageCountryHeights.filter {
            if (isMale()) it.height.gender == GENDER_MALE
            else it.height.gender == GENDER_FEMALE
        }
    }

    fun switchLayouts(){
        _isLinearLayoutManager = !_isLinearLayoutManager
    }

    fun switchCollapse(){
        _isCollapsed = !_isCollapsed
    }
}