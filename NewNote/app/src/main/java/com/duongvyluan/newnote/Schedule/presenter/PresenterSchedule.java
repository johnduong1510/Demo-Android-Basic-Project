package com.duongvyluan.newnote.Schedule.presenter;

import android.content.Context;

import com.duongvyluan.newnote.Schedule.model.Data.Schedule;
import com.duongvyluan.newnote.Schedule.model.ModelSchedule;
import com.duongvyluan.newnote.Schedule.model.Sqlite.SqliteManager;
import com.duongvyluan.newnote.Schedule.view.ViewSchedule;

/**
 * Created by JohnDuong on 28-Aug-17.
 */

public class PresenterSchedule implements PresenterImplSchedule {

    ViewSchedule viewSchedule;

    public PresenterSchedule(ViewSchedule viewSchedule){this.viewSchedule=viewSchedule;}
    @Override
    public void onInsertDataSuccess() {
        viewSchedule.LoadSchedules();
        viewSchedule.onInsertDataSuccess();
    }

    @Override
    public void onInsertDataFailure() {
        viewSchedule.onInsertDataFailure();
    }
}
