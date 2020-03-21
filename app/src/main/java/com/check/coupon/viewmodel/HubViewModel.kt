package com.check.coupon.viewmodel

import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.check.coupon.model.Offer
import com.check.coupon.repository.CouponRepository


class HubViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var offerList: MutableLiveData<List<Offer>> = MutableLiveData()

    fun getOfferList() {
        offerList.value = CouponRepository.couponrepository.getOffers()
    }

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo.isConnected
    }

}
