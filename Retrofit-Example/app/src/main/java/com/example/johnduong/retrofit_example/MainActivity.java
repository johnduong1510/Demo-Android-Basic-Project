package com.example.johnduong.retrofit_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Retrofit.Builder().baseUrl("http://vuonthongminh.esy.es/template1/lib/data.json").build();
    }
}
