package com.zhousaito.imageloader

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import java.io.BufferedInputStream
import java.io.InputStream

/**
 * @author  zhousaito
 * @date  2020/7/17 15:07
 * @version 1.0
 * @Dec 略
 */
class BitmapHttpClient private constructor() {

    companion object {
        //单例上
        val INSTANCE by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            BitmapHttpClient()
        }
    }

    private val httpClient = HttpClient()
    val handler = Handler(Looper.getMainLooper())
    val bitmapCache = BitmapLruCache()


    interface BitmapCallback {
        fun onBitmap(bitmap: Bitmap)
    }

    fun request(requestUrl: String, callback: BitmapCallback?) {
        val bit = bitmapCache.get(requestUrl)
        if (bit == null) {
            httpClient.httpGet(requestUrl, object : HttpClient.Callback {
                override fun onSuccess(stream: InputStream) {
                    val bitmap = BitmapFactory.decodeStream(stream)
                    stream.close()
                    bitmapCache.put(requestUrl, bitmap)
                    handler.post {
                        callback?.onBitmap(bitmap)
                    }
                }
            })
        } else {
            callback?.onBitmap(bit)
        }
    }
}