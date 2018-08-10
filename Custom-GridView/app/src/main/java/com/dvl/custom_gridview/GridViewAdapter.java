package com.dvl.custom_gridview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Admin on 1/12/2016.
 */

public class GridViewAdapter extends BaseAdapter {
    public ImageView imageView;
    public TextView textView;
    Context c;
    Integer hinh[];
    String chu[];

    public GridViewAdapter(Context c,Integer hinh[],String chu[])
    {
        this.c=c;
        this.hinh=hinh;
        this.chu=chu;
    }

    @Override
    public int getCount() {
        return hinh.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=((Activity)c).getLayoutInflater();
        convertView=inflater.inflate(R.layout.item,null);
        imageView=(ImageView)convertView.findViewById(R.id.imageView1);
        textView=(TextView)convertView.findViewById(R.id.tvTemp);
        imageView.setImageResource(hinh[position]);
        textView.setText(chu[position]);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c,chu[position],Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
