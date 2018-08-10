package com.duongvyluan.note_nodejs_postgressql.SummaryActivity.Presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.duongvyluan.note_nodejs_postgressql.SummaryActivity.Model.Client_Summary;
import com.duongvyluan.note_nodejs_postgressql.SummaryActivity.Model.Object_Note;
import com.duongvyluan.note_nodejs_postgressql.SummaryActivity.View.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JohnDuong on 21-Sep-17.
 */

public class PresenterLogicSummary implements PresenterInterface_Summary {
    private View view;
    private Context context;

    public PresenterLogicSummary(View view, Context context) {
        this.view = view;
        this.context = context;
    }


    @Override
    public void sendPost(String urlLink, String params1, String value1, String params2, String value2) {
        Client_Summary client_summary=new Client_Summary(context,this);
        client_summary.sendPost(urlLink,params1,value1,params2,value2);
    }

    @Override
    public void onPOSTSuccess(String message) {
        try {
            JSONObject jsonObject=new JSONObject(message);
            String method=jsonObject.getString("method");
            switch (method)
            {
                case "addUser":
                    if(jsonObject.getInt("kq")==1) {
                        SharedPreferences sharedPreferences=context.getSharedPreferences("login",Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("username",jsonObject.getString("username"));
                        editor.putString("password",jsonObject.getString("password"));
                        editor.apply();
                        view.onPOSTSuccess("Register success");
                    }
                    else view.onPOSTFailure("Register failure");
                    break;
                case "readNotes":
                    //Todo: Convert json to Object Note and add to recyclerview. Delete dump data
                    List<Object_Note> data=new ArrayList<>();
                    data.add(new Object_Note(0,"title1","content1"));
                    view.addDataRecyclerView(data);
                    break;
                default:break;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onPOSTFailure(String message) {
        view.onPOSTFailure(message);
    }

}
