package com.duongvyluan.note_nodejs_postgressql.DetailsActivity.View;

/**
 * Created by JohnDuong on 21-Sep-17.
 */

public interface View_Details {
    void saveSuccess();
    void saveFailure();
    void onPostSuccess(String message);
    void onPostFailure(String message);
}
