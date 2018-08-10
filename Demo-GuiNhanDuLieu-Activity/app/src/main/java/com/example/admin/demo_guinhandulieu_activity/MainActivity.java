package com.example.admin.demo_guinhandulieu_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button bt;
    EditText editText;
    TextView tv;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==999 && resultCode==RESULT_OK)
        {
            tv.setText(data.getExtras().getString("content"));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button)findViewById(R.id.button);
        editText=(EditText)findViewById(R.id.editText);
        tv=(TextView)findViewById(R.id.textView2);
    /*
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(v.getContext(),Main2Activity.class);
                i.putExtra("content",editText.getText().toString());
                startActivity(i);//goi ma khong tra ve
            }
        });
     */

        /*
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HinhChuNhat a=new HinhChuNhat(3,5);
                startActivity(new Intent(MainActivity.this,Main2Activity.class).putExtra("hcn",a));
            }
        });
        */

        //gui du lieu co tra ve
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this,Main2Activity.class).putExtra("content",editText.getText().toString()),999);
            }
        });

    }
}
