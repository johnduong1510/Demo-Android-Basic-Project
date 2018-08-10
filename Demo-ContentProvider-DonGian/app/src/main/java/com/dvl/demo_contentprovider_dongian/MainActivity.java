package com.dvl.demo_contentprovider_dongian;

import android.content.ContentResolver;
import android.database.Cursor;
import android.media.audiofx.BassBoost;
import android.provider.Settings;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listView);

        ContentResolver contentResolver=getContentResolver();
        Cursor cursor=contentResolver.query(Settings.System.CONTENT_URI,null,null,null,null);

        SimpleCursorAdapter adapter=new SimpleCursorAdapter(MainActivity.this,R.layout.mot_hang,cursor,
                new String[]{Settings.System.NAME,Settings.System.VALUE}
                ,new int[]{R.id.textView,R.id.textView2});

        listView.setAdapter(adapter);
    }
}
