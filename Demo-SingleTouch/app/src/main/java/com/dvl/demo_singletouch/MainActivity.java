package com.dvl.demo_singletouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        /*
        SingleTouch singleTouch=new SingleTouch(MainActivity.this);
        setContentView(singleTouch);
        singleTouch.postInvalidate();
        */

        setContentView(new SingleTouch(MainActivity.this));
    }
}
