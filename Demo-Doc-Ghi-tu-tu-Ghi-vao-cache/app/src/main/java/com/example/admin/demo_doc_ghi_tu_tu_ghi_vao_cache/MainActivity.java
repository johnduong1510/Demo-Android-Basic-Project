package com.example.admin.demo_doc_ghi_tu_tu_ghi_vao_cache;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button)findViewById(R.id.button);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream in =openFileInput("a.jpg");//doc
                    FileOutputStream out=openFileOutput("b.jpg", MODE_PRIVATE);

                    byte[] buffer=new byte[1024];
                    int len=0;

                    while((len=in.read(buffer))>0)
                    {
                        out.write(buffer,0,len);
                    }
                    Toast.makeText(MainActivity.this,"Complete",Toast.LENGTH_SHORT);
                    in.close();
                    out.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                File dd=getApplication().getCacheDir();
                File taptin=new File(dd+"/"+"a.txt");


            }
        });


    }
}
