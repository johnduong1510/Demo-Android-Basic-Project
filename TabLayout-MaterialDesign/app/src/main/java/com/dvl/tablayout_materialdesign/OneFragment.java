package com.dvl.tablayout_materialdesign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Admin on 12/8/2016.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class OneFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.onefragment, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        String[] mang=new String[]{"1","2","3","4","5","6"};
        TextView tv=(TextView)getActivity().findViewById(R.id.textView);
        ListView listView=(ListView)getActivity().findViewById(R.id.listView);
        tv.setText("Fragment ne");
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getActivity().getApplicationContext(),
                R.layout.listview_font,R.id.textView3,mang);
        listView.setAdapter(arrayAdapter);

    }
}