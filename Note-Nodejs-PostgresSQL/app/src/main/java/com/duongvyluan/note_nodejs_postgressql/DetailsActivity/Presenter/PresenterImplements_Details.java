package com.duongvyluan.note_nodejs_postgressql.DetailsActivity.Presenter;

/**
 * Created by JohnDuong on 21-Sep-17.
 */

public interface PresenterImplements_Details {
    void sendNote(String urlLink,  String params1,  String title,  String params2,  String content);
    void POSTSuccess(String message);
    void POSTFailure(String message);
}
