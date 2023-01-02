package com.test.test.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.test.api.ApiHelper
import com.test.test.fragment.viewmodel.ViewModelOne

class ViewModelFactory (private val apiHelper: ApiHelper):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       if (modelClass.isAssignableFrom(ViewModelOne::class.java))
           return ViewModelOne(MainRepository(apiHelper)) as T
       throw java.lang.IllegalArgumentException("")
    }

}