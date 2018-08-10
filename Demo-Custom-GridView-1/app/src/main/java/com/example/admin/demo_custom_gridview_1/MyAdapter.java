package com.example.admin.demo_custom_gridview_1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Admin on 14/7/2016.
 */
public class MyAdapter extends BaseAdapter {
    ArrayList<Integer> ds;
    Context context;

    MyAdapter(Context context,ArrayList<Integer> ds)
    {
        this.context=context;
        this.ds=ds;
    }

    @Override
    public int getCount() {
        return ds.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView=new ImageView(context);
        imageView.setImageResource(ds.get(position));
        imageView.setLayoutParams(new GridView.LayoutParams(300,300));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(1,1,1,1);
        return imageView;
    }
}
