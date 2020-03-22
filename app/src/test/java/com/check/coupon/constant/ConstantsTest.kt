package com.check.coupon.constant

import com.check.coupon.util.Constants
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ConstantsTest {

    @Test
    fun checkConstantsTest() {
        var constant = Constants()
        Assert.assertNotNull(constant)
        Assert.assertTrue(Constants.BASE_URL == "https://www.spkdroid.com")
        Assert.assertTrue(Constants.OFFER_CACHE == "offer_db")
    }


}