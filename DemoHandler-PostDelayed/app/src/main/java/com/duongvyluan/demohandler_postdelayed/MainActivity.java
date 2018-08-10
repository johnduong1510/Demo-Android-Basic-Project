package com.duongvyluan.demohandler_postdelayed;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    TextView tv_countdown,tv_json;
    Button btn_start;
    private int mTime = 50;
    String link="http://vuonthongminh.esy.es/template1/lib/data.json";
    Handler myHandler;
    DemNguocRunnable demNguocRunnable;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_countdown=(TextView)findViewById(R.id.tv_countdown);
        tv_json=(TextView)findViewById(R.id.tv_json);
        btn_start=(Button)findViewById(R.id.btn_start);
        myHandler=new Handler();
        demNguocRunnable=new DemNguocRunnable();

        requestQueue= Volley.newRequestQueue(getApplicationContext());

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDemNguoc();
            }
        });
    }
    private void showDemNguoc() {
        mTime=50;
        myHandler.removeCallbacks(demNguocRunnable);
        myHandler.postDelayed(demNguocRunnable, 1000);
    }
    private void handleDemnguoc() {
        mTime--;
        if (mTime == 0)
            mTime = 50;
        tv_countdown.setText(mTime + "");
        myHandler.postDelayed(demNguocRunnable, 1000);
    }
    private void useGet(String link)
    {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, link, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                tv_json.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error+"",Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(stringRequest);
    }
    private class DemNguocRunnable implements Runnable{

        @Override
        public void run() {
            handleDemnguoc();
            tv_json.setText("");
            useGet(link);
        }
    }

}
