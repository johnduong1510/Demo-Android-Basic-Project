package com.example.admin.demo_quanlycongviec_database;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Admin on 24/7/2016.
 */
public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<CongViec> ds;

    public static class View_Mot_O
    {
        TextView tv_id;
        TextView tv_noidung;
        TextView tv_thoigian;
    }

    MyAdapter(Context context,ArrayList<CongViec>ds)
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
        return ds.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ds.get(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View_Mot_O mot_o;
        LayoutInflater layoutInflater= ((Activity)context).getLayoutInflater();


        if(convertView==null)
        {
            mot_o=new View_Mot_O();
            convertView=layoutInflater.inflate(R.layout.listitem,null);
            mot_o.tv_id=(TextView)convertView.findViewById(R.id.textView3);
            mot_o.tv_noidung=(TextView)convertView.findViewById(R.id.textView4);
            mot_o.tv_thoigian=(TextView)convertView.findViewById(R.id.textView5);
            convertView.setTag(mot_o);
        }
        else
        {
           mot_o=(View_Mot_O)convertView.getTag();
        }

        mot_o.tv_id.setText(ds.get(position).id+"");
        mot_o.tv_noidung.setText(ds.get(position).noidung);
        mot_o.tv_thoigian.setText(ds.get(position).thoigian);

        return convertView;
    }
}
