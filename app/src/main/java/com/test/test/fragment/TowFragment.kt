package com.test.test.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.test.base.BaseFragment
import com.test.test.R
import com.test.test.databinding.FragmentTowBinding


class TowFragment : BaseFragment(R.layout.fragment_tow) {
    private lateinit var binding: FragmentTowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTowBinding.inflate(inflater)
        // Inflate the layout for this fragment
        initForm()
        initClick()
        return binding.root
    }

    private fun initClick() {
        binding.btnBack.setOnClickListener{getNavCon().popBackStack()}

    }

    private fun initForm() {
        if (arguments != null) {
            binding.textNum.text = this.requireArguments().getString("num")
            binding.textNumberText.text = this.requireArguments().getString("text")
        }
    }
}