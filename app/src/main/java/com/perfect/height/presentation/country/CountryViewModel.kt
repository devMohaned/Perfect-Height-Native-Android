package com.perfect.height.presentation.country

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.perfect.height.data.CountryDataSource
import com.perfect.height.models.AverageCountryHeight
import com.perfect.height.presentation.adapter.AverageHeightAdapter
import com.perfect.height.utils.GENDER_FEMALE
import com.perfect.height.utils.GENDER_MALE

class CountryViewModel : ViewModel() {
    private val _isLinearLayoutManager: MutableLiveData<Boolean> = MutableLiveData()
    val isLinearLayoutManager: LiveData<Boolean>
        get() = _isLinearLayoutManager

    private val _isCollapsed: MutableLiveData<Boolean> = MutableLiveData()
    val isCollapsed: LiveData<Boolean>
        get() = _isCollapsed

    private val _gender: MutableLiveData<Int> = MutableLiveData()
    val gender: LiveData<Int>
        get() = _gender

    private val _list: MutableLiveData<List<AverageCountryHeight>> = MutableLiveData()
    val list: LiveData<List<AverageCountryHeight>>
        get() = _list


    private val _visitedPositions = mutableMapOf<Int, Boolean>()
    val visitedPositions: MutableMap<Int, Boolean>
        get() = _visitedPositions

    private  var _adapter: AverageHeightAdapter
    val adapter:AverageHeightAdapter
    get() = _adapter
    init {
        _list.value = mutableListOf<AverageCountryHeight>()
        _isLinearLayoutManager.value = true
        _isCollapsed.value = false
        _gender.value = GENDER_MALE
        _adapter = AverageHeightAdapter(
            list.value!!,
            isLinearLayoutManager.value!!, visitedPositions)

    }

    private var isAssigned = false
    fun assignGender(newGender: Int) {
        if (!isAssigned) _gender.value = newGender
        isAssigned = true
    }

    fun isMale(): Boolean {
        return _gender.value == GENDER_MALE
    }

    fun switchGender() {
        _gender.value = if (gender.value == GENDER_MALE)
            GENDER_FEMALE
        else
            GENDER_MALE
    }

    fun chooseGender() {
        _list.value = CountryDataSource.countryAverageCountryHeights.filter {
            if (isMale()) it.height.gender == GENDER_MALE
            else it.height.gender == GENDER_FEMALE
        }
    }

    fun switchLayouts() {
        _isLinearLayoutManager.value = !_isLinearLayoutManager.value!!
    }

    fun switchCollapse() {
        _isCollapsed.value = !_isCollapsed.value!!
    }

    fun updateAdapter(adapter: AverageHeightAdapter){
        _adapter = adapter
    }
}