package com.zhousaito.imageloader

/**
 * @author  zhousaito
 * @date  2020/7/21 14:23
 * @version 1.0
 * @Dec 统一资源管理，用来匹配资源使用
 */
interface Resource {
    /**
     * 文件名字
     */
    val fileName: String

    /**
     * 请求链接的名字
     */
    val requestUrl: String

    /**
     * 资源类型
     */
    val type: Int

    companion object {
        /**
         * http资源
         */
        const val TYPE_HTTP = 0

        /**
         * res资源
         */
        const val TYPE_RES = 1
    }
}