package com.check.coupon.repository

import com.check.coupon.di.component.DaggerNetworkComponent
import com.check.coupon.model.Offer
import com.check.coupon.service.CouponApi
import javax.inject.Inject

class CouponRepository {

    init {
        DaggerNetworkComponent.builder().build().inject(this)
    }

    companion object {
        lateinit var offerList:ArrayList<Offer>
    }

    // Inject network module
    @Inject
    lateinit var api: CouponApi

    suspend fun initialize() {
        offerList = api.getCoupon().offers as ArrayList<Offer>
    }

    fun getOffers():ArrayList<Offer> {
        return offerList
    }

    suspend fun refreshOfferList() {
        offerList.clear()
        offerList = api.getCoupon().offers as ArrayList<Offer>
    }

}