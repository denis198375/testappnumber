package com.test.test.base

import com.test.test.api.ApiHelper
import com.test.test.model.NumberMessageText
import retrofit2.Response

class MainRepository(private val apiHelper: ApiHelper) {

    fun getNumberText(num:String):io.reactivex.Observable<Response<NumberMessageText>>{
        return apiHelper.getNumberText(num)
    }
    fun getNumberTextRandom(num:String):io.reactivex.Observable<Response<NumberMessageText>>{
        return apiHelper.getNumberTextRandom(num)
    }
}