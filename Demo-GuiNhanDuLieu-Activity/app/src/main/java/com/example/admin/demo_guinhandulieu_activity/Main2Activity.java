package com.example.admin.demo_guinhandulieu_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    Button bt;
    EditText editText;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bt=(Button)findViewById(R.id.button);
        editText=(EditText)findViewById(R.id.editText);
        tv=(TextView)findViewById(R.id.textView2);


        //tv.setText(getIntent().getExtras().getString("content"));
        //HinhChuNhat a=(HinhChuNhat)getIntent().getExtras().getSerializable("hcn");
        //tv.setText("cd: "+a.cd+" cr: "+a.cr);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                String content=getIntent().getExtras().getString("content");
                content+="123456";
                i.putExtra("content",content);
                setResult(RESULT_OK,i);
                finish();

            }
        });
    }
}
