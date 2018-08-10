package com.duongvyluan.note_nodejs_postgressql.SummaryActivity.View;

import com.duongvyluan.note_nodejs_postgressql.SummaryActivity.Model.Object_Note;

import java.util.List;

/**
 * Created by JohnDuong on 21-Sep-17.
 */

public interface View {
    void addDataRecyclerView(List<Object_Note> data);
    void refreshRecyclerView();
    void onPOSTFailure(String message);
    void onPOSTSuccess(String message);
}
