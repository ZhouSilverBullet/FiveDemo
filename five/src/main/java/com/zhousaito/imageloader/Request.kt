package com.zhousaito.imageloader

import java.lang.ref.WeakReference

/**
 * @author  zhousaito
 * @date  2020/7/21 14:07
 * @version 1.0
 * @Dec 略
 */
abstract class Request<V, T> : RequestCallback<T> {
    private var url: Any? = null

    //imageView弱引用，方便在回收的时候，不会内存泄漏
    var imageViewRef: WeakReference<V>? = null

    internal constructor(url: String) {
        this.url = url
    }

    fun into(imageView: V) {
        imageViewRef = WeakReference(imageView)
        //进行网络请求
        BitmapHttpClient.INSTANCE.request(url as String, this)

    }

}