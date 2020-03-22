package com.check.coupon.repository

import android.util.Log
import com.check.coupon.di.component.DaggerNetworkComponent
import com.check.coupon.model.Offer
import com.check.coupon.service.CouponApi
import com.check.coupon.util.Constants
import io.paperdb.Paper
import java.lang.Exception
import javax.inject.Inject

class CouponRepository private constructor() {

    companion object {
        var coupon =  CouponRepository()
        var offerList:ArrayList<Offer> = ArrayList()

        fun getInstance(): CouponRepository {
            if (coupon == null)
                coupon = CouponRepository()
            return coupon
        }
    }

    init {
        DaggerNetworkComponent.builder().build().inject(this)
    }

    // Inject network module
    @Inject
    lateinit var api: CouponApi

    suspend fun initialize() {
        try {
            offerList = api.getCoupon().offers as ArrayList<Offer>
        } catch (e:Exception) {
            Log.d("Api Error","Error in remote source")
        }

        if(offerList.isNotEmpty())
            Paper.book().write(Constants.OFFER_CACHE,offerList)
    }

    fun getOffers():ArrayList<Offer> {
        // read data from the cache
        if(offerList.isEmpty()) {
            return if(Paper.book().contains(Constants.OFFER_CACHE)) {
                val result = Paper.book().read(Constants.OFFER_CACHE) as ArrayList<Offer>
                result
            } else {
                ArrayList()
            }
        }
        return offerList
    }

}