package com.example.admin.demo_custom_toast;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button)findViewById(R.id.button);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                custom_toast();
            }
        });
    }

    void custom_toast()
    {
        LayoutInflater inflater=getLayoutInflater();
        View v=inflater.inflate(R.layout.toast_layout,null);
        ImageView imageView=(ImageView)v.findViewById(R.id.imageView);
        TextView textView=(TextView)v.findViewById(R.id.textView);
        imageView.setImageResource(R.mipmap.ic_launcher);
        textView.setText("Day la Custom Toast");
        Toast t=new Toast(MainActivity.this);
        t.setGravity(Gravity.BOTTOM | Gravity.CENTER,0,10);
        t.setDuration(Toast.LENGTH_LONG);
        t.setView(v);
        t.show();
    }

}
