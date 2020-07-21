package com.zhousaito.imageloader

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import android.widget.ImageView

/**
 * @author  zhousaito
 * @date  2020/7/17 14:53
 * @version 1.0
 * @Dec 略
 */
object Five {
    val TAG = "ImageLoader"

    /**
     * 获取本地缓存的cachePath
     */
    fun getCachePath(): String? {
        return context?.cacheDir?.toString()
    }

    var context: Context? = null
        private set

    /**
     * 用来获取路径
     */
    fun init(context: Context) {
        this.context = context.applicationContext
    }

    fun load(url: String): Request<ImageView, Bitmap> {
        return BitmapRequest(url)
    }

    /**
     * 这个with先留着,生命周期感知的时候使用
     */
    fun with(context: Context) {

    }
}