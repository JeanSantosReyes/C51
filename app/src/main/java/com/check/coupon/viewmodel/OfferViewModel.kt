package com.check.coupon.viewmodel

import androidx.lifecycle.ViewModel
import com.check.coupon.model.Offer
import com.check.coupon.repository.CouponRepository

class OfferViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    fun findOfferById(offerId:String): Offer {
        return CouponRepository.coupon.getOffers().first {
            it.offerId == offerId
        }
    }
}