package com.yasin.explore_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yasin.pager.PagerManager
import com.yasin.pager.result.Params
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var count=0

        result.setOnClickListener {
            PagerManager.instance.send(MainActivity::class.java,Params.obtain().put("1",32).put("2",false).put("3","测试${count++}"))
            PagerManager.instance.send(MainActivity::class.java,Params.obtain().put("1",32).put("2",false).put("3","测试${count++}"))
            PagerManager.instance.send(MainActivity::class.java,Params.obtain().put("1",32).put("2",false).put("3","测试${count++}"))

//            finish()
        }
    }
}
