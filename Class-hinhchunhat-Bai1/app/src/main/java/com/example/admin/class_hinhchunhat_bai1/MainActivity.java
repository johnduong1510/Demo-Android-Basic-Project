package com.example.admin.class_hinhchunhat_bai1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView kq,kqhv;
    Button bt,bt2;
    EditText inputcd,inputcr,inputhv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button)findViewById(R.id.button);
        bt2=(Button)findViewById(R.id.button2);
        inputcd=(EditText)findViewById(R.id.editText);
        inputcr=(EditText)findViewById(R.id.editText2);
        inputhv=(EditText)findViewById(R.id.editText3) ;
        kqhv=(TextView)findViewById(R.id.textView5);
        kq=(TextView)findViewById(R.id.textView3);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int chieudai=1;
                int chieurong=1;
                try {
                    chieudai = Integer.parseInt(inputcd.getText().toString());
                    chieurong = Integer.parseInt(inputcr.getText().toString());
                }
                catch (Exception e){}
                HinhChuNhat hcn=new HinhChuNhat(chieudai,chieurong);
                String thongtin=hcn.getInfo();
                kq.setText(thongtin);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int canh=Integer.parseInt(inputhv.getText().toString());
                hinhvuong hinhVuong=new hinhvuong(canh);
                kqhv.setText(hinhVuong.getInfo());
            }
        });
    }
}
