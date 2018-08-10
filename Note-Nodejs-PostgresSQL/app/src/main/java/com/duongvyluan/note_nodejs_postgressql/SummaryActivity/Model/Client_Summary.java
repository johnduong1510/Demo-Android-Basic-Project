package com.duongvyluan.note_nodejs_postgressql.SummaryActivity.Model;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.duongvyluan.note_nodejs_postgressql.SummaryActivity.Presenter.PresenterInterface_Summary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JohnDuong on 21-Sep-17.
 */

public class Client_Summary {
    private RequestQueue requestQueue;
    private StringRequest stringRequest;
    private Context context;
    private PresenterInterface_Summary presenterInterfaceSummary;

    public Client_Summary(Context context, PresenterInterface_Summary presenterInterface){
        this.context=context;
        this.presenterInterfaceSummary =presenterInterface;
        requestQueue=Volley.newRequestQueue(context);
    }

    public void sendPost(String urlLink, final String params1, final String value1, final String params2, final String value2)
    {
        stringRequest=new StringRequest(Request.Method.POST, urlLink, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("LOG","onResponse: "+response);
                presenterInterfaceSummary.onPOSTSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                presenterInterfaceSummary.onPOSTFailure(error+"");
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> params=new HashMap<>();
                params.put(params1,value1);
                params.put(params2,value2);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
