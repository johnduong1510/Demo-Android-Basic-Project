package com.dvl.chiecnonkydieu_deme_animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button bt;
    TextView tv;
    ImageView iv;
    float dau = 0, cuoi;
    int dolech, phan;
    int min = 3, max =4 ;
    int mang[] = {-1, 350, 250, 500, 100, 300,
            800, 500, 700, -1, 200, 500,
            900, 300, 250, 900, 200, 400,
            550, 200, 500, -1, 600, 200};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.imageView);
        bt = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.textView);
        min=min*360;
        max=max*360;

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cuoi = (int) (Math.random() * (max - min + 1)) + min;
                dolech = (int) cuoi % 360;
                phan = dolech / (360 / mang.length);////15 la so do cua mot phan (360/24)
                RotateAnimation HoatHinh = new RotateAnimation(dau, cuoi, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                HoatHinh.setDuration(3000);
                HoatHinh.setFillAfter(true);
                iv.startAnimation(HoatHinh);
                dau=dolech;
                HoatHinh.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        tv.setText("dau: "+dau+" cuoi: "+cuoi+ " do lech: "+dolech+" Diem: "+mang[phan]);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });


    }
}
