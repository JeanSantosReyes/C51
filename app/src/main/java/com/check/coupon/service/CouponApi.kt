package com.check.coupon.service

import com.check.coupon.model.Coupon
import retrofit2.http.GET

interface CouponApi {
    @GET("/c51/coupons.php")
    suspend fun getCoupon(): Coupon
}