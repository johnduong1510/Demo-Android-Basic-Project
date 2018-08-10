package com.example.luxury.kotlin_intent

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


//        val intent = intent //get intent
//        val data : String = intent.getStringExtra("data")

        //get intent with class
//        val sinhvien : SinhVien=intent.getSerializableExtra("data") as SinhVien
//
//        textViewActivity2.text=sinhvien.hoten +": " +sinhvien.maso

        val intent : Intent = Intent(this,MainActivity::class.java)
        val string: String = getIntent().getStringExtra("data") +"from Activity 2"
        intent.putExtra("data2",string)
        setResult(Activity.RESULT_OK,intent)
        finish()

    }
}
