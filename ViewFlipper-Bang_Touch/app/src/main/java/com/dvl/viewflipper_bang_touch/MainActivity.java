package com.dvl.viewflipper_bang_touch;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ViewFlipper viewFlipper;
    float tuvitri, denvitri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        int[] layouts = new int[]{R.layout.layout_first, R.layout.layout_second, R.layout.layout_third};

        for(int layout:layouts)
        {
            viewFlipper.addView(inflater.inflate(layout,null));
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                tuvitri=event.getX();
                break;
            case MotionEvent.ACTION_UP:
                denvitri=event.getX();
                if (tuvitri>denvitri)
                {
                    viewFlipper.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.go_next_in));
                    viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.go_next_out));
                    viewFlipper.showNext();
                }
                else
                {
                    viewFlipper.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.go_prev_in));
                    viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.go_prev_out));
                    viewFlipper.showPrevious();
                }
                break;
            default:break;
        }
        return super.onTouchEvent(event);
    }
}
