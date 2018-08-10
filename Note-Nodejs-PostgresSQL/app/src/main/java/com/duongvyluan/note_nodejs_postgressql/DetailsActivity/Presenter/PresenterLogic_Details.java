package com.duongvyluan.note_nodejs_postgressql.DetailsActivity.Presenter;

import android.content.Context;

import com.duongvyluan.note_nodejs_postgressql.DetailsActivity.Model.Client_Details;
import com.duongvyluan.note_nodejs_postgressql.DetailsActivity.View.View_Details;


/**
 * Created by JohnDuong on 21-Sep-17.
 */

public class PresenterLogic_Details implements PresenterImplements_Details{
    private Context context;
    private View_Details view;
    public PresenterLogic_Details(View_Details view,Context context){
        this.context=context;
        this.view=view;
    }
    @Override
    public void sendNote(String urlLink, String params1, String value1, String params2, String value2) {
        Client_Details client_details=new Client_Details(context,this);
        client_details.sendPost(urlLink,params1,value1,params2,value2);
    }

    @Override
    public void POSTSuccess(String message) {
        view.onPostSuccess(message);
    }

    @Override
    public void POSTFailure(String message) {
        view.onPostFailure(message);
    }

}
