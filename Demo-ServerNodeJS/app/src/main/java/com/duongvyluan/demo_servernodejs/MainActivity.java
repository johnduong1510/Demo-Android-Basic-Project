package com.duongvyluan.demo_servernodejs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button buttonAdd,buttonUpdate,buttonDelete,buttonRead;
    EditText edt_username,edt_password;
   // String url="http://localhost:3000/";
   // String urlBase="http://10.0.2.2:3000/";
    String urlBase="https://demo-webservice-nodejs.herokuapp.com/";
    String urlAdd=urlBase+"add";
    String urlRead=urlBase+"read";
    String urlDelete=urlBase+"delete";
    String urlUpdate=urlBase+"update";

    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textView);
        buttonAdd=(Button)findViewById(R.id.btn_Add);
        buttonUpdate=(Button)findViewById(R.id.btn_Update);
        buttonDelete=(Button)findViewById(R.id.btn_Delete);
        buttonRead=(Button)findViewById(R.id.btn_Read);
        edt_username=(EditText)findViewById(R.id.edt_Username);
        edt_password=(EditText)findViewById(R.id.edt_Password);

        StringRequest stringRequest=new StringRequest(StringRequest.Method.GET, urlBase, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                textView.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error+"",Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username=edt_username.getText().toString();
                final String password=edt_password.getText().toString();
                Log.v("log",username+" "+password);
                Log.v("log",urlAdd);
                StringRequest addPostRequest=new StringRequest(StringRequest.Method.POST, urlAdd, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textView.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,error+"",Toast.LENGTH_SHORT).show();
                    }
                }
                ){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String,String> params=new HashMap<String, String>();
                        params.put("u",username);
                        params.put("p",password);
                        return params;
                    }
                };
                requestQueue.add(addPostRequest);
            }
        });


        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username=edt_username.getText().toString();
                final String password=edt_password.getText().toString();
                StringRequest updatePostRequest=new StringRequest(StringRequest.Method.POST, urlUpdate,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                textView.setText(response);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,error+"",Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String,String>params=new HashMap<String, String>();
                        params.put("u",username);
                        params.put("p",password);
                        return params;
                    }
                };
                requestQueue.add(updatePostRequest);
            }
        });

        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonObjectRequest jsonObjectRequest =new JsonObjectRequest(StringRequest.Method.POST, urlRead
                        , null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            textView.setText(response.getString("users"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                requestQueue.add(jsonObjectRequest);
            }
        });
    }

}
