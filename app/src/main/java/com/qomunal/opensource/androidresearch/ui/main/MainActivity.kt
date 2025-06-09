package com.qomunal.opensource.androidresearch.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.qomunal.opensource.androidresearch.common.base.BaseActivity
import com.qomunal.opensource.androidresearch.common.ext.createQRCode
import com.qomunal.opensource.androidresearch.databinding.ActivityMainBinding
import com.qomunal.opensource.androidresearch.ui.detail.DetailActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: MainViewModel by viewModels()
    private val router: MainRouter by lazy {
        MainRouter(this)
    }

    override fun setupViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initUI() {
        binding.apply {
            btnScanner.setOnClickListener {
                startActivity(Intent(this@MainActivity, DetailActivity::class.java))
            }

            ivQrQode.createQRCode("Amir")
        }
    }

    override fun initObserver() {
        viewModel.apply {

        }
    }

}