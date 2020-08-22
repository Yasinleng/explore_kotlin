package com.yasin.pager.result

import android.util.ArrayMap

/**
 * create by yasin
 * email yasinleng@163.com
 */
abstract class ResultPlatform {

    protected val cache = ArrayMap<String, ResultCallback>()

    abstract fun register(obj: ResultCallback)

    protected fun remove(obj: ResultCallback) {
        cache.remove(key(obj))
    }

    abstract fun <T : ResultCallback> send(obj: Class<T>, result: Params)

    protected fun key(obj: ResultCallback) = obj::class.java.name
}