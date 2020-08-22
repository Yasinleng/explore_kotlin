package com.yasin.base.data_security

/**
 * create by yasin
 * email yasinleng@163.com
 */
interface DataSecurity {
    //加密
    fun encrypt(message:String,password:String=""):String
    //解密
    fun decode(message:String,password:String):String
}