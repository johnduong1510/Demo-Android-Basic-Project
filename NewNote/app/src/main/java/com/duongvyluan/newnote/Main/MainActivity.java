package com.duongvyluan.newnote.Main;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.duongvyluan.newnote.Note.view.NoteFragment;
import com.duongvyluan.newnote.R;
import com.duongvyluan.newnote.Schedule.view.ScheduleFragment;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    Toolbar toolbar;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        tabLayout=(TabLayout)findViewById(R.id.tablayout);
        viewPager=(ViewPager)findViewById(R.id.viewpager);

        //Configure ToolBar and TabLayout
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        setSupportActionBar(toolbar);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabTextColors(getResources().getColorStateList(android.R.color.white));//Set text color
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(android.R.color.holo_red_dark));//Set indicator color
        //Setup ViewPager
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new ScheduleFragment(),getString(R.string.fragment_schedule_title));
        viewPagerAdapter.addFragment(new NoteFragment(),getString(R.string.fragment_note_title));
        viewPager.setAdapter(viewPagerAdapter);

        //attach viewpager into tablayout
        tabLayout.setupWithViewPager(viewPager);
    }

}
