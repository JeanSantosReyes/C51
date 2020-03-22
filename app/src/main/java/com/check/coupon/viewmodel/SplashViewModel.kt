package com.check.coupon.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.check.coupon.repository.CouponRepository
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

     var appReady:MutableLiveData<Boolean> = MutableLiveData()

     fun initializeRepository() {
        GlobalScope.launch(Main) {
            CouponRepository.coupon.initialize()
        }.invokeOnCompletion {
            appReady.value = true
        }
    }
}