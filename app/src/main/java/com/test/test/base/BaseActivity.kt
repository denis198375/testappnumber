package com.test.test.base

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.test.test.MyApp
import com.test.test.R
import java.util.concurrent.Callable


abstract class BaseActivity(contentLayoutId: Int) : AppCompatActivity(contentLayoutId), BasicView {

   fun getNavCon():NavController{
     MyApp.controller= findNavController(R.id.nav_host_fragment)
   return MyApp.controller
}

    override fun showInternetError(callable: Callable<Void>, type: String) {
        TODO("Not yet implemented")
    }
    override fun startLoader() {
        TODO("Not yet implemented")
    }

    override fun stopLoader() {
        TODO("Not yet implemented")
    }

    override fun showError(text: String, error: String) {
        TODO("Not yet implemented")
    }

}