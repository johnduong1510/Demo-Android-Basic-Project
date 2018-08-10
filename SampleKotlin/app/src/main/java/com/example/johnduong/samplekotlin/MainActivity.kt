package com.example.johnduong.samplekotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btSum.setOnClickListener(View.OnClickListener { tinhTong() })

    }
    private fun tinhTong()
    {
        val a:Int=edt_number1.text.toString().toInt()
        val b:Int=edt_number2.text.toString().toInt()
        val c:Int=a+b;
        btSum.text=c.toString();
    }
    private fun tinhTong2(a:Int,b:Int):Int?
    {

        return null
    }
}
