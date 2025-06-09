package com.qomunal.opensource.androidresearch.common.base

import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import com.google.zxing.BarcodeFormat
import com.google.zxing.Result
import com.qomunal.opensource.androidresearch.common.ext.showToast
import com.qomunal.opensource.androidresearch.databinding.ActivityQrScannerBinding


/**
 * Created by faisalamircs on 24/11/2023
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


abstract class QrScannerActivity : BaseActivity<ActivityQrScannerBinding>() {

    abstract fun doOnSuccessScan(result: Result)

    private val codeScanner: CodeScanner by lazy {
        CodeScanner(this, binding.scannerView)
    }

    override fun setupViewBinding(): ActivityQrScannerBinding {
        return ActivityQrScannerBinding.inflate(layoutInflater)
    }

    override fun initUI() {
        // Parameters (default values)
        codeScanner.camera = CodeScanner.CAMERA_BACK // or CAMERA_FRONT or specific camera id
        codeScanner.formats = listOf(BarcodeFormat.QR_CODE)
        codeScanner.autoFocusMode = AutoFocusMode.SAFE // or CONTINUOUS
        codeScanner.scanMode = ScanMode.SINGLE // or CONTINUOUS or PREVIEW
        codeScanner.isAutoFocusEnabled = true // Whether to enable auto focus or not
        codeScanner.isFlashEnabled = false // Whether to enable flash or not

        // Callbacks
        codeScanner.decodeCallback = DecodeCallback {
            runOnUiThread {
                doOnSuccessScan(it)
            }
        }

        codeScanner.errorCallback = ErrorCallback { // or ErrorCallback.SUPPRESS
            runOnUiThread {
                showToast("Camera initialization error: ${it.message}")
            }
        }

        binding.scannerView.setOnClickListener {
            codeScanner.startPreview()
        }

        binding.apply {
            btnBack.setOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }

}