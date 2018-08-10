package com.example.admin.demo_quanlycongviec_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Admin on 24/7/2016.
 */
public class QuanLyCongViec extends SQLiteOpenHelper{
    public QuanLyCongViec(Context context) {
        super(context, "quanlycongviec", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    /*
        create table qlcv
        (
            _id integer primary key autoincrement,
            noidung text,
            thoigian text
        )
     */
        String sql="create table qlcv " +
                "( " +
                "_id integer primary key autoincrement, " +
                "noidung text, " +
                "thoigian text" +
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.rawQuery("drop table if exits qlcv",null);
        onCreate(db);
    }

    public void themCongViec(CongViec c)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("noidung",c.noidung);
        values.put("thoigian", c.thoigian);
        db.insert("qlcv", null, values);
    }

    public ArrayList<CongViec> xemdsCongViec()
    {
        ArrayList<CongViec> ds=new ArrayList<CongViec>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from qlcv", null);
        if(c.moveToFirst()==true)
        {
            do{
                int id=c.getInt(0);
                String noidung=c.getString(1);
                String thoigian=c.getString(2);
                CongViec cv=new CongViec(id,noidung,thoigian);
                ds.add(cv);
            }while(c.moveToNext());
        }
        return ds;
    }

    public void suaCongViec(CongViec congViec_edited) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues value=new ContentValues();
        value.put("noidung",congViec_edited.noidung);
        value.put("thoigian",congViec_edited.thoigian);
        db.update("qlcv",value,"_id=?",new String[]{congViec_edited.id+""});
    }

    public void xoaCongViec(CongViec congViec) {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("qlcv","_id=?",new String[]{congViec.id+""});
    }
}