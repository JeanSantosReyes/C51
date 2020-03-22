package com.check.coupon.page

import android.content.Context
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.check.coupon.R
import io.paperdb.Paper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SplashFragmentTest {

    private lateinit var context: Context

    @Before
    fun initContext() {
        context = InstrumentationRegistry.getInstrumentation().targetContext
        Paper.init(context)
    }

    @Test
    fun testFragmentInit() {
        val splashPage = launchFragmentInContainer<SplashFragment>()
        splashPage.recreate()
    }

    @Test
    fun testSplashScreen() {
        val splashPage = launchFragmentInContainer<SplashFragment>()
        splashPage.recreate()
        GlobalScope.launch {
            onView(ViewMatchers.withId(R.id.LoginTextButton)).perform(click())
        }
    }

}