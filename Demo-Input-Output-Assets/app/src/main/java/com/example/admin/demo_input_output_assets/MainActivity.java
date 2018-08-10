package com.example.admin.demo_input_output_assets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.textView);
        try {
            InputStream inputStream=getAssets().open("test.txt",MODE_PRIVATE);
            int size=inputStream.available();
            byte[] buffer=new byte[size];
            inputStream.read(buffer);
            String chuoi=new String(buffer);
            tv.setText(chuoi);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
