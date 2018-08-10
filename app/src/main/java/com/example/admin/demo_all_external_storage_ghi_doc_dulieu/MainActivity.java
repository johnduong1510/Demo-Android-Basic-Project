package com.example.admin.demo_all_external_storage_ghi_doc_dulieu;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button btGhiExternalNoneRemoveable,btDocExternalNoneRemoveable;
    EditText input;
    TextView kq;
    String chuoi="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input=(EditText)findViewById(R.id.editText);
        kq=(TextView)findViewById(R.id.textView2);
        btGhiExternalNoneRemoveable=(Button)findViewById(R.id.button);
        btDocExternalNoneRemoveable=(Button)findViewById(R.id.button2);

        btGhiExternalNoneRemoveable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File duongdan=Environment.getExternalStorageDirectory();
                File taptin=new File(duongdan,"abc.txt");
                try {
                    FileOutputStream out=new FileOutputStream(taptin);
                    chuoi+=input.getText().toString();
                    out.write(chuoi.getBytes());
                    out.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btDocExternalNoneRemoveable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File duongdan=Environment.getExternalStorageDirectory();
                File taptin=new File(duongdan,"abc.txt");
                try {
                    FileInputStream in=new FileInputStream(taptin);
                    int size=in.available();
                    byte[] buffer=new byte[size];
                    in.read(buffer);
                    String tam=new String(buffer);
                    kq.setText(tam);
                    in.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
