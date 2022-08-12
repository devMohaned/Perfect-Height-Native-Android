package com.perfect.height.presentation.home

import androidx.lifecycle.ViewModel
import com.perfect.height.data.CountryDataSource
import com.perfect.height.data.CountryDataSource.Companion.SHORTEST_HEIGHT_INDEX_FOR_MEN
import com.perfect.height.data.CountryDataSource.Companion.SHORTEST_HEIGHT_INDEX_FOR_WOMEN
import com.perfect.height.data.CountryDataSource.Companion.TALLEST_HEIGHT_INDEX_FOR_MEN
import com.perfect.height.data.CountryDataSource.Companion.TALLEST_HEIGHT_INDEX_FOR_WOMEN
import com.perfect.height.utils.GENDER_MALE

class HeightViewModel : ViewModel() {
    private var _result: String
    val result: String
        get() = _result

    private var _gender: Int
    val gender: Int
        get() = _gender

    init {
        _gender = GENDER_MALE // DEFAULT
        _result = ""
    }


    fun performPerfection(heightInCm: Float, gender: Int) {
        val tallestAverageForMen =
            CountryDataSource.countryAverageCountryHeights[TALLEST_HEIGHT_INDEX_FOR_MEN].height.height
        val shortestAverageForMen =
            CountryDataSource.countryAverageCountryHeights[SHORTEST_HEIGHT_INDEX_FOR_MEN].height.height
        val tallestAverageForWomen =
            CountryDataSource.countryAverageCountryHeights[TALLEST_HEIGHT_INDEX_FOR_WOMEN].height.height
        val shortestAverageForWomen =
            CountryDataSource.countryAverageCountryHeights[SHORTEST_HEIGHT_INDEX_FOR_WOMEN].height.height

        if (gender == GENDER_MALE) {
            _result = if (heightInCm >= tallestAverageForMen) {
                "You are taller than the tallest average of male"// Tallest Male
            } else if (heightInCm < shortestAverageForMen) {
                "Sadly, You are shorter than the shortest average male" // Shortest Male
            } else {
                // In Between
                "You're in the middle, ${getRatio(heightInCm, gender)}"
            }
        } else {
            _result = if (heightInCm >= tallestAverageForWomen) {
                "You are taller than the highest average of female"// Tallest Male
            } else if (heightInCm < shortestAverageForWomen) {
                "Sadly, You are shorter than the lowest average female" // Shortest Male
            } else {
                // In Between
                "You're in the middle, ${getRatio(heightInCm, gender)}"
            }
        }
    }

    private fun getRatio(heightInCm: Float, gender: Int): String {
        var beg =
            if (gender == GENDER_MALE) TALLEST_HEIGHT_INDEX_FOR_MEN else TALLEST_HEIGHT_INDEX_FOR_WOMEN
        val end =
            if (gender == GENDER_MALE) SHORTEST_HEIGHT_INDEX_FOR_MEN else SHORTEST_HEIGHT_INDEX_FOR_WOMEN
        var result = ""
        var tallerThan = 0
        var shorterThan = 0
        while (beg <= end) {
            if (heightInCm >= CountryDataSource.countryAverageCountryHeights[beg].height.height)
                tallerThan++
            else
                shorterThan++
            beg++
        }
        result += if (tallerThan != 0) "taller than $tallerThan countries" else "not taller than any country record"
        result += if (shorterThan == 0) "not shorter than any country's average record"
        else if (shorterThan != 0 && tallerThan != 0) " and shorter than average of $shorterThan countries"
        else " shorter than average of $shorterThan countries"
        return result
    }



    fun updateGender(gender: Int) {
        _gender = gender
    }
}