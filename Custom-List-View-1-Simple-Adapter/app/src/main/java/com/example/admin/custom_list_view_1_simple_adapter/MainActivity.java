package com.example.admin.custom_list_view_1_simple_adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String[] ten=new String[] {"Giay Walu Ancent","Giay 2","Giay 3","giay 4","giay 5"};
    int[] size=new int[] {1,2,3,4,5,6,7};
    int[] hinh=new int[] {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.h1,R.drawable.h3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listView);
        ArrayList<HashMap<String,Object>> ds=new ArrayList<HashMap<String,Object>>();

        for(int i=0;i<5;i++) {
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put("ten", "Ten: "+ten[i]);
            hashMap.put("size", "Size: "+size[i]);
            hashMap.put("hinh", hinh[i]);
            ds.add(hashMap);
        }

        String[] from=new String[] {"hinh","ten","size"};
        int[] to=new int[] {R.id.imageView,R.id.textView,R.id.textView2};
        SimpleAdapter simpleAdapter=new SimpleAdapter(MainActivity.this,ds,R.layout.one_item,from,to);

        listView.setAdapter(simpleAdapter);






    }
}
