package com.check.coupon.di.module

import com.check.coupon.service.CouponApi
import com.check.coupon.util.Constants
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/***
 *
 *   Network module class for the dependency injection
 *
 */

@Module
class NetModule {

    @Singleton
    @Provides
    fun provideRetrofit(): CouponApi {
        val responseBuilder = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(responseBuilder))
            .build()
            .create(CouponApi::class.java)
    }
}