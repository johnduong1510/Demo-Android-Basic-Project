package com.example.admin.demo_data_storage_shared_preferences;

import android.content.SharedPreferences;
import android.support.annotation.BoolRes;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView kq;
    EditText input;
    Button btSave,btLoad;
    Switch sw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sw=(Switch)findViewById(R.id.switch1);
        btSave=(Button)findViewById(R.id.button);
        btLoad=(Button)findViewById(R.id.button2);
        kq=(TextView)findViewById(R.id.textView);
        input=(EditText)findViewById(R.id.editText);

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences ghi=getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor=ghi.edit();
                editor.putBoolean("switch",sw.isChecked());
                editor.putString("noidung",input.getText().toString());
                editor.commit();
            }
        });

        btLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences doc=getPreferences(MODE_PRIVATE);
                String noidung=doc.getString("noidung","chua co noi dung");
                boolean sw=doc.getBoolean("switch",false);
                kq.setText("Noi dung: "+noidung+" | "+"Switch: "+sw);
            }
        });
    }
}
