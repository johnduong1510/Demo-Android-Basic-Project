package com.example.admin.demo_custom_galerry_myadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String[]ten={"android","apple","blogger",
            "chrome","dell","facebook",
            "firefox","twitter","ie",
            "microsoft","hp","xbox","1","2","3","4","5"};

    int[]hinh={R.drawable.android,R.drawable.apple,R.drawable.blogger
            ,R.drawable.chrome,R.drawable.dell,R.drawable.facebook
            ,R.drawable.firefox,R.drawable.twitter,R.drawable.ie
            ,R.drawable.microsoft,R.drawable.hp,R.drawable.xbox,R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5};

    Gallery gallery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gallery=(Gallery)findViewById(R.id.gallery);
        MyAdapter adapter=new MyAdapter();
        gallery.setAdapter(adapter);
    }


    public class View_Mot_O
    {
        ImageView imageView;
        TextView textView;
    }

    public class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return hinh.length;
        }

        @Override
        public Object getItem(int position) {
            return ten[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater=getLayoutInflater();
            View_Mot_O mot_o=null;
            if(convertView==null)
            {
                convertView=layoutInflater.inflate(R.layout.custom_gallery,null);
                mot_o=new View_Mot_O();
                mot_o.imageView=(ImageView)convertView.findViewById(R.id.imageView);
                mot_o.textView=(TextView)convertView.findViewById(R.id.textView);
                convertView.setTag(mot_o);
            }
            else
            {
                mot_o=(View_Mot_O)convertView.getTag();
            }
            mot_o.imageView.setImageResource(hinh[position]);
            mot_o.textView.setText(ten[position]);
            return convertView;
        }
    }
}
