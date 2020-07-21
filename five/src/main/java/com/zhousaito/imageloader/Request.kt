package com.zhousaito.imageloader

import android.graphics.Bitmap
import android.widget.ImageView

/**
 * @author  zhousaito
 * @date  2020/7/21 14:07
 * @version 1.0
 * @Dec 略
 */
class Request {
    private var url: String? = null

    internal constructor(url: String) {
        this.url = url
    }

    fun into(imageView: ImageView) {
        BitmapHttpClient.INSTANCE.request(url, object : BitmapHttpClient.BitmapCallback {
            override fun onBitmap(bitmap: Bitmap?) {
                imageView.setImageBitmap(bitmap)
            }
        })
    }
}