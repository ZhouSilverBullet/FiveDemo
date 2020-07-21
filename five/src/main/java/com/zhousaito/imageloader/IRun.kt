package com.zhousaito.imageloader

/**
 * @author  zhousaito
 * @date  2020/7/21 15:43
 * @version 1.0
 * @Dec 略
 */
interface IRun<T> : Runnable, RequestCallback<T> {

    override fun run() {
        exec()
    }

    abstract fun exec()
}