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
        var single =  CouponRepository()
        var offerList:ArrayList<Offer> = ArrayList()
        fun getInstance(): CouponRepository {
            if (single == null)
                single = CouponRepository()
            return single
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
            if(offerList.isNotEmpty())
                Paper.book().write(Constants.OFFER_CACHE,offerList)
        } catch (e:Exception) {
            Log.d("Api Error","Error in remote source")
        }


    }

    fun getOffers():ArrayList<Offer> {
        // read data from the cache
        if(offerList.isEmpty()) {
            return Paper.book().read(Constants.OFFER_CACHE) as ArrayList<Offer>
        }
        return offerList
    }

    suspend fun refreshOfferList() {
        offerList.clear()
        offerList = api.getCoupon().offers as ArrayList<Offer>
    }
}