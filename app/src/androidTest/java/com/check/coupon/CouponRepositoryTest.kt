package com.check.coupon

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.check.coupon.repository.CouponRepository
import io.paperdb.Paper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CouponRepositoryTest {

    private lateinit var context: Context
    private lateinit var couponRepository: CouponRepository

    @Before
    fun initContext() {
        context = InstrumentationRegistry.getInstrumentation().targetContext
        couponRepository = CouponRepository.coupon
        Paper.init(context)
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.check.coupon", appContext.packageName)
    }

    @Test
    fun couponRepositoryTest() {
        GlobalScope.launch {
            couponRepository.initialize()
        }
        assertTrue(couponRepository.getOffers().size>0)
    }

    @Test
    fun couponRepositoryApiTest() {
        GlobalScope.launch {
            couponRepository.initialize()
            assertNotNull(couponRepository.api.getCoupon().batchId)
        }
    }

    @Test
    fun couponRepositoryApiOfferTest() {
        GlobalScope.launch {
            couponRepository.initialize()
            assertNotNull(couponRepository.api.getCoupon().offers)
        }
    }


}
