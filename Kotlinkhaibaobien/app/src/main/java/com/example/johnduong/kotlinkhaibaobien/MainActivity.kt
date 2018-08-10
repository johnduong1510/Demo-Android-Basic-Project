package com.example.johnduong.kotlinkhaibaobien

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var chuoi : String ?="abc"
//        chuoi=null
//
//        var temp: String ="abc"!!
//        temp="123"


//        var a :String = "luan"
//        when(a){
//            "han" -> Log.d("test","Han")
//            "luan"->Log.d("test","luan")
//
//        }
//

//        var a: Int =9
//        when(a){
//            in 1..3 ->Log.d("test","1 den 3")
//            in 4..7 ->Log.d("test","4 den 7")
//            else -> Log.d("test","no result")
//        }

//        for (i in 0..10){
//            Log.d("test","for i="+i)
//        }
//        var a:Int =6
//        for(i in 0 until a ){
//            Log.d("test","for i="+i)
//        }


//        var a:Int=10
//        for(i in 0..a step 2){
//            Log.d("test","for step 2 i="+i)
//        }


//        var mangso:IntArray= intArrayOf(1,2,3,4,5,6)
//        Log.d("mang","mang="+mangso.get(0))
//
//        var list:List<String> = listOf("luan","han","huy")
//        Log.d("mang","mang chuoi ="+list.get(0))

//        var mangten:ArrayList<String> = ArrayList()
//        mangten.add("luan")
//        mangten.add("han")

        var mangten:ArrayList<String> = ArrayList()
        mangten.add("luan")
        mangten.add("han")

        mangten.set(0,"luan123")
        Log.d("mang","mangten 0="+mangten.get(0))

        fun tinhTong(a:Int,b:Int):Int
        {
            return (a+b)
        }

        Log.d("tinhTong","1+2="+tinhTong(1,2))

    }
}
