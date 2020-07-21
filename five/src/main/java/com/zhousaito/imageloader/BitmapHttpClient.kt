package com.zhousaito.imageloader

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.zhousaito.imageloader.util.MD5Helper
import java.io.*

/**
 * @author  zhousaito
 * @date  2020/7/17 15:07
 * @version 1.0
 * @Dec 略
 */
class BitmapHttpClient private constructor() {

    companion object {
        val TAG = "BitmapHttpClient"
        //单例上
        val INSTANCE by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            BitmapHttpClient()
        }
    }

    private val httpClient = HttpClient()
    val handler = Handler(Looper.getMainLooper())
    val bitmapCache = BitmapLruCache()


    interface BitmapCallback {
        fun onBitmap(bitmap: Bitmap?)
    }

    /**
     * 这里应该分2级缓存
     * 1. 内存缓存
     * 2. 本地磁盘缓存
     */
    fun request(requestUrl: String?, callback: BitmapCallback?) {
        //内存缓存
        Log.e(TAG, "--------------")
        var bit = bitmapCache.get(requestUrl)
        if (bit == null) {
            //本地磁盘缓存
            bit = getLocalBitmapForUrl(requestUrl)
            if (bit == null) {
                //最后请求网络
                httpClient.httpGet(requestUrl, object : HttpClient.Callback {
                    override fun onSuccess(stream: InputStream) {
                        val bitmap = BitmapFactory.decodeStream(stream)
                        stream.close()
                        if (bitmap != null) {
                            bitmapCache.put(requestUrl, bitmap)
                            if (saveLocalBitmapForUrl(bitmap, requestUrl)) {
                                Log.e(TAG, "图片本地保存成功")
                            }
                        }
                        Log.e(TAG, "正常网络去获取")
                        handler.post {
                            callback?.onBitmap(bitmap)
                        }
                    }
                })
            } else {
                Log.e(TAG, "走磁盘缓存里面去拿")
                bitmapCache.put(requestUrl, bit)
                callback?.onBitmap(bit)
            }
        } else {
            Log.e(TAG, "走内存缓存里面去拿")
            callback?.onBitmap(bit)
        }
    }

    /**
     * 获取本地的图片，转换成bitmap
     */
    private fun getLocalBitmapForUrl(requestUrl: String?): Bitmap? {
        val fileName = MD5Helper.encode(requestUrl)
        val file = File(Five.getCachePath() + File.separator + fileName)
        if (file.exists() && file.length() > 0) {
            return BitmapFactory.decodeStream(BufferedInputStream(FileInputStream(file)))
        }
        return null
    }

    /**
     * 将bitmap转为本地图片
     */
    private fun saveLocalBitmapForUrl(bitmap: Bitmap, requestUrl: String?): Boolean {
        val fileName = MD5Helper.encode(requestUrl)
        val file = File(Five.getCachePath() + File.separator + fileName)
        if (!file.exists()) {
            return bitmap.compress(
                Bitmap.CompressFormat.PNG,
                100,
                BufferedOutputStream(FileOutputStream(file))
            )
        }
        return false
    }
}