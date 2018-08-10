package com.example.admin.tachhoten_chuoi_bai6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView kq;
    Button bt;
    EditText input;
    String chuoi="";
    String ho,ten;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input=(EditText)findViewById(R.id.editText);
        bt=(Button)findViewById(R.id.button);
        kq=(TextView)findViewById(R.id.textView2);
        input.setText(""); kq.setText("");

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chuoi=input.getText().toString();
                chuoi=chuoi.trim();
                ho=chuoi.substring(0,chuoi.lastIndexOf(" "));
                ten=chuoi.substring(chuoi.lastIndexOf(" "),chuoi.length());

                kq.setText("Họ và tên đệm: "+ho);
                kq.append("\n"+"Ten: "+ten);
            }
        });
    }
}
