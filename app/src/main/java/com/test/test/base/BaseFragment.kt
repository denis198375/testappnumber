package com.test.test.base

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.test.test.base.BaseActivity

open class BaseFragment(layoutId: Int) : Fragment(layoutId) {
    lateinit var mainActivity: BaseActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) {
            mainActivity = context
        }
    }

fun getNavCon():NavController{
  return  mainActivity.getNavCon()
}


}