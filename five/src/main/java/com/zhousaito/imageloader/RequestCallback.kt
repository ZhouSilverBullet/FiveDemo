package com.zhousaito.imageloader

import android.graphics.Bitmap

/**
 * @author  zhousaito
 * @date  2020/7/21 14:37
 * @version 1.0
 * @Dec 请求的统一回调
 */
interface RequestCallback {
    fun onSuccess(t: Bitmap)
    fun onFailure(code: Int, errorMsg: String)
}