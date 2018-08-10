package com.example.johnduong.kotlin_listviewcoban

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mang:ArrayList<String> = ArrayList()
        for (i in 0..30) {mang.add(i.toString())}
        listView.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,mang)
    }

}
