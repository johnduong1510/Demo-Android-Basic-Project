package com.example.admin.demo_hashmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    TextView kq;
    EditText input;
    Button btNhap,btTim,btClearText,btClearData;
    HashMap<String,String> hashMap=new HashMap<String,String>();
    String[] mang=new String[50];
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btNhap=(Button)findViewById(R.id.button);
        btTim=(Button)findViewById(R.id.button2);
        btClearText=(Button)findViewById(R.id.button3);
        btClearData=(Button)findViewById(R.id.button4);
        input=(EditText)findViewById(R.id.editText);
        kq=(TextView)findViewById(R.id.textView2);
        kq.setText("");


        btNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kq.setText("");
                try {
                    mang = input.getText().toString().split(":");
                    hashMap.put(mang[0], mang[1]);
                }
                catch (Exception e){}
                kq.append(input.getText().toString()+"\n");
            }
        });

        btTim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kq.setText("");
                try {
                    String key = input.getText().toString();
                    String value;
                    value = hashMap.get(key);
                    if(hashMap.containsKey(key)==false) kq.setText("Khong co du lieu");
                    else kq.setText(key+"\n"+value);

                }
                catch (Exception e){}

            }
        });

        btClearText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kq.setText("");
                input.setText("");
            }
        });

        btClearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key=input.getText().toString();
                hashMap.remove(key);
                kq.setText("");
                input.setText("");
            }
        });
    }
}
