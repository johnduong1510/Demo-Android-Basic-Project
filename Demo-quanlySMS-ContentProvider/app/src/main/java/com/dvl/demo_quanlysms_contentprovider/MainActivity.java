package com.dvl.demo_quanlysms_contentprovider;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btSendIntent, btSendAPI, btRead;
    ListView listView;
    EditText editText;
    ArrayList<String> ds = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btSendIntent = (Button) findViewById(R.id.button);
        btSendAPI = (Button) findViewById(R.id.button2);
        btRead = (Button) findViewById(R.id.button3);
        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editText);
        //gui SMS co 2 cach, 1 la gui bang Intent, 2 bang API (nhap cap quyen trong Manifest)
        btSendIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.putExtra("sms_body", "default content");
                sendIntent.setType("vnd.android-dir/mms-sms");
                startActivity(sendIntent);
            }
        });

        btSendAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(editText.getText().toString(), null, "Testing auto sms", null, null);
                    Toast.makeText(getApplicationContext(), "SMS Sent", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "SMS Failed", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        btRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Uri.parse("content://sms/inbox");//doc thong tin tu inbox
                //Uri.parse("content://sms/draft");
                Uri uri = Uri.parse("content://sms/sent");
                String[] from = new String[]{"_id", "address", "body"};
                Cursor cursor = getContentResolver().query(uri,from,null,null,null);

                ds.clear();
                if (cursor != null) {
                    if(cursor.moveToFirst())
                    {
                        do {
                            ds.add(cursor.getColumnName(0)+":"+cursor.getString(1)+":"+cursor.getString(2));
                        }
                        while(cursor.moveToNext());
                        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,ds);
                        listView.setAdapter(adapter);
                    }
                    else
                    {
                        //empty box,no SMS
                    }
                    cursor.close();
                }

            }
        });
    }
}
