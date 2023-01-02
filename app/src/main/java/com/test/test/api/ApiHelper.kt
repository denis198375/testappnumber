package com.test.test.api

class ApiHelper (private val apiService: ApiService){
    fun getNumberText(number:String)=apiService.getNumberText(number);
    fun getNumberTextRandom(number:String)=apiService.getNumberTextRandom(number);
}