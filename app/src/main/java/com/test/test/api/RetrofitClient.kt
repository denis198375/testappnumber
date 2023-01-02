package com.test.test.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.test.test.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitClient {
    //Test
    const val BASE_URL_DEV = "http://numbersapi.com/"
    //Prod
    const val BASE_URL_PROD = "http://numbersapi.com/"
    object ServiceBuilder {
        private val interceptor: HttpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        private var gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        private var client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

        private val retrofit = Retrofit.Builder()
            .baseUrl(if(BuildConfig.DEBUG) BASE_URL_DEV else BASE_URL_PROD)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
            .create(ApiService::class.java)

        fun buildService(): ApiService {
            return retrofit
        }
    }
}