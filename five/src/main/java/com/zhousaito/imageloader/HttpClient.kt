package com.zhousaito.imageloader

import com.zhousaito.imageloader.Dispatcher.THREAD_POOL
import java.io.BufferedInputStream
import java.io.InputStream
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

/**
 * @author  zhousaito
 * @date  2020/7/17 14:53
 * @version 1.0
 * @Dec 略
 */
class HttpClient {

    fun httpGet(httpUrl: String?, callback: RequestCallback<InputStream>?) {
        THREAD_POOL.execute {
            try {
                val url = URL(httpUrl)
                val conn = openConnection(url)
                conn.connect()
                val bis = BufferedInputStream(conn.inputStream)
                callback?.onSuccess(bis)
            } catch (e: Exception) {
                callback?.onFailure(-100, "暂时是未知网络错误")
            }
        }
    }

    private fun openConnection(url: URL): HttpURLConnection {
        val conn = url.openConnection() as HttpURLConnection
        conn.readTimeout = 10_000
        conn.connectTimeout = 10_000
//        conn.doOutput = true
//        conn.setChunkedStreamingMode(0)
        return conn
    }
}