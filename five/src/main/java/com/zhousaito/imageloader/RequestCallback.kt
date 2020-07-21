package com.zhousaito.imageloader

/**
 * @author  zhousaito
 * @date  2020/7/21 14:37
 * @version 1.0
 * @Dec 请求的统一回调
 */
interface RequestCallback<T> {
    fun onSuccess(t: T)
    fun onFailure(code: Int, errorMsg: String)
}