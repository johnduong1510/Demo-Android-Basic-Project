package com.duongvyluan.newnote.Schedule.model.Sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.duongvyluan.newnote.Schedule.model.Data.Schedule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JohnDuong on 28-Aug-17.
 */

public class SqliteManager extends SQLiteOpenHelper {
    private Context context;

    private static final String DATABASE_NAME="Schedule-DB";
    private static final int DATABASE_VERSION=1;
    private final String TABLE_NAME="Schedule";
    private final String COLUMN_1="DateTime";
    private final String COLUMN_2="Content";
    private final String COLUMN_3="Alarm";
    private final String COLUMN_4="Important";

    private String CREATE_TABLE="Create table "+TABLE_NAME
            +"("+COLUMN_1+" Text,"
            +COLUMN_2+"Text,"
            +COLUMN_3+"bit,"
            +COLUMN_4+"bit)";

    public SqliteManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertData(Schedule data)
    {
        SQLiteOpenHelper sql=new SqliteManager(context);
        SQLiteDatabase db=sql.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_1,data.getDateTime());
        contentValues.put(COLUMN_2,data.getContent());
        contentValues.put(COLUMN_3,data.getAlarm());
        contentValues.put(COLUMN_4,data.getImportant());
        return db.insertOrThrow(TABLE_NAME,null,contentValues);
    }
    public List<Schedule> getAllData()
    {
        List<Schedule> scheduleList=new ArrayList<>();
        SQLiteOpenHelper sql=new SqliteManager(context);
        SQLiteDatabase db=sql.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from "+TABLE_NAME,null);
        if(cursor.moveToFirst())
        {
            do {
                Schedule schedule=new Schedule();
                schedule.setDateTime(cursor.getString(1));
                schedule.setContent(cursor.getString(2));
                scheduleList.add(schedule);
            }while (cursor.moveToNext());
        }
        db.close();
        cursor.close();
        return scheduleList;
    }
}
