package com.dvl.tablayout_materialdesign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Admin on 12/8/2016.
 */
public class TwoFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.twofragment,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        TextView tv=(TextView)getActivity().findViewById(R.id.textView2);
        tv.setText("Fragment 2 ne");
    }
}
