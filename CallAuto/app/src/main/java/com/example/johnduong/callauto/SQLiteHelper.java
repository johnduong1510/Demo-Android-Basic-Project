package com.example.johnduong.callauto;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by JohnDuong on 08-Aug-17.
 */

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DB_NAME="CallNumbers.db";
    private static final String TABLE_NAME="CALLNUMBERS";
    private static final String COLUMN_1="Name";
    private static final String COLUMN_2="Numbers";
    private static final int DB_VERSION=1;
    Context context;
    private static final String CREATE_TABLE_CallNumbers=
            "CREATE TABLE "+ TABLE_NAME + "(" +
                    COLUMN_1+"," +COLUMN_2+
                    ")";

    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context=context;
    }

    public void insertData(String name,String numbers)
    {
        SQLiteOpenHelper sql=new SQLiteHelper(context);
        SQLiteDatabase db =  sql.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_1,name);
        values.put(COLUMN_2,numbers);
        long id=db.insert(TABLE_NAME,null,values);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CallNumbers);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
