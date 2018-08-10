package com.dvl.demo_cac_animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button btAlphaAnimation, btRotateAnimation, btScaleAnimation, btTranslateAnimation, btSetAnimation,
            btInterpolator;
    Animation HoatHinh;
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        btAlphaAnimation = (Button) findViewById(R.id.button);
        btRotateAnimation = (Button) findViewById(R.id.button2);
        btScaleAnimation = (Button) findViewById(R.id.button3);
        btTranslateAnimation = (Button) findViewById(R.id.button4);
        btSetAnimation = (Button) findViewById(R.id.button5);
        btInterpolator = (Button) findViewById(R.id.button6);


        btAlphaAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //HoatHinh= AnimationUtils.loadAnimation(MainActivity.this,R.anim.demo_alpha_animation);
                if (flag) HoatHinh = new AlphaAnimation(1.0f, 0.1f);
                else HoatHinh = new AlphaAnimation(0.1f, 1.0f);
                HoatHinh.setDuration(1500);
                HoatHinh.setFillAfter(true);
                textView.startAnimation(HoatHinh);
                flag = !flag;
            }
        });


        btRotateAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HoatHinh = new RotateAnimation(0.0f, -270f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                HoatHinh.setDuration(2000);
                HoatHinh.setFillAfter(true);
                textView.startAnimation(HoatHinh);
            }
        });


        btScaleAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HoatHinh = new ScaleAnimation(textView.getScaleX(), 3.0f, textView.getScaleY(), 3.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                HoatHinh.setDuration(3000);
                HoatHinh.setFillAfter(true);
                textView.startAnimation(HoatHinh);
            }
        });


        btTranslateAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HoatHinh = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 2.0f
                        , Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                HoatHinh.setDuration(2000);
                HoatHinh.setFillAfter(true);
                textView.startAnimation(HoatHinh);
            }
        });

        btSetAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HoatHinh = new AnimationUtils().loadAnimation(MainActivity.this, R.anim.set_animation);
                textView.startAnimation(HoatHinh);
            }
        });

        btInterpolator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // HoatHinh=new TranslateAnimation(Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,3.0f,
                //Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
                // HoatHinh.setDuration(2000);
                // HoatHinh.setFillAfter(false);
                //HoatHinh.setInterpolator(new AccelerateInterpolator());

                HoatHinh = new AnimationUtils().loadAnimation(MainActivity.this, R.anim.set2_animation);
                HoatHinh.setInterpolator(new AnticipateInterpolator());
                textView.startAnimation(HoatHinh);
            }
        });
    }

}
