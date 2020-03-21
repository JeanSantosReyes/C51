package com.check.coupon.repository

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class CouponRepositoryTest {

    @Test
    fun checkRepositoryInit() {
        var couponRepository = CouponRepository.couponrepository
        Assert.assertNotNull(couponRepository)
    }

    @Test
    fun checRepositoryApiTest() {
        var couponRepository = CouponRepository.couponrepository
        Assert.assertNotNull(couponRepository.api)
        GlobalScope.launch {
            var api = couponRepository.api.getCoupon().offers
            Assert.assertTrue(api.size>0)
        }
    }

}