package com.check.coupon.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.check.coupon.model.Offer
import com.check.coupon.repository.CouponRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HubViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var offerList: MutableLiveData<List<Offer>> = MutableLiveData()

    fun getOfferList() {
        offerList.value = CouponRepository.single.getOffers()
    }

     fun refreshOfferList() {
        GlobalScope.launch(Dispatchers.Main) {
            CouponRepository.single.refreshOfferList()
        }.invokeOnCompletion {
            offerList.value = CouponRepository.single.getOffers()
        }
    }

}
