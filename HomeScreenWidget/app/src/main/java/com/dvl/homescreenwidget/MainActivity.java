package com.dvl.homescreenwidget;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
   ListView listView;
    String item[]=new String[]{"1","2","3","4","5","6"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listView);

        ArrayAdapter<String> mang=new ArrayAdapter<String>(MainActivity.this,R.layout.listitem,R.id.textView,item);
        listView.setAdapter(mang);
        SharedPreferences sharedPreferences=getSharedPreferences("noidung",MODE_APPEND);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("noidung","123");
        editor.commit();


    }
}
