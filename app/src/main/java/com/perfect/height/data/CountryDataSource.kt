package com.perfect.height.data

import com.perfect.height.R
import com.perfect.height.models.AverageCountryHeight
import com.perfect.height.models.Country
import com.perfect.height.models.GenderHeight

class CountryDataSource {
    companion object {

        const val TALLEST_HEIGHT_INDEX_FOR_MEN = 0
        const val SHORTEST_HEIGHT_INDEX_FOR_MEN = 23
        const val TALLEST_HEIGHT_INDEX_FOR_WOMEN = 24
        const val SHORTEST_HEIGHT_INDEX_FOR_WOMEN = 43
         val countryAverageCountryHeights = listOf<AverageCountryHeight>(
            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_netherlands, "Netherlands"),
                ),
                GenderHeight(0, 184f)
            ),
            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_montenegro, "Montenegro")
                ),
                GenderHeight(0, 183f)
            ),
            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_estonia, "Estonia"),
                    Country(R.drawable.ic_denmark, "Denmark"),
                    Country(R.drawable.ic_bosnia_and_herzegovina, "Bosnia and Herzegovina"),
                ),
                GenderHeight(0, 182f)
            ),
            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_iceland, "Iceland"),
                    Country(R.drawable.ic_czech_republic, "Czechia"),
                    Country(R.drawable.ic_slovenia, "Slovenia"),
                    Country(R.drawable.ic_slovakia, "Slovakia"),
                    Country(R.drawable.ic_croatia, "Croatia"),
                ),
                GenderHeight(0, 181f)
            ),
            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_serbia, "Serbia"),
                    Country(R.drawable.ic_sweden, "Sweden"),
                    Country(R.drawable.ic_norway, "Norway"),
                    Country(R.drawable.ic_lithuania, "Lithuania"),
                    Country(R.drawable.ic_poland, "Poland"),
                    Country(R.drawable.ic_ukraine, "Ukraine"),
                    Country(R.drawable.ic_finland, "Finland"),
                    Country(R.drawable.ic_latvia, "Latvia"),
                    Country(R.drawable.ic_germany, "Germany"),
                    Country(R.drawable.ic_dominica, "Dominica"),
                ),
                GenderHeight(0, 180f)
            ),
            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_belgium, "Belgium"),
                    Country(R.drawable.ic_bermuda, "Bermuda"),
                    Country(R.drawable.ic_greece, "Greece"),
                    Country(R.drawable.ic_puerto_rico, "Puerto Rico"),
                    Country(R.drawable.ic_switzerland, "Switzerland"),
                    Country(R.drawable.ic_australia, "Australia"),
                    Country(R.drawable.ic_ireland, "Ireland"),
                ),
                GenderHeight(0, 179f)
            ),
            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_canada, "Canada"),
                    Country(R.drawable.ic_austria, "Austria"),
                    Country(R.drawable.ic_france, "France"),
                    Country(R.drawable.ic_antigua_and_barbuda, "Antigua and Barbuda"),
                    Country(R.drawable.ic_lebanon, "Lebanon"),
                    Country(R.drawable.ic_belarus, "Belarus"),
                    Country(R.drawable.ic_andorra, "Andorra"),
                    Country(R.drawable.ic_french_polynesia, "French Polynesia"),
                    Country(R.drawable.ic_cook_islands, "Cook Islands"),
                    Country(R.drawable.ic_luxembourg, "Luxembourg"),
                    Country(R.drawable.ic_united_kingdom, "United Kingdom"),
                    Country(R.drawable.ic_grenada, "Grenada"),
                    Country(R.drawable.ic_new_zealand, "New Zealand"),
                ),
                GenderHeight(0, 178f)
            ),
            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_romania, "Romania"),
                    Country(R.drawable.ic_niue, "Niue"),
                    Country(R.drawable.ic_united_states, "United States"),
                    Country(R.drawable.ic_american_samoa, "American Samoa"),
                ),
                GenderHeight(0, 177f)
            ),
            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_hungary, "Hungary"),
                    Country(R.drawable.ic_russia, "Russia"),
                    Country(R.drawable.ic_tokelau, "Tokelau"),
                    Country(R.drawable.ic_saint_lucia, "Saint Lucia"),
                    Country(R.drawable.ic_spain, "Spain"),
                    Country(R.drawable.ic_turkey, "Turkey"),
                ),
                GenderHeight(0, 176f)
            ),
            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_morocco, "Morocco"),
                    Country(R.drawable.ic_brazil, "Brazil"),
                    Country(R.drawable.ic_georgia, "Georgia"),
                    Country(R.drawable.ic_south_korea, "South Korea"),
                    Country(R.drawable.ic_senegal, "Senegal"),
                    Country(R.drawable.ic_iran, "Iran"),
                    Country(R.drawable.ic_tonga, "Tonga"),
                    Country(R.drawable.ic_china, "China"),
                ),
                GenderHeight(0, 175f)
            ),
            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_kuwait, "Kuwait"),
                    Country(R.drawable.ic_hong_kong, "Hong Kong"),
                    Country(R.drawable.ic_argentina, "Argentina"),
                    Country(R.drawable.ic_italy, "Italy"),
                    Country(R.drawable.ic_portugal, "Portugal"),
                    Country(R.drawable.ic_algeria, "Algeria"),
                    Country(R.drawable.ic_costa_rica, "Costa Rica"),
                    Country(R.drawable.ic_albania, "Albania"),
                    Country(R.drawable.ic_fiji, "Fiji"),
                ),
                GenderHeight(0, 174f)
            ),
            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_samoa, "Samoa"),
                    Country(R.drawable.ic_united_arab_emirates, "United Arab Emirates"),
                    Country(R.drawable.ic_bulgaria, "Bulgaria"),
                    Country(R.drawable.ic_taiwan, "Taiwan"),
                    Country(R.drawable.ic_singapore, "Singapore"),
                    Country(R.drawable.ic_mauritius, "Mauritius"),
                    Country(R.drawable.ic_egypt, "Egypt"),
                    Country(R.drawable.ic_venezuela, "Venezuela"),
                    Country(R.drawable.ic_chile, "Chile"),
                    Country(R.drawable.ic_qatar, "Qatar"),
                ),
                GenderHeight(0, 173f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_bahrain, "Bahrain"),
                    Country(R.drawable.ic_haiti, "Haiti"),
                    Country(R.drawable.ic_japan, "Japan"),
                ),
                GenderHeight(0, 172f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_colombia, "Colombia"),
                    Country(R.drawable.ic_thailand, "Thailand"),
                    Country(R.drawable.ic_tuvalu, "Tuvalu"),
                    Country(R.drawable.ic_cameroon, "Cameroon"),
                    Country(R.drawable.ic_sudan, "Sudan"),
                    Country(R.drawable.ic_chad, "Chad"),
                ),
                GenderHeight(0, 171f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_palau, "Palau"),
                    Country(R.drawable.ic_eritrea, "Eritrea"),
                    Country(R.drawable.ic_saudi_arabia, "Saudi Arabia"),
                    Country(R.drawable.ic_mexico, "Mexico"),
                    Country(R.drawable.ic_kiribati, "Kiribati"),
                    Country(R.drawable.ic_zimbabwe, "Zimbabwe"),
                    Country(R.drawable.ic_kenya, "Kenya"),
                    Country(R.drawable.ic_nigeria, "Nigeria"),
                ),
                GenderHeight(0, 170f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_ghana, "Ghana"),
                    Country(R.drawable.ic_nauru, "Nauru"),
                    Country(R.drawable.ic_micronesia, "Micronesia"),
                    Country(R.drawable.ic_south_africa, "South Africa"),
                ),
                GenderHeight(0, 169f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_malaysia, "Malaysia"),
                    Country(R.drawable.ic_vietnam, "Vietnam"),
                    Country(R.drawable.ic_ivory_coast, "Ivory Coast"),
                    Country(R.drawable.ic_bolivia, "Bolivia"),
                    Country(R.drawable.ic_afghanistan, "Afghanistan"),
                    Country(R.drawable.ic_democratic_republic_of_congo, "Congo (Dem. Republic)"),
                    Country(R.drawable.ic_ethiopia, "Ethiopia"),
                    Country(R.drawable.ic_maldives, "Maldives"),
                ),
                GenderHeight(0, 168f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_sri_lanka, "Sri Lanka"),
                    Country(R.drawable.ic_equatorial_guinea, "Equatorial Guinea"),
                    Country(R.drawable.ic_ecuador, "Ecuador"),
                    Country(R.drawable.ic_burundi, "Burundi"),
                    Country(R.drawable.ic_pakistan, "Pakistan"),
                ),
                GenderHeight(0, 167f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_brunei, "Brunei"),
                    Country(R.drawable.ic_burma, "Burma"),
                    Country(R.drawable.ic_india, "India"),
                    Country(R.drawable.ic_indonesia, "Indonesia"),
                ),
                GenderHeight(0, 166f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_cambodia, "Cambodia"),
                    Country(R.drawable.ic_madagascar, "Madagascar"),
                    Country(R.drawable.ic_philippines, "Philippines"),
                    Country(R.drawable.ic_bangladesh, "Bangladesh"),
                ),
                GenderHeight(0, 165f)
            ),


            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_nepal, "Nepal"),
                    Country(R.drawable.ic_guatemala, "Guatemala"),
                ),
                GenderHeight(0, 164f)
            ),
            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_yemen, "Yemen"),
                ),
                GenderHeight(0, 163f)
            ),
            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_laos, "Laos"),
                ),
                GenderHeight(0, 162f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_timor_leste, "Timor-Leste"),
                ),
                GenderHeight(0, 159f)
            ),

            // FEMALE!!!!!!!!!!!!!!!!
            // FEMALE!!!!!!!!!!!!!!!!
            // FEMALE!!!!!!!!!!!!!!!!
            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_netherlands, "Netherlands"),
                    Country(R.drawable.ic_montenegro, "Montenegro"),
                ),
                GenderHeight(1, 170f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_denmark, "Denmark"),
                ),
                GenderHeight(1, 169f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_estonia, "Estonia"),
                    Country(R.drawable.ic_iceland, "Iceland"),
                    Country(R.drawable.ic_czech_republic, "Czechia"),
                    Country(R.drawable.ic_serbia, "Serbia"),
                    Country(R.drawable.ic_latvia, "Latvia"),
                ),
                GenderHeight(1, 168f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_bosnia_and_herzegovina, "Bosnia and Herzegovina"),
                    Country(R.drawable.ic_slovenia, "Slovenia"),
                    Country(R.drawable.ic_slovakia, "Slovakia"),
                    Country(R.drawable.ic_croatia, "Croatia"),
                    Country(R.drawable.ic_sweden, "Sweden"),
                    Country(R.drawable.ic_lithuania, "Lithuania"),
                    Country(R.drawable.ic_dominica, "Dominica"),
                    Country(R.drawable.ic_cook_islands, "Cook Islands"),
                    Country(R.drawable.ic_niue, "Niue"),
                    Country(R.drawable.ic_american_samoa, "American Samoa"),
                ),
                GenderHeight(1, 167f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_norway, "Norway"),
                    Country(R.drawable.ic_ukraine, "Ukraine"),
                    Country(R.drawable.ic_finland, "Finland"),
                    Country(R.drawable.ic_germany, "Germany"),
                    Country(R.drawable.ic_bermuda, "Bermuda"),
                    Country(R.drawable.ic_austria, "Austria"),
                    Country(R.drawable.ic_belarus, "Belarus"),
                    Country(R.drawable.ic_french_polynesia, "French Polynesia"),
                    Country(R.drawable.ic_tokelau, "Tokelau"),
                    Country(R.drawable.ic_tonga, "Tonga"),
                ),
                GenderHeight(1, 166f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_poland, "Poland"),
                    Country(R.drawable.ic_greece, "Greece"),
                    Country(R.drawable.ic_australia, "Australia"),
                    Country(R.drawable.ic_canada, "Canada"),
                    Country(R.drawable.ic_antigua_and_barbuda, "Antigua and Barbuda"),
                    Country(R.drawable.ic_andorra, "Andorra"),
                    Country(R.drawable.ic_luxembourg, "Luxembourg"),
                    Country(R.drawable.ic_grenada, "Grenada"),
                    Country(R.drawable.ic_new_zealand, "New Zealand"),
                    Country(R.drawable.ic_saint_lucia, "Saint Lucia"),
                ),
                GenderHeight(1, 165f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_belgium, "Belgium"),
                    Country(R.drawable.ic_switzerland, "Switzerland"),
                    Country(R.drawable.ic_ireland, "Ireland"),
                    Country(R.drawable.ic_france, "France"),
                    Country(R.drawable.ic_united_kingdom, "United Kingdom"),
                    Country(R.drawable.ic_romania, "Romania"),
                    Country(R.drawable.ic_russia, "Russia"),
                    Country(R.drawable.ic_senegal, "Senegal"),
                    Country(R.drawable.ic_fiji, "Fiji"),
                    Country(R.drawable.ic_bulgaria, "Bulgaria"),
                ),
                GenderHeight(1, 164f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_puerto_rico, "Puerto Rico"),
                    Country(R.drawable.ic_lebanon, "Lebanon"),
                    Country(R.drawable.ic_united_states, "United States"),
                    Country(R.drawable.ic_georgia, "Georgia"),
                    Country(R.drawable.ic_south_korea, "South Korea"),
                    Country(R.drawable.ic_china, "China"),
                    Country(R.drawable.ic_samoa, "Samoa"),
                    Country(R.drawable.ic_tuvalu, "Tuvalu"),
                ),
                GenderHeight(1, 163f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_hungary, "Hungary"),
                    Country(R.drawable.ic_spain, "Spain"),
                    Country(R.drawable.ic_brazil, "Brazil"),
                    Country(R.drawable.ic_algeria, "Algeria"),
                    Country(R.drawable.ic_albania, "Albania"),
                    Country(R.drawable.ic_chad, "Chad"),
                ),
                GenderHeight(1, 162f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_turkey, "Turkey"),
                    Country(R.drawable.ic_morocco, "Morocco"),
                    Country(R.drawable.ic_iran, "Iran"),
                    Country(R.drawable.ic_argentina, "Argentina"),
                    Country(R.drawable.ic_italy, "Italy"),
                    Country(R.drawable.ic_portugal, "Portugal"),
                    Country(R.drawable.ic_singapore, "Singapore"),
                    Country(R.drawable.ic_kiribati, "Kiribati"),
                ),
                GenderHeight(1, 161f)
            ),


            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_kuwait, "Kuwait"),
                    Country(R.drawable.ic_hong_kong, "Hong Kong"),
                    Country(R.drawable.ic_costa_rica, "Costa Rica"),
                    Country(R.drawable.ic_united_arab_emirates, "United Arab Emirates"),
                    Country(R.drawable.ic_taiwan, "Taiwan"),
                    Country(R.drawable.ic_egypt, "Egypt"),
                    Country(R.drawable.ic_venezuela, "Venezuela"),
                    Country(R.drawable.ic_qatar, "Qatar"),
                    Country(R.drawable.ic_haiti, "Haiti"),
                    Country(R.drawable.ic_cameroon, "Cameroon"),
                    Country(R.drawable.ic_sudan, "Sudan"),
                    Country(R.drawable.ic_zimbabwe, "Zimbabwe"),
                ),
                GenderHeight(1, 160f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_mauritius, "Mauritius"),
                    Country(R.drawable.ic_thailand, "Thailand"),
                    Country(R.drawable.ic_palau, "Palau"),
                    Country(R.drawable.ic_kenya, "Kenya"),
                    Country(R.drawable.ic_ghana, "Ghana"),
                    Country(R.drawable.ic_micronesia, "Micronesia"),

                    ),
                GenderHeight(1, 159f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_bahrain, "Bahrain"),
                    Country(R.drawable.ic_japan, "Japan"),
                    Country(R.drawable.ic_colombia, "Colombia"),
                    Country(R.drawable.ic_saudi_arabia, "Saudi Arabia"),
                    Country(R.drawable.ic_nigeria, "Nigeria"),
                    Country(R.drawable.ic_nauru, "Nauru"),
                    Country(R.drawable.ic_south_africa, "South Africa"),
                    Country(R.drawable.ic_vietnam, "Vietnam"),
                    Country(R.drawable.ic_ivory_coast, "Ivory Coast"),
                    Country(R.drawable.ic_equatorial_guinea, "Equatorial Guinea"),

                    ),
                GenderHeight(1, 158f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_eritrea, "Eritrea"),
                    Country(R.drawable.ic_mexico, "Mexico"),
                    Country(R.drawable.ic_malaysia, "Malaysia"),
                    Country(R.drawable.ic_ethiopia, "Ethiopia"),

                    ),
                GenderHeight(1, 157f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_democratic_republic_of_congo, "Congo (Dem. Republic)"),

                    ),
                GenderHeight(1, 156f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_bolivia, "Bolivia"),
                    Country(R.drawable.ic_afghanistan, "Afghanistan"),
                    Country(R.drawable.ic_sri_lanka, "Sri Lanka"),
                    Country(R.drawable.ic_ecuador, "Ecuador"),
                    Country(R.drawable.ic_burundi, "Burundi"),
                    Country(R.drawable.ic_brunei, "Brunei"),
                    Country(R.drawable.ic_india, "India"),

                    ),
                GenderHeight(1, 155f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_maldives, "Maldives"),
                    Country(R.drawable.ic_pakistan, "Pakistan"),
                    Country(R.drawable.ic_burma, "Burma"),
                    Country(R.drawable.ic_indonesia, "Indonesia"),
                    Country(R.drawable.ic_cambodia, "Cambodia"),
                    Country(R.drawable.ic_philippines, "Philippines"),
                    Country(R.drawable.ic_yemen, "Yemen"),

                    ),
                GenderHeight(1, 154f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_madagascar, "Madagascar"),
                    Country(R.drawable.ic_laos, "Laos"),

                    ),
                GenderHeight(1, 153f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_bangladesh, "Bangladesh"),
                    Country(R.drawable.ic_nepal, "Nepal"),
                    Country(R.drawable.ic_timor_leste, "Timor-Leste"),

                    ),
                GenderHeight(1, 152f)
            ),

            AverageCountryHeight(
                listOf<Country>(
                    Country(R.drawable.ic_guatemala, "Guatemala"),
                ),
                GenderHeight(1, 151f)
            ),

            )
    }
}