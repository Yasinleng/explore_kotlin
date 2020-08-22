package com.yasin.base.data_security

import java.security.MessageDigest


/**
 * create by yasin
 * email yasinleng@163.com
 */
class DataSecurityByMd5: DataSecurity {
    override fun encrypt(message: String, password: String):String {
        val key="MD5"
        val instance = MessageDigest.getInstance(key)
        val bytes = instance.digest(message.toByteArray())
        val result = StringBuilder()
        for (b in bytes) {
            var temp = Integer.toHexString(b.toInt() and 0xff )
            if (temp.length == 1) {
                temp = "0$temp"
            }
            result.append(temp)
        }

        return result.toString()


    }

    override fun decode(message: String,password: String): String {

        return ""
    }


}