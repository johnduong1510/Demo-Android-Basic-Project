package com.dvl.tablayout_materialdesign;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class TwoFragment extends Fragment
{
    Button bt;
    EditText et;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.twofragment,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        bt=(Button)getActivity().findViewById(R.id.button4);
        et=(EditText)getActivity().findViewById(R.id.note);

        dodulieu();

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences save=getActivity().getPreferences(Context.MODE_APPEND);
                SharedPreferences.Editor editor=save.edit();
                editor.putString("noidung",et.getText().toString());
                editor.commit();
                Toast.makeText(getActivity(),getResources().getString(R.string.save_success),Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void dodulieu()
    {
        SharedPreferences load=getActivity().getPreferences(Context.MODE_APPEND);
        et.setText(load.getString("noidung",""));
    }
}