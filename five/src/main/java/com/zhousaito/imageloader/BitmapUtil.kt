package com.zhousaito.imageloader

import android.graphics.*
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

    /**
     * 将bitmap变成圆图
     */
    fun toRoundBitmap(bitmap: Bitmap): Bitmap {
        var width = bitmap.width
        var height = bitmap.height
        var roundPx = 0f
        var top = 0
        var bottom = 0
        var left = 0
        var right = 0

        var dstTop = 0
        var dstBottom = 0
        var dstLeft = 0
        var dstRight = 0

        if (width <= height) {
            roundPx = width / 2.0f
            top = 0
            bottom = width
            left = 0
            right = width
            height = width

            dstLeft = 0
            dstTop = 0
            dstRight = width
            dstBottom = height
        } else {
            roundPx = height / 2.0f
            val clip = (width - height) / 2
            left = clip
            right = width - clip
            top = 0
            bottom = height
            width = height

            dstLeft = 0
            dstTop = 0
            dstRight = height
            dstBottom = height
        }

        val output = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(output)
        val color = 0xff424242
        val paint = Paint()
        var src = Rect(left, top, right, bottom)
        var dst = Rect(dstLeft, dstTop, dstRight, dstBottom)
        val rectF = RectF(dst)
        paint.isAntiAlias = true
        canvas.drawARGB(0, 0, 0, 0)
        paint.color = color.toInt()
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas.drawBitmap(bitmap, src, dst, paint)
        return output
    }

    /**
     * 得到圆角图片
     */
    fun toRoundedCornerBitmap(bitmap: Bitmap, roundPx: Float = 8f): Bitmap {
        val width = bitmap.width
        val height = bitmap.height

        //创建一个空白的bitmap
        val output = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(output)
        val color = 0xff424242
        val paint = Paint()
        paint.color = color.toInt()
        paint.isAntiAlias = true
        //透明的画布
        canvas.drawARGB(0, 0, 0, 0)
        val rect = Rect(0, 0, width, height)
        val rectF = RectF(rect)
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint)
        paint.setXfermode(PorterDuffXfermode(PorterDuff.Mode.SRC_IN))
        val rect2 = Rect(0, 0, width, height)
        canvas.drawBitmap(bitmap, null, rect2, paint)
        return output
    }
}