package com.qomunal.opensource.androidresearch.ui.detail

import androidx.activity.viewModels
import com.google.zxing.Result
import com.qomunal.opensource.androidresearch.common.base.QrScannerActivity
import com.qomunal.opensource.androidresearch.common.ext.showToast

/**
 * Created by faisalamircs on 13/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


class DetailActivity : QrScannerActivity() {

    companion object {
        const val EXTRA_EVENT = "EXTRA_EVENT"
    }


    private val viewModel: DetailViewModel by viewModels()

    override fun doOnSuccessScan(result: Result) {
        showToast(result.text)
    }

    override fun initObserver() {

    }

}