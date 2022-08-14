package com.perfect.height.presentation.home

import android.app.Activity
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.perfect.height.MainActivity
import com.perfect.height.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class HeightInstrumentedTest {

    @Test
    fun testHeightsFragmentNavigation() {
        //setup
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        //Nav to Country Fragment
        onView(withId(R.id.viewMoreButton)).perform(ViewActions.click())
        //verify
        onView(withId(R.id.countryRecyclerview)).check(matches(isDisplayed()))
        onView(withId(R.id.switchCollapseMenuItem)).perform(ViewActions.click())
        onView(withId(R.id.switchCollapseMenuItem)).perform(ViewActions.click())
        onView(withId(R.id.switchGenderMenuItem)).perform(ViewActions.click())
        onView(withId(R.id.switchGenderMenuItem)).perform(ViewActions.click())
        onView(withId(R.id.switchLayoutMenuItem)).perform(ViewActions.click())

        pressBack()

        //verify again
        onView(withId(R.id.heightEditText)).check(matches(isDisplayed()))

        // Nav to Result Fragment
        onView(withId(R.id.heightEditText)).
        perform(ViewActions.typeText("40000")).perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.perfectHeightButton)).perform(ViewActions.click())
        onView(withText((R.string.view_result))).perform(ViewActions.click())

        // Verify Again (TALLEST HEIGHT)
        onView(withId(R.id.tallestHeightTextview)).check(matches(isDisplayed()))
        onView(withId(R.id.tallest_result_country_recyclerview)).check(matches(isDisplayed()))

        // Go back
        pressBack()
        //verify again
        onView(withId(R.id.heightEditText)).check(matches(isDisplayed()))

        // Nav to Result Fragment
        onView(withId(R.id.heightEditText))
            .perform(ViewActions.clearText()).perform(ViewActions.typeText("1")).perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.perfectHeightButton)).perform(ViewActions.click())
        onView(withText((R.string.view_result))).perform(ViewActions.click())

        // Verify Again (SHORTEST HEIGHT)
        onView(withId(R.id.shortestHeightTextview)).check(matches(isDisplayed()))
        onView(withId(R.id.shortest_result_country_recyclerview)).check(matches(isDisplayed()))


        // Go back
        pressBack()
        //verify again
        onView(withId(R.id.heightEditText)).check(matches(isDisplayed()))

        // Nav to Result Fragment
        onView(withId(R.id.heightEditText))
            .perform(ViewActions.clearText()).perform(ViewActions.typeText("169")).perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.perfectHeightButton)).perform(ViewActions.click())
        onView(withText((R.string.view_result))).perform(ViewActions.click())

        // Verify Again (AVERAGE HEIGHT)
        onView(withId(R.id.tallestHeightTextview)).check(matches(isDisplayed()))
        onView(withId(R.id.tallest_result_country_recyclerview)).check(matches(isDisplayed()))
        onView(withId(R.id.tallestHeightTextview)).perform(ViewActions.click())
        onView(withId(R.id.shortestHeightTextview)).check(matches(isDisplayed()))
        onView(withId(R.id.shortest_result_country_recyclerview)).check(matches(isDisplayed()))



    }
}