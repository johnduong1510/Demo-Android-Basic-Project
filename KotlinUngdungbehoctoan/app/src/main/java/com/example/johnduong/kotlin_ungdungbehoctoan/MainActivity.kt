package com.example.johnduong.kotlin_ungdungbehoctoan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URI

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCong.setOnClickListener{
            var so1:Int=edtSo1.text.toString().toInt()
            var so2:Int=edtSo2.text.toString().toInt()
            var kq:String=(so1+so2).toString()
            txtKQ.text=kq
        }


    }

}
