package com.test.test.fragment.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.test.test.base.MainRepository
import com.test.test.model.NumberMessageText
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class ViewModelOne(private val mainRepository: MainRepository) : ViewModel() {
    private var getNumberText = MutableLiveData<Response<NumberMessageText>>()
    private var getNumberTextRandom = MutableLiveData<Response<NumberMessageText>>()
    private val compositeDisposable = CompositeDisposable()
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun clear(){
        getNumberText = MutableLiveData<Response<NumberMessageText>>()
        getNumberTextRandom = MutableLiveData<Response<NumberMessageText>>()
       // compositeDisposable.dispose()
    }

    fun getNumberText(num: String): LiveData<Response<NumberMessageText>> {
        compositeDisposable.add(
            mainRepository.getNumberText(num)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    getNumberText.postValue(it)
                }, { throwable ->

                    Log.d("http-error", throwable.message.toString())
                    //login.setValue(Resource.error("Something Went Wrong", null))
                })
        )
        return getNumberText
    }

    fun getNumberTextRandom(num: String): LiveData<Response<NumberMessageText>> {
        compositeDisposable.add(
            mainRepository.getNumberTextRandom(num)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    getNumberTextRandom.postValue(it)
                }, { throwable ->

                    Log.d("http-error", throwable.message.toString())
                    //login.setValue(Resource.error("Something Went Wrong", null))
                })
        )
        return getNumberTextRandom
    }

}