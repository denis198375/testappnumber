package com.test.test.api


import com.test.test.model.NumberMessageText
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*

interface ApiService {


    @Headers("Content-Type: application/json")
    @GET("{patch}")
    fun getNumberText(
        @Path("patch") patch: String,
    ): Observable<Response<NumberMessageText>>

    @Headers("Content-Type: application/json")
    @GET("random/{patch}")
    fun getNumberTextRandom(
        @Path("patch") patch: String,
    ): Observable<Response<NumberMessageText>>

}