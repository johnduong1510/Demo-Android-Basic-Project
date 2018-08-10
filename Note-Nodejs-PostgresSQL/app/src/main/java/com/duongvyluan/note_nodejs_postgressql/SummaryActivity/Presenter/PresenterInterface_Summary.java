package com.duongvyluan.note_nodejs_postgressql.SummaryActivity.Presenter;

import com.duongvyluan.note_nodejs_postgressql.SummaryActivity.Model.Object_Note;

import java.util.List;

/**
 * Created by JohnDuong on 21-Sep-17.
 */

public interface PresenterInterface_Summary {
    void sendPost(String urlLink, final String params1, final String value1, final String params2, final String value2);
    void onPOSTSuccess(String message);
    void onPOSTFailure(String message);
}
