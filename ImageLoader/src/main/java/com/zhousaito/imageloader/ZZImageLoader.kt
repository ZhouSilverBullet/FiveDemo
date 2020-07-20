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
object ZZImageLoader {
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

    fun load(imageView: ImageView, requestUrl: String) {
        if (context == null) {
            context = imageView.context.applicationContext
        }

        BitmapHttpClient.INSTANCE.request(requestUrl, object : BitmapHttpClient.BitmapCallback {
            override fun onBitmap(bitmap: Bitmap?) {
                //45630 byte
                //624000
                //312000    RGB_565
                //312000    ARGB_4444
                //1248000   RGBA_F16
                //156000    ALPHA_8  这个图片显示为黑色，不正常
                //
//                Log.e(TAG, " bitmap size = ${bitmap.rowBytes * bitmap.height}")
//                Log.e(TAG, " bitmap size = ${bitmap.rowBytes * bitmap.height / 1024}")
//                Log.e(TAG, " bitmap size = ${bitmap.byteCount}")
//                Log.e(TAG, " bitmap size = ${BitmapUtil.getBitmapSize(bitmap)}")

//                val createBitmap = Bitmap.createBitmap(
//                    imageView.context.resources.displayMetrics,
//                    bitmap.width,
//                    bitmap.height,
//                    Bitmap.Config.RGB_565
//                )
//                val copyBitmap = bitmap.copy(Bitmap.Config.RGB_565, true)
//
//                Log.e(TAG, " bitmap size = ${BitmapUtil.getBitmapSize(copyBitmap)}")
//                Log.e(TAG, " bitmap size = ${copyBitmap.rowBytes} ${copyBitmap.height} ")

                imageView.setImageBitmap(bitmap)
            }
        })
    }
}