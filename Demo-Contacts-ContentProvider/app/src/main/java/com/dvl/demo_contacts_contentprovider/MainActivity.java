package com.dvl.demo_contacts_contentprovider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btAdd;
    EditText et_Name,et_Mail,et_PhoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btAdd=(Button)findViewById(R.id.button);
        et_Name=(EditText)findViewById(R.id.editText);
        et_Mail=(EditText)findViewById(R.id.editText2);
        et_PhoneNumber=(EditText)findViewById(R.id.editText3);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addContact();
            }
        });
    }

    private void addContact() {
        
    }
}
