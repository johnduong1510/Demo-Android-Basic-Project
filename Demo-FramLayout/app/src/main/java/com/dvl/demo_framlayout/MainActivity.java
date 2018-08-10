package com.dvl.demo_framlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    FrameLayout frameLayout;
    int manghinhbai[]={

            R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4, R.drawable.c5,
            R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
            R.drawable.cj,R.drawable.cq,R.drawable.ck,
            R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,
            R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,
            R.drawable.dj,R.drawable.dq,R.drawable.dk,
            R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,
            R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,
            R.drawable.hj,R.drawable.hq,R.drawable.hk,
            R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,
            R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,
            R.drawable.sj,R.drawable.sq,R.drawable.sk
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout=(FrameLayout)findViewById(R.id.framelayout);

        for(int i=0;i<13;i++)
        {
            ImageView imageView=new ImageView(MainActivity.this);
            imageView.setImageResource(manghinhbai[i]);
            FrameLayout.LayoutParams layoutParams=new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(i*20+20*i,30,10,10);
            imageView.setLayoutParams(layoutParams);
            frameLayout.addView(imageView);
            imageView.setTag(i);
            imageView.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        ImageView imageView=(ImageView)v;
        FrameLayout.LayoutParams layoutParams=(FrameLayout.LayoutParams)imageView.getLayoutParams();
        if(layoutParams.topMargin==30) layoutParams.topMargin=layoutParams.topMargin-20;
        else layoutParams.topMargin=layoutParams.topMargin+20;
        imageView.setLayoutParams(layoutParams);
        int vt= (int) imageView.getTag();
        Toast.makeText(MainActivity.this,vt+" ",Toast.LENGTH_SHORT).show();
       // frameLayout.removeView(v);
    }
}
