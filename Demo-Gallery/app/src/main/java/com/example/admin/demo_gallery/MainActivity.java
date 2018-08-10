package com.example.admin.demo_gallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Gallery;

public class MainActivity extends AppCompatActivity {
    Gallery gl;
    String []item=new String[]{"cam","xoai","coc","oi","mia ghim"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gl=(Gallery)findViewById(R.id.gallery);

        //ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_gallery_item,item);
        ArrayAdapter<Integer>
        gl.setAdapter(arrayAdapter);

    }
}
