package com.example.admin.demo_call_another_activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bt1,bt2;
    Spinner spinner;
    int position;
    String[] mang=new String[]{"Open Browser","Call","Dial","Take Picture","Show Contacts","Edit Contacts"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=(Button)findViewById(R.id.button);
        bt2=(Button)findViewById(R.id.button2);
        spinner=(Spinner)findViewById(R.id.spinner);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,mang);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
        spinner.setAdapter(arrayAdapter);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(v.getContext(),MainActivity2.class);
                startActivity(i);
                finish();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=spinner.getSelectedItemPosition();
                Intent intent=null;
                switch (position)
                {
                    case 0: intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.zing.vn"));
                        break;
                    case 1: intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:0932360312"));
                        break;
                    case 2: intent=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:0932360312"));
                        break;
                    case 3: intent=new Intent("android.media.action.IMAGE_CAPTURE");
                        break;
                    case 4: intent=new Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people"));
                        break;
                    case 5: intent=new Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people/1"));
                        break;
                }
                if(intent!=null) startActivity(intent);
            }
        });



    }
}
