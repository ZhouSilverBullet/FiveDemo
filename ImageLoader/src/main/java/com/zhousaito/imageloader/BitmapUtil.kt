package com.zhousaito.imageloader

import android.graphics.Bitmap
import android.os.Build

/**
 * @author  zhousaito
 * @date  2020/7/17 16:35
 * @version 1.0
 * @Dec 略
 */
object BitmapUtil {
    /**
     * 获取bitmap的大小
     */
    fun getBitmapSize(bitmap: Bitmap?): Int {
        if (bitmap == null) {
            return 0
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return bitmap.allocationByteCount
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            return bitmap.byteCount
        }
        return bitmap.rowBytes * bitmap.height
    }
}