package com.example.admin.demo_spinner_xml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner,spinner2;
    TextView tv;
    String[] item=new String[]{"cam","xoai","coc","oi","mia"};
    ArrayList<String> item2;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=(Spinner)findViewById(R.id.spinner);
        spinner2=(Spinner)findViewById(R.id.spinner2);
        tv=(TextView)findViewById(R.id.textView);
        bt=(Button)findViewById(R.id.button);
        item2=new ArrayList<String>();
    /* C1 su dung mang String
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);

        spinner2.setAdapter(arrayAdapter);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tv.setText(item[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tv.setText("Khong co du lieu duoc chon");
            }
        });
    */

     /*   C2 du sung ArrayList
        item2.add("cam");
        item2.add("chanh");
        item2.add("chanh day");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,item2);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);

        spinner2.setAdapter(arrayAdapter);
    */
        final ArrayList<String> item3=new ArrayList<String>();
        item3.add("coc");
        item3.add("mia ghim");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,item3);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);

        spinner2.setAdapter(arrayAdapter);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(spinner2.getSelectedItem().toString());
            }
        });

    }
}
