package com.yasin.pager.switch_pager

import android.content.Context
import android.content.Intent
import android.util.ArrayMap

/**
 * create by yasin
 * email yasinleng@163.com
 */
class DefaultToPager : ToPager {
    override fun toPager(context: Context, target: String, params: ArrayMap<String, Any>?) {
        context.startActivity(create(context, target, params))
    }

    private fun create(context: Context, target: String, params: ArrayMap<String, Any>?): Intent {
        val clazz = Class.forName(target)
        val intent= Intent(context,clazz)
        if (params != null) {
            put(intent,params)
        }
        return intent
    }

    private fun put(intent: Intent, params: ArrayMap<String, Any>){
        for ((key,value) in params){
            when(value){
                is String ->intent.putExtra(key, value )
                is Boolean ->intent.putExtra(key, value )
                is Long ->intent.putExtra(key, value )
                is Short ->intent.putExtra(key, value )
                is Int ->intent.putExtra(key, value )
                is Float ->intent.putExtra(key, value )
                is Double ->intent.putExtra(key, value )
            }
        }
    }
}