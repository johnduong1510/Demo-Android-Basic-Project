package com.duongvyluan.note_nodejs_postgressql.DetailsActivity.Model;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.duongvyluan.note_nodejs_postgressql.DetailsActivity.Presenter.PresenterImplements_Details;
import com.duongvyluan.note_nodejs_postgressql.SummaryActivity.Presenter.PresenterInterface_Summary;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JohnDuong on 21-Sep-17.
 */

public class Client_Details {
    private RequestQueue requestQueue;
    private StringRequest stringRequest;
    private Context context;
    private PresenterImplements_Details presenterImplements_details;

    public Client_Details(Context context, PresenterImplements_Details presenterImplements_details){
        this.context=context;
        this.presenterImplements_details =presenterImplements_details;
    }

    public void sendPost(String urlLink, final String params1, final String value1, final String params2, final String value2)
    {
        requestQueue=Volley.newRequestQueue(context);
        stringRequest=new StringRequest(Request.Method.POST, urlLink, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                presenterImplements_details.POSTSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                presenterImplements_details.POSTFailure(error+"");
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
