package com.zhousaito.imageloader

import android.graphics.Bitmap
import android.util.LruCache

/**
 * @author  zhousaito
 * @date  2020/7/17 16:03
 * @version 1.0
 * @Dec 略
 */
class BitmapLruCache : LruCache<String, Bitmap>(
    (Runtime.getRuntime().maxMemory() / 8 / 1024).toInt()
) {
    override fun sizeOf(key: String?, value: Bitmap?): Int {
        if (value == null) {
            return 0
        }
        return value.rowBytes * value.height / 1024
    }
}