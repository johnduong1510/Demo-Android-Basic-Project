package com.example.admin.demo_expand_list_view_list_view_2_lop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    List<Map<String,String>> groupData;
    List<List<Map<String,String>>> childData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView=(ExpandableListView)findViewById(R.id.expandableListView);

        groupData=new ArrayList<Map<String,String>>();
        childData=new ArrayList<List<Map<String,String>>>();


        for(int i=0;i<15;i++) {
            Map<String, String> curGroupData=new HashMap<String,String>();
            curGroupData.put("name","Item "+i);
            groupData.add(curGroupData);
            List<Map<String,String>> children=new ArrayList<Map<String,String>>();
            for(int j=0;j<3;j++)
            {
                Map<String,String> curChildrenData=new HashMap<String,String>();
                curChildrenData.put("sub","Sub "+j);
                children.add(curChildrenData);
            }
            childData.add(children);
        }

        ExpandableListAdapter adapter=new SimpleExpandableListAdapter(
                MainActivity.this,
                groupData,
                android.R.layout.simple_expandable_list_item_1,
                new String[] {"name"},
                new int[] {android.R.id.text1},
                childData,
                android.R.layout.simple_expandable_list_item_2,
                new String[] {"sub"},
                new int[] {android.R.id.text2}
        );
        expandableListView.setAdapter(adapter);
    }
}
