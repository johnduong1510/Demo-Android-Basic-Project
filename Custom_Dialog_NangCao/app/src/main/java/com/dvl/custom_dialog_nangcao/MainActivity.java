package com.dvl.custom_dialog_nangcao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button bt;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button)findViewById(R.id.button);
        tv=(TextView)findViewById(R.id.textView);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyCustomDialog dialog=new MyCustomDialog();
                dialog.setCancelable(true);
                dialog.show(getFragmentManager(),"customdialog");
            }
        });
    }
    public void dialogtrave(String chuoi)
    {
        tv.setText(chuoi);
    }
}
