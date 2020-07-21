package com.zhousaito.imageloader

import android.graphics.Bitmap
import android.widget.ImageView

/**
 * @author  zhousaito
 * @date  2020/7/21 14:07
 * @version 1.0
 * @Dec 略
 */
class BitmapRequest(requestUrl: String) : Request<ImageView, Bitmap>(requestUrl) {

    override fun onSuccess(t: Bitmap) {
        imageViewRef?.get()?.setImageBitmap(t)
    }

    override fun onFailure(code: Int, errorMsg: String) {
        //设置失败状态

    }

}