package com.duongvyluan.newnote.Schedule.model;

import android.content.Context;

import com.duongvyluan.newnote.Schedule.model.Data.Schedule;
import com.duongvyluan.newnote.Schedule.model.Sqlite.SqliteManager;
import com.duongvyluan.newnote.Schedule.presenter.PresenterImplSchedule;

/**
 * Created by JohnDuong on 28-Aug-17.
 */

public class ModelSchedule {
    SqliteManager sqliteManager;
    private PresenterImplSchedule presenterImplSchedule;
    public ModelSchedule(PresenterImplSchedule presenterImplSchedule) {this.presenterImplSchedule=presenterImplSchedule;}

    public void insertData(Context context,Schedule data)
    {
        SqliteManager sqliteManager=new SqliteManager(context);
        sqliteManager=new SqliteManager(context);
        long id=sqliteManager.insertData(data);
        if(id>0) presenterImplSchedule.onInsertDataSuccess();
        else presenterImplSchedule.onInsertDataFailure();
    }
}
