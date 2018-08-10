package com.example.admin.demo_chuoi_bai5;

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
    String chuoi1,chuoi2,chuoi3,chuoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kq=(TextView)findViewById(R.id.textView2);
        bt=(Button)findViewById(R.id.button);
        input=(EditText)findViewById(R.id.editText);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kq.setText("");
                chuoi=input.getText().toString();
                chuoi=chuoi.trim();
                chuoi1=chuoi.toUpperCase();
                kq.append(chuoi1+"\n");

                chuoi2=chuoi.toLowerCase();
                kq.append(chuoi2+"\n");

                char[] tam=new char[chuoi.length()];
                chuoi=chuoi.toLowerCase();
                tam=chuoi.toCharArray();

                chuoi3="";
                tam[0]=Character.toUpperCase(tam[0]);

                chuoi3=chuoi3.toUpperCase();
                for(int i=1;i<tam.length;i++)
                {
                    if(tam[i]==' ')
                    {
                        tam[i+1]=Character.toUpperCase(tam[i+1]);
                    }

                }
                chuoi3=new String(tam);
                kq.append(chuoi3);


            }
        });
    }
}
