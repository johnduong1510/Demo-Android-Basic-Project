package com.example.admin.class_student_bai3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView kq;
    Button btNhap,btShow;
    EditText getTen,getMSSV;
    ArrayList<SinhVien> SV=new ArrayList<SinhVien>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btNhap=(Button)findViewById(R.id.button);
        btShow=(Button)findViewById(R.id.button2);
        getTen=(EditText)findViewById(R.id.editText);
        getMSSV=(EditText)findViewById(R.id.editText2);
        kq=(TextView)findViewById(R.id.textView3);
        //khoi tao ban dau
        getMSSV.setText("");
        getTen.setText("");
        kq.setText("");
        //
        btShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kq.setText("");
                try {
                    int key = Integer.parseInt(getMSSV.getText().toString());
                    for (int i = 0; i < SV.size(); i++) {
                        if (SV.get(i).getStudent_id() == key) kq.setText(SV.get(i).getInfo(key));
                    }
                } catch (Exception e) {}
            }
        });

        btNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kq.setText("");
                try {
                    SV.add(new SinhVien(Integer.parseInt(getMSSV.getText().toString()), getTen.getText().toString()));
                }
                catch (Exception e){}
                getTen.setText("");
                getMSSV.setText("");
            }
        });
    }
}
