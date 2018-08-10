package com.example.luxury.kotlin_intent

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
//            val intent: Intent = Intent(this,Main2Activity::class.java)
//            startActivity(intent)

            //Intent with data
            val intent : Intent = Intent(applicationContext,Main2Activity::class.java)
//            intent.putExtra("data",editText.text.toString())
//            startActivity(intent)

            //Intent with class
//            val sinhvien1: SinhVien = SinhVien("nguyen van a","123")
//            intent.putExtra("data",sinhvien1)
//            startActivity(intent)

            //StartActivity for result
            intent.putExtra("data","data123")
            startActivityForResult(intent,888)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if ((requestCode == 888) && (resultCode == Activity.RESULT_OK))
        {
            val string: String= data!!.getStringExtra("data2")
            editText.setText(string)
        }
    }
}
