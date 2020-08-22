package com.yasin.pager.result

import android.app.Notification
import android.os.Message
import android.util.ArrayMap

/**
 * create by yasin
 * email yasinleng@163.com
 */

class Params{
    private var next:Params?=null




    companion object{
        private var pool:Params?=null
        private var size = 0

        private val MAX_SIZE = 20
        fun obtain():Params{
            if (pool!=null){
                var temp= pool
                pool= temp!!.next
                temp.next=null
                size--
                return temp
            }
            return Params()
        }


    }

    private val cache= ArrayMap<String,Any>()
    fun put(key:String,value:Any): Params {
        cache[key]=value
        return this
    }

    fun get(key:String):Any?{
        val current=cache.remove(key)
        if ( cache.size == 0 && size < MAX_SIZE){
            release()
        }
        return current
    }

    fun release(){
        cache.clear()
        next= pool
        pool=this
        size++
    }


    override fun toString(): String {
        return cache.toString()
    }


}