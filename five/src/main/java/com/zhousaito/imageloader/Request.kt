package com.zhousaito.imageloader

import android.graphics.Bitmap
import android.widget.ImageView
import java.lang.ref.WeakReference

/**
 * @author  zhousaito
 * @date  2020/7/21 14:07
 * @version 1.0
 * @Dec 略
 */
class Request : RequestCallback {
    private var url: String? = null
    //imageView弱引用，方便在回收的时候，不会内存泄漏
    private var imageViewRef: WeakReference<ImageView>? = null

    internal constructor(url: String) {
        this.url = url
    }

    fun into(imageView: ImageView) {
        imageViewRef = WeakReference(imageView)
        //进行网络请求
        BitmapHttpClient.INSTANCE.request(url, this)
    }

    override fun onSuccess(t: Bitmap) {
        imageViewRef?.get()?.setImageBitmap(t)
    }

    override fun onFailure(code: Int, errorMsg: String) {
        //设置失败状态
    }
}