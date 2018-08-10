package com.example.johnduong.callauto;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edt_Number;
    Button btn_Call, btn_Save;
    ListView listViewCallNumber;
    SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_Number = (EditText) findViewById(R.id.edt_Number);
        btn_Call = (Button) findViewById(R.id.btn_Call);
        btn_Save = (Button) findViewById(R.id.btn_Save);
        listViewCallNumber = (ListView) findViewById(R.id.listview_CallNumber);


        sqLiteHelper=new SQLiteHelper(MainActivity.this);
        sqLiteHelper.insertData("123","123");

        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("call_number", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if (!edt_Number.getText().toString().isEmpty()) {
                    editor.putString("number", edt_Number.getText().toString().trim());
                    editor.apply();
                    editor.commit();
                    ArrayList<String> list = new ArrayList<>();
                    list.add(edt_Number.getText().toString());
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                            (MainActivity.this, android.R.layout.simple_list_item_1, list);
                    listViewCallNumber.setAdapter(arrayAdapter);
                }
            }
        });

        btn_Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + edt_Number.getText().toString().trim()));
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(callIntent);
            }
        });

        listViewCallNumber.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences sharedPreferences = getSharedPreferences("call_number", MODE_PRIVATE);
                edt_Number.setText(sharedPreferences.getString("number",""));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(!edt_Number.getText().toString().isEmpty())
        {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + edt_Number.getText().toString().trim()));
            if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            startActivity(callIntent);
        }
        else {
            SharedPreferences sharedPreferences = getSharedPreferences("call_number", MODE_PRIVATE);
            String number = sharedPreferences.getString("number", "");
            if (number.isEmpty()) return;
            ArrayList<String> list = new ArrayList<>();
            list.add(number);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                    (MainActivity.this, android.R.layout.simple_list_item_1, list);
            listViewCallNumber.setAdapter(arrayAdapter);
        }
    }

}
