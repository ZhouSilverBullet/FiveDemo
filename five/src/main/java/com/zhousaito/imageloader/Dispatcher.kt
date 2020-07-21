package com.zhousaito.imageloader

import java.util.concurrent.SynchronousQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * @author  zhousaito
 * @date  2020/7/17 14:55
 * @version 1.0
 * @Dec 略
 */
object Dispatcher {

    @JvmStatic
    val THREAD_POOL = ThreadPoolExecutor(0, Int.MAX_VALUE, 60L, TimeUnit.SECONDS, SynchronousQueue<Runnable>())
}