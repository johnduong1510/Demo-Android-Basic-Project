package com.dvl.quanlycongviec;

import android.app.TabActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QuanLyCongViec quanLyCongViec=new QuanLyCongViec();
        quanLyCongViec.khoitao_Database(MainActivity.this);

        tabHost=getTabHost();//khoi tao tabhost


        TabHost.TabSpec QuanLyCongViec_Tab=tabHost.newTabSpec("tab1");
        QuanLyCongViec_Tab.setIndicator(getResources().getString(R.string.tab1));
        QuanLyCongViec_Tab.setContent(new Intent(MainActivity.this, com.dvl.quanlycongviec.QuanLyCongViec_Tab.class));
        tabHost.addTab(QuanLyCongViec_Tab);

        TabHost.TabSpec GhiChu_Tab=tabHost.newTabSpec("tab2");
        GhiChu_Tab.setIndicator(getResources().getString(R.string.tab2));
        GhiChu_Tab.setContent(new Intent(MainActivity.this, com.dvl.quanlycongviec.GhiChu_Tab.class));
        tabHost.addTab(GhiChu_Tab);

        tabHost.setCurrentTab(0);

    }



}
