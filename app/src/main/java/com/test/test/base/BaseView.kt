package com.test.test.base

import java.util.concurrent.Callable

interface BasicView {
    fun showError(text: String, error: String)
    fun showInternetError(callable: Callable<Void>, type: String)
    fun startLoader()
    fun stopLoader()
}