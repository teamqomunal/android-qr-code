package com.qomunal.opensource.androidresearch.common.ext

import android.widget.ImageView
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder

/**
 * Created by faisalamircs on 09/06/2025
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


fun ImageView.createQRCode(url: String?) {
    url?.let {
        this.setImageBitmap(
            BarcodeEncoder().encodeBitmap(
                it,
                BarcodeFormat.QR_CODE,
                400,
                400
            )
        )
    }
}