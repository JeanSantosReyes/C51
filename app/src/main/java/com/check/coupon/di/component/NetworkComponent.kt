package com.check.coupon.di.component

import com.check.coupon.di.module.NetModule
import com.check.coupon.repository.CouponRepository
import dagger.Component
import javax.inject.Singleton

/**
 *
 *  Network component interface for the di module
 *
 */

@Singleton
@Component(modules = [NetModule::class])
interface NetworkComponent {
    fun inject(apiService: CouponRepository)
}