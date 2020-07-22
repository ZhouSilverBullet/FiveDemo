package com.zhousaito.imageloader

/**
 * @author  zhousaito
 * @date  2020/7/21 16:36
 * @version 1.0
 * @Dec 略
 */
class RequestOptions(
    var placeholderId: Int = 0,
    var errorId: Int = 0,
    var circleType: CircleType = CircleType.None,
    var roundCorn: Float = 8f
)

enum class CircleType {
    //什么也不处理
    None,

    //圆图
    Circle,

    //圆角
    RoundedCorn
}