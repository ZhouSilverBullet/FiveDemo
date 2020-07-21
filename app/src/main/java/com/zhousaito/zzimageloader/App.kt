package com.zhousaito.zzimageloader

import android.app.Application
import com.zhousaito.imageloader.Five

/**
 * @author  zhousaito
 * @date  2020/7/20 23:14
 * @version 1.0
 * @Dec 略
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Five.init(this)
    }
}