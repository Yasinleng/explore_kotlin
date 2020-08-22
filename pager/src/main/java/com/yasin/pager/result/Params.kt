package com.yasin.pager.result

import android.util.ArrayMap

/**
 * create by yasin
 * email yasinleng@163.com
 */

class Params{
    private val cache= ArrayMap<String,Any>()
    fun put(key:String,value:Any): Params {
        cache[key]=value
        return this
    }

    fun get(key:String):Any?{
        return cache.remove(key)
    }

    override fun toString(): String {
        return cache.toString()
    }

}