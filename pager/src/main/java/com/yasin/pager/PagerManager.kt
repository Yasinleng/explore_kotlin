package com.yasin.pager

import android.app.Activity
import android.content.Context
import android.util.ArrayMap
import com.yasin.pager.result.DefaultPlatform
import com.yasin.pager.result.Params
import com.yasin.pager.result.ResultCallback
import com.yasin.pager.result.ResultPlatform
import com.yasin.pager.switch_pager.DefaultToPager
import com.yasin.pager.switch_pager.ToPager

/**
 * create by yasin
 * email yasinleng@163.com
 */
class PagerManager private constructor(){
    private var pager: ToPager =
        DefaultToPager()
    private var pagerToResult: ResultPlatform =
        DefaultPlatform()

    companion object {
        val instance: PagerManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { PagerManager() }
    }

    fun <T: Activity> toPager(context: Context, target:Class<T>, params: ArrayMap<String, Any>?=null){
        pager.toPager(context, target.name, params)
    }

    fun register(obj: ResultCallback){
        pagerToResult.register(obj)
    }

    fun <T : ResultCallback> send(obj: Class<T>, result: Params){
        pagerToResult.send(obj,result)
    }

    fun remove(obj: ResultCallback){
        pagerToResult.register(obj)
    }

    fun init(pager: ToPager?=null, pagerToResult: ResultPlatform?=null){
        if (pager != null) {
            this.pager=pager
        }

        if (pagerToResult != null) {
            this.pagerToResult=pagerToResult
        }

    }

}