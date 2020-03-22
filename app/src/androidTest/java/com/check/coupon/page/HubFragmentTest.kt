package com.check.coupon.page

import android.content.Context
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.check.coupon.R
import com.check.coupon.repository.CouponRepository
import io.paperdb.Paper
import kotlinx.android.synthetic.main.hub_fragment.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HubFragmentTest {

    private lateinit var context: Context

    @Before
    fun initContext() {
        context = InstrumentationRegistry.getInstrumentation().targetContext
        Paper.init(context)
    }

    @Test
    fun testFragmentInit() {
        val hubPage = launchFragmentInContainer<HubFragment>()
        hubPage.recreate()
    }

    @Test
    fun testFragmentRecyclerView() {
        val hubPage = launchFragmentInContainer<HubFragment>()
        hubPage.recreate()
        onView(withId(R.id.offerItemList)).perform(click())
    }
}