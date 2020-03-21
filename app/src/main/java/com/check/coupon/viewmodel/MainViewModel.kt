package com.check.coupon.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.check.coupon.model.Offer
import com.check.coupon.repository.CouponRepository
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
  //  var offerList: MutableLiveData<List<Offer>> = MutableLiveData()
     var appReady:MutableLiveData<Boolean> = MutableLiveData()

     fun initializeRepository() {
        GlobalScope.launch(Main) {
            CouponRepository.single.initialize()
        }.invokeOnCompletion {
            appReady.value = true
        }
    }

}
