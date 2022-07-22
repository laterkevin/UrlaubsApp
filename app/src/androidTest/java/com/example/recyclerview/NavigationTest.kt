package com.example.recyclerview

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.recyclerview.ui.HomeFragment
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class NavigationTest {

    lateinit var navController: TestNavHostController
    lateinit var offerListScenario: FragmentScenario<HomeFragment>

    @Before
    fun setup() {
        // Test Navcontroller wird bereitgestellt
        navController = TestNavHostController(ApplicationProvider.getApplicationContext())

        // Das HomeFragment wird in die MainActivity geladen
        offerListScenario = launchFragmentInContainer<HomeFragment>(themeResId = R.style.Theme_RecyclerView)

        // Der NavGraph in den NavController geladen und der NavController ins Fragment
        offerListScenario.onFragment {
            navController.setGraph(R.navigation.nav_graph)
            Navigation.setViewNavController(it.requireView(), navController)
        }
    }

    @Test
    fun onElementTenClickNavigateToOffer() {

        // GIVEN - RecyclerView with offers

        // WHEN - klick on offer nr 10

        onView(withId(R.id.recyclerViewHome))
            .perform(
                RecyclerViewActions
                    .actionOnItemAtPosition<RecyclerView.ViewHolder>(10, click())
            )

        // THEN - NavController navigates to DetailFragment
        Assert.assertEquals(navController.currentDestination?.id, R.id.detailFragment)
    }

    @Test
    fun onElementTwoNavigateToOffer() {

        // GIVEN - RecyclerView with offers

        // WHEN - klick on offer nr 2

        onView(withId(R.id.recyclerViewHome))
            .perform(
                RecyclerViewActions
                    .actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click())
            )

        // THEN - NavController navigates to DetailFragment
        Assert.assertEquals(navController.currentDestination?.id, R.id.detailFragment)
    }
}
