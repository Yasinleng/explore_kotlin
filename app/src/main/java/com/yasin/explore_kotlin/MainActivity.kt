package com.yasin.explore_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.yasin.pager.PagerManager
import com.yasin.pager.result.ResultCallback
import com.yasin.pager.result.Params
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ResultCallback {
    override fun result(result: Params): Boolean {

        val a=result.get("1")
        val b=result.get("2")
//        val c=result.get("3")

        Log.i("id1234","a = $a  b = $b c = ")


        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PagerManager.instance.register(this)


        into.setOnClickListener {
            PagerManager.instance.toPager(this,HomeActivity::class.java)
        }

//        val message="AES加密标准又称为高级加密标准Rijndael加密法，是美国国家标准技术研究所NIST旨在取代DES的21世纪的加密标准。AES的基本要"
//        val key="454987676456456"
//
//
//        start.setOnClickListener {
//
//            val pass=DataSecurityManager.instance.encrypt(key)
//
//            val result=DataSecurityManager.instance.encrypt(message,pass,DataSecurityByAes())
//            Log.i("id1234","result=$result")
//
//            val temp=DataSecurityManager.instance.decode(result,pass,DataSecurityByAes())
//            Log.i("id1234","temp=$temp")


//
//
//        }

    }
}
