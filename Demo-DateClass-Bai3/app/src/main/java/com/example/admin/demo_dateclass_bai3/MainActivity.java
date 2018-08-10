package com.example.admin.demo_dateclass_bai3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView kq;
    Button bt;
    EditText inputngayden,inputngaydi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kq=(TextView)findViewById(R.id.textView3);
        bt=(Button)findViewById(R.id.button);
        inputngayden=(EditText)findViewById(R.id.editText);
        inputngaydi=(EditText)findViewById(R.id.editText2);
        kq.setText("");


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kq.setText("");
                SimpleDateFormat sdf=new SimpleDateFormat();
                sdf.applyPattern("dd/MM/yyyy");
                sdf.setLenient(true);
                Date ngaydi=new Date();
                Date ngayden = new Date();
                try{
                    ngayden=sdf.parse(inputngayden.getText().toString());
                    ngaydi=sdf.parse(inputngaydi.getText().toString());
                }
                catch(Exception e){}
                kq.setText("Ngay den : "+ngayden.getDate()+" thang "+(ngayden.getMonth()+1)+" nam "+(ngayden.getYear()+1900)+"\n"
                +"Ngay di: "+ngaydi.getDate() +" thang "+(ngaydi.getMonth()+1)+" nam "+(ngaydi.getYear()+1900)
                );

                kq.append("\n"+"Tong so ngay di: "+(ngaydi.getTime()-ngayden.getTime())/1000/60/60/24);

            }
        });
    }
}
