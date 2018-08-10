package com.example.admin.input_output_assets_th_09_bai2_doc_ghi_du_lieu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    EditText input;
    Button btClear,btWrite,btLoad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input=(EditText)findViewById(R.id.editText);
        btClear=(Button)findViewById(R.id.button);
        btWrite=(Button)findViewById(R.id.button2);
        btLoad=(Button)findViewById(R.id.button3);

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
            }
        });

        btWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream out=openFileOutput("dulieu.txt",MODE_APPEND);
                    String chuoi=input.getText().toString();
                    out.write(chuoi.getBytes());
                    out.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        btLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream in=openFileInput("dulieu.txt");
                    int size=in.available();
                    byte[] buffer=new byte[size];
                    in.read(buffer);
                    String chuoi=new String(buffer);
                    input.setText(chuoi);
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
