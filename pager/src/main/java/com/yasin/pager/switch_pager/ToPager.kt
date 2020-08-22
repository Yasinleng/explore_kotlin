package com.yasin.pager.switch_pager

import android.content.Context
import android.util.ArrayMap

/**
 * create by yasin
 * email yasinleng@163.com
 */
interface ToPager {

    fun toPager(context: Context, target:String, params:ArrayMap<String,Any>?=null)

}