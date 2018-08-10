package com.example.johnduong.kotlin_customrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var linearLayoutManager:LinearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        var mang:ArrayList<SinhVien> = ArrayList()
        var sv:SinhVien = SinhVien("luan","7k",1995)
        mang.add(sv)

        var adapter:RecyclerViewAdapter = RecyclerViewAdapter(mang,this)
        recyclerView.adapter=adapter
    }
}
