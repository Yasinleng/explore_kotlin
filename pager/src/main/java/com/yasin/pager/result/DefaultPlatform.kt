package com.yasin.pager.result

import com.yasin.pager.exception.PagerException

/**
 * create by yasin
 * email yasinleng@163.com
 */
class DefaultPlatform: ResultPlatform() {


    override fun register(obj: ResultCallback) {
        if (cache.containsKey(key(obj))) {
            throw PagerException("${obj::class.java.name} already registered")
        }
        cache[key(obj)] = obj
    }

    override fun <T : ResultCallback> send(obj: Class<T>, result: Params) {
        val callback = cache[obj.name] ?: throw PagerException("${obj.name} No registered")
        if (callback.result(result)) cache[obj.name]
    }


}