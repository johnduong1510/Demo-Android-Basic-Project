package com.dvl.demo_tablayout;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends TabActivity {
    ViewFlipper viewFlipper;
    float tuvitri, denvitri;
    TabHost tabhost;
    int index = 0;
    int layouts[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //su dung viewflipper truot ngang chuyen activity
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layouts = new int[]{R.layout.tab1, R.layout.tab2};
        for (int layout : layouts) {
            viewFlipper.addView(inflater.inflate(layout, null));
        }
        //

        tabhost = getTabHost();
//tab1
        final TabHost.TabSpec tab1 = tabhost.newTabSpec("tab1");
        tab1.setIndicator("TAB1",
                getResources().getDrawable(R.mipmap.ic_launcher));
        Intent h = new Intent(this, tab1.class);
        tab1.setContent(h);
        tabhost.addTab(tab1);
//tab2
        final TabHost.TabSpec tab2 = tabhost.newTabSpec("tab2");
        tab2.setIndicator("TAB2 NE", getResources().getDrawable(R.mipmap.ic_launcher));
        tab2.setContent(new Intent(this, tab2.class));
        tabhost.addTab(tab2);

        tabhost.setCurrentTab(0);//make default

        tabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if(tab1.getTag().equals(tabId)) tabhost.setCurrentTab(0);
                if(tab2.getTag().equals(tabId)) tabhost.setCurrentTab(1);
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                tuvitri = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                denvitri = event.getX();
                if (tuvitri > denvitri) {
                    viewFlipper.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.go_next_in));
                    viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.go_next_out));
                    viewFlipper.showNext();
                    index++;
                    if(index>1) index=0;
                    new CountDownTimer(2000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            tabhost.setCurrentTab(index);
                        }
                    }.start();
                }
                else {
                    viewFlipper.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.go_prev_in));
                    viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.go_prev_out));
                    viewFlipper.showPrevious();
                    index--;
                    if(index<0) index=1;
                    new CountDownTimer(2000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            tabhost.setCurrentTab(index);
                        }
                    }.start();
                }
                break;
        }

        return true;
    }
}
