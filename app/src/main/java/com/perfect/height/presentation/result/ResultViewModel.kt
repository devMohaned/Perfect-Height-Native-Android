package com.perfect.height.presentation.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.perfect.height.data.CountryDataSource
import com.perfect.height.models.AverageCountryHeight
import com.perfect.height.models.CountryHeight
import com.perfect.height.utils.GENDER_FEMALE
import com.perfect.height.utils.GENDER_MALE

class ResultViewModel : ViewModel() {


    private val _gender: MutableLiveData<Int> = MutableLiveData()
    val gender: LiveData<Int>
        get() = _gender

    private val _height: MutableLiveData<Float> = MutableLiveData()
    val height: LiveData<Float>
        get() = _height

    private val _isTallestExpanded: MutableLiveData<Boolean> = MutableLiveData()
    val isTallestExpanded: LiveData<Boolean>
        get() = _isTallestExpanded
    private val _isShortestExpanded: MutableLiveData<Boolean> = MutableLiveData()
    val isShortestExpanded: LiveData<Boolean>
        get() = _isShortestExpanded

    private val _tallerThanList: MutableLiveData<List<AverageCountryHeight>> = MutableLiveData()
    val tallerThanList: LiveData<List<AverageCountryHeight>>
        get() = _tallerThanList

    private val _shorterThanList: MutableLiveData<List<AverageCountryHeight>> = MutableLiveData()
    val shorterThanList: LiveData<List<AverageCountryHeight>>
        get() = _shorterThanList

    private val _tallerThanCountryHeights: MutableLiveData<MutableList<CountryHeight>> = MutableLiveData()
    val tallerThanCountryHeights: LiveData<MutableList<CountryHeight>>
        get() = _tallerThanCountryHeights

    private val _shorterThanCountryHeights: MutableLiveData<MutableList<CountryHeight>> = MutableLiveData()
    val shorterThanCountryHeights: LiveData<MutableList<CountryHeight>>
        get() = _shorterThanCountryHeights

    init {
        _gender.value = GENDER_MALE
        _height.value = 0f
        _isTallestExpanded.value = true
        _isShortestExpanded.value = true
    }


    private var isGenderAssigned = false
    fun assignGender(newGender: Int) {
        if (!isGenderAssigned) _gender.value = newGender
        isGenderAssigned = true
    }

    fun switchGender() {
        if (gender.value == GENDER_MALE)
            _gender.value = GENDER_FEMALE
        else
            _gender.value = GENDER_MALE
    }

    private var isHeightAssigned = false
    fun assignHeight(newHeight: Float) {
        if (!isHeightAssigned) _height.value = newHeight
        isHeightAssigned = true
    }

    fun switchCollapseMode(isTallest: Boolean) {
        if (isTallest)
            _isTallestExpanded.value = !isTallestExpanded.value!!
        else
            _isShortestExpanded.value = !isShortestExpanded.value!!
    }


    fun initAdapter() {
        _tallerThanList.value = CountryDataSource.countryAverageCountryHeights.filter {
            height.value!! > it.height.height && it.height.gender == gender.value
        }

        _shorterThanList.value = CountryDataSource.countryAverageCountryHeights.filter {
            height.value!! < it.height.height && it.height.gender == gender.value
        }

        _tallerThanCountryHeights.value = mutableListOf()
        tallerThanList.value!!.forEach { averageCountryHeight ->
            averageCountryHeight.country.forEach {
                tallerThanCountryHeights.value!!.add(CountryHeight(it, averageCountryHeight.height.height))
            }
        }

        _shorterThanCountryHeights.value = mutableListOf()
        shorterThanList.value!!.forEach { averageCountryHeight ->
            averageCountryHeight.country.forEach {
                shorterThanCountryHeights.value!!.add(CountryHeight(it, averageCountryHeight.height.height))
            }
        }
    }

}