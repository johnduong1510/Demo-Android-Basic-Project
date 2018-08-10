package com.dvl.dochinhanhtuantututhenho_contentprovider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button bt;
    TextView tv;

    int soluong=0;
    int index=0;
    ArrayList<String> mang=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.textView);
        bt=(Button)findViewById(R.id.button);
        imageView=(ImageView)findViewById(R.id.imageView);

        ContentResolver contentResolver=this.getContentResolver();
       // Cursor cursor=contentResolver.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI,null,null,null,null);
        Cursor cursor=contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,null,null,null,null);
        soluong=cursor.getCount();


        cursor.moveToFirst();
        for(int i=0;i<soluong;i++)
        {
           // int cotthu=cursor.getColumnIndex(MediaStore.Images.Thumbnails.DATA);
            int cotthu=cursor.getColumnIndex(MediaStore.Images.Media.DATA);
            String src=cursor.getString(cotthu);
            mang.add(src);
            cursor.moveToNext();
        }
        cursor.close();

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String src=mang.get(index);
                imageView.setImageURI(Uri.parse(src));
                tv.setText(src);
                index++;
                if(index==soluong) index=0;
            }
        });
    }
}
