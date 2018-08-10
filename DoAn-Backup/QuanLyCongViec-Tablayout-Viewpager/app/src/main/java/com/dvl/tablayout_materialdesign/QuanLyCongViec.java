package com.dvl.tablayout_materialdesign;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


import java.util.ArrayList;

import static android.database.sqlite.SQLiteDatabase.OPEN_READONLY;
import static android.database.sqlite.SQLiteDatabase.openDatabase;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

/**
 * Created by Administrator on 7/19/2016.
 */
public class QuanLyCongViec {
    Context context;
    SQLiteDatabase db;
    private final static int DB_VERSION = 1;
    private final static String DB_PATH = "/data/data/com.dvl.tablayout_materialdesign/databases/";
    private final static String DB_NAME = "quanlycongviec";

    public void khoitao_Database(Context context) {
        this.context = context;
        if (!check_Database()) {
            db = context.openOrCreateDatabase("quanlycongviec", Context.MODE_APPEND, null);
            String sql = "create table qlcv " +
                    "( " +
                    "_id integer primary key autoincrement, " +
                    "noidung text, " +
                    "thoigian text" +
                    ")";
            db.execSQL(sql);
            db.setVersion(DB_VERSION);
            db.close();
        }
    }

    public boolean check_Database() {
        SQLiteDatabase check_db = null;
        try {
            String mypath = DB_PATH + DB_NAME;
            check_db = SQLiteDatabase.openDatabase(mypath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLException e) {
        }
        if (check_db != null) check_db.close();
        return check_db != null ? true : false;
    }

    public void themCongViec(CongViec c) {
        String noidung = c.noidung;
        String thoigian = c.thoigian;
        db = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.OPEN_READWRITE);
        String sql = "INSERT INTO qlcv (noidung, thoigian)" +
                "VALUES ('" + noidung + "', '" + thoigian + "')";
        db.execSQL(sql);
        db.close();
    }



    public ArrayList<CongViec> xemdsCongViec() {
        ArrayList<CongViec> ds = new ArrayList<CongViec>();
        db = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.OPEN_READWRITE);
        Cursor c = db.rawQuery("select * from qlcv", null);
        if (c.moveToFirst()) {
            do {
                int id = c.getInt(0);
                String noidung = c.getString(1);
                String thoigian = c.getString(2);
                CongViec cv = new CongViec(id, noidung, thoigian);
                ds.add(cv);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return ds;
    }

    public void xoaCongViec(int id_db) {
        db = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.OPEN_READWRITE);
        db.delete("qlcv", "_id=?", new String[]{id_db + ""});
        db.close();
    }

    public void suaCongViec(CongViec c) {
        db = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.OPEN_READWRITE);
        ContentValues values = new ContentValues();
        values.put("noidung", c.noidung);
        values.put("thoigian", c.thoigian);
        db.update("qlcv", values, "_id=?", new String[]{c.id + ""});
        db.close();
    }


}
