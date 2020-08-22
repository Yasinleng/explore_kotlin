package com.yasin.base.data_security

/**
 * create by yasin
 * email yasinleng@163.com
 */
class DataSecurityManager private constructor(){

    companion object{
        val instance: DataSecurityManager by lazy(mode=LazyThreadSafetyMode.SYNCHRONIZED){ DataSecurityManager() }
    }


    fun encrypt(message:String,password:String="",security: DataSecurity = DataSecurityByMd5()):String{
        return security.encrypt(message, password)
    }

    fun decode(message: String,password: String,security: DataSecurity = DataSecurityByMd5()): String{
        return security.decode(message,password)
    }



}