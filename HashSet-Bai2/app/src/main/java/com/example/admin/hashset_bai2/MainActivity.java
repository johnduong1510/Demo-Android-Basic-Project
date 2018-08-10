package com.example.admin.hashset_bai2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    TextView kq;
    Button bt;
    EditText input;
    HashSet<String> hashSet=new HashSet<String>();
    ArrayList<String> arrayList=new ArrayList<String>();
    String[] mang=new String[7];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button)findViewById(R.id.button);
        input=(EditText)findViewById(R.id.editText);
        kq=(TextView)findViewById(R.id.textView2);
        kq.setText("");

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kq.setText("");
                arrayList.clear();
                hashSet.clear();

                mang=input.getText().toString().split(" ");
                //them vao hashSet va ArrayList
                for(String item:mang)
                {
                    hashSet.add(item);
                    if(arrayList.contains(item)==false) arrayList.add(item);
                }
                //duyet hashset
                Iterator ite;
                ite=hashSet.iterator();
                String chuoi="HashSet: ";
                while(ite.hasNext())
                {
                    chuoi+=ite.next().toString()+ " ";
                }
                chuoi+="\nArrayList: ";
                for(String item:arrayList)
                {
                    chuoi+=item+" ";
                }
                kq.setText(chuoi);
            }
        });


    }
}
