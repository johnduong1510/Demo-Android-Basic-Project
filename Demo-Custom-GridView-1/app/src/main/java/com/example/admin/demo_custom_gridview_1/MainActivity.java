package com.example.admin.demo_custom_gridview_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<Integer>ds=new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=(GridView)findViewById(R.id.gridView);
        ds.add(R.drawable.car01);
        ds.add(R.drawable.car02);
        ds.add(R.drawable.car03);
        ds.add(R.drawable.car04);
        ds.add(R.drawable.car05);
        ds.add(R.drawable.car06);

        MyAdapter myAdapter=new MyAdapter(MainActivity.this,ds);
        gridView.setAdapter(myAdapter);
    }
}
