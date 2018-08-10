package com.dvl.demo_gameshow;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 31/7/2016.
 */
public class quanlycauhoi extends SQLiteOpenHelper {

    private static String DB_PATH = "/data/data/com.dvl.demo_gameshow/databases/";
    private static String DB_NAME = "databasecauhoi.sqlite";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "tablecauhoi";
    private static final String KEY_ID = "_id";
    private static final String KEY_CAUHOI = "cauhoi";
    private static final String KEY_A = "cau_a";
    private static final String KEY_B = "cau_b";
    private static final String KEY_C = "cau_c";
    private static final String KEY_D = "cau_d";
    private static final String KEY_DA = "dapan";

    private SQLiteDatabase myDataBase;
    private final Context myContext;

    public quanlycauhoi(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
        this.myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        String mypath = DB_PATH + DB_NAME;
        try {
            checkDB = SQLiteDatabase.openDatabase(mypath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
        }
        if (checkDB != null) checkDB.close();
        return checkDB != null ? true : false;
    }

    private void copyDataBase() {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = myContext.getAssets().open(DB_NAME);
            String mypath = DB_PATH + DB_NAME;
            out = new FileOutputStream(mypath);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            out.flush();
            ;
            out.close();
            in.close();
        } catch (IOException e) {
        }
    }

    public void createDataBase() throws IOException {
        boolean db_exist = checkDataBase();
        if (db_exist) {
            //do nothing
        } else {
            this.getWritableDatabase();
            copyDataBase();
        }
    }

    public Cursor getAllQuestions() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from tablecauhoi", null);
        return cursor;
    }

    public List<cauhoi> layNNgauNhien(int socau) {
        List<cauhoi> cauhoi = new ArrayList<cauhoi>();
        SQLiteDatabase db = this.getReadableDatabase();
        String limit = "0," + socau;
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, "random()", limit);
        cursor.moveToFirst();
        cauhoi x;
        do {
            x = new cauhoi(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6));
                    cauhoi.add(x);
        } while (cursor.moveToNext());
        return cauhoi;
    }
}