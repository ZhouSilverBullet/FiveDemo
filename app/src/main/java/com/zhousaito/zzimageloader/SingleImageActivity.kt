package com.zhousaito.zzimageloader

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zhousaito.imageloader.CircleType
import com.zhousaito.imageloader.Five
import com.zhousaito.imageloader.RequestOptions
import kotlinx.android.synthetic.main.activity_single_image.*

class SingleImageActivity : AppCompatActivity() {
    companion object {
        val imageArray = arrayListOf<String>("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1595267426181&di=ef4dd002859251f1126a5c1f43b72d3b&imgtype=0&src=http%3A%2F%2Fpic1.16pic.com%2F00%2F51%2F75%2F16pic_5175210_b.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1595267408505&di=a0d60303b6748972bb2d3c65cb5a4929&imgtype=0&src=http%3A%2F%2Fa3.att.hudong.com%2F67%2F10%2F300001190914130190105261165_950.jpg",
        "https://dss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3425860897,3737508983&fm=26&gp=0.jpg")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_image)

//        Five.load(ivSingleImage, imageArray[0])
        val requestOptions = RequestOptions()
        requestOptions.errorId = R.mipmap.loading_icon
        requestOptions.placeholderId = R.drawable.img_loading
        requestOptions.circleType = CircleType.Circle
        Five.load(imageArray[0]).apply(requestOptions).into(ivSingleImage)

        val requestOptions1 = RequestOptions()
        requestOptions1.errorId = R.mipmap.loading_icon
        requestOptions1.placeholderId = R.drawable.img_loading
        requestOptions1.circleType = CircleType.RoundedCorn
        requestOptions1.roundCorn = 25f
        Five.load(imageArray[1]).apply(requestOptions1).into(ivSingleImage2)

        val requestOptions2 = RequestOptions()
        requestOptions2.errorId = R.mipmap.loading_icon
        requestOptions2.placeholderId = R.drawable.img_loading
        requestOptions2.circleType = CircleType.None
        Five.load(imageArray[2]).apply(requestOptions2).into(ivSingleImage3)

    }
}