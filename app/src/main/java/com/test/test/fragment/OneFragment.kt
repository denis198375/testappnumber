package com.test.test.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.test.MyApp
import com.test.test.R
import com.test.test.api.ApiHelper
import com.test.test.api.RetrofitClient.ServiceBuilder.buildService
import com.test.test.base.BaseFragment
import com.test.test.base.ViewModelFactory
import com.test.test.bd.AppDatabase
import com.test.test.bd.DbNumber
import com.test.test.databinding.FragmentOneBinding
import com.test.test.fragment.adapter.NumberTextAdapter
import com.test.test.fragment.adapter.NumberTextAdapter.OnClickListener
import com.test.test.fragment.viewmodel.ViewModelOne
import com.test.test.model.NumberMessageText


class OneFragment : BaseFragment(R.layout.fragment_one) {
    private lateinit var binding: FragmentOneBinding
    private lateinit var viewModel: ViewModelOne
    private lateinit var numberTextAdapter: NumberTextAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOneBinding.inflate(inflater)
        setClick()
        getDbNumber()
        setupViewModel()
        return binding.root
    }

    private fun setClick() {
        binding.buttonEnter.setOnClickListener {
            getNumberText(binding.editTextNumber.text.toString())
        }
        binding.buttonRandom.setOnClickListener{
            getNumberTextRandom("math")
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            requireActivity(),
            ViewModelFactory(ApiHelper(buildService()))
        )[ViewModelOne::class.java]
        viewModel.clear()
    }

    private fun getNumberText(num: String) {
        viewModel.getNumberText(num).observe(viewLifecycleOwner) { authDataResource ->
            when (authDataResource.code()) {
                200 -> {

                    val bundle = Bundle()
                    setDb(authDataResource.body()!!)
                    bundle.putString("num", authDataResource.body()!!.number)
                    bundle.putString("text", authDataResource.body()!!.text)
                    getNavCon().navigate(R.id.action_oneFragment_to_towFragment, bundle)
                    viewModel.clear()

                }
                500 -> {
                    Toast.makeText(context, getString(R.string.еуче_10), Toast.LENGTH_SHORT).show()
                }
                422, 404 -> {
                    Toast.makeText(context, getString(R.string.еуче_10), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun getNumberTextRandom(num: String) {
        viewModel.getNumberTextRandom(num).observe(viewLifecycleOwner) { authDataResource ->
            when (authDataResource.code()) {
                200 -> {

                    val bundle = Bundle()
                    setDb(authDataResource.body()!!)
                    bundle.putString("num", authDataResource.body()!!.number)
                    bundle.putString("text", authDataResource.body()!!.text)
                    getNavCon().navigate(R.id.action_oneFragment_to_towFragment, bundle)
                    viewModel.clear()

                }
                500 -> {
                    Toast.makeText(context, getString(R.string.еуче_10), Toast.LENGTH_SHORT).show()
                }
                422, 404 -> {
                    Toast.makeText(context, getString(R.string.еуче_10), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun setDb(numberMessageText: NumberMessageText) {

        val db: AppDatabase = MyApp.getInstance().getDatabase()
        val numberDao = db.numberDao()
        val bdNumber = DbNumber()
        bdNumber.id = System.currentTimeMillis()
        bdNumber.numberText = numberMessageText.text
        bdNumber.number = numberMessageText.number
        numberDao.insert(bdNumber)
    }

    private fun getDbNumber() {

        val db: AppDatabase = MyApp.getInstance().database
        val numberDao = db.numberDao()
        val listHistory = numberDao.all

        numberTextAdapter = NumberTextAdapter(
            listHistory
        )
        binding.listHistory.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.listHistory.adapter = numberTextAdapter

        numberTextAdapter.setOnClickListener(object : OnClickListener {
            override fun onClick(position: Int) {
                val bundle = Bundle()
                bundle.putString("num", listHistory[position].number)
                bundle.putString("text", listHistory[position].numberText)
                getNavCon().navigate(R.id.action_oneFragment_to_towFragment, bundle)
            }
        })
    }

}