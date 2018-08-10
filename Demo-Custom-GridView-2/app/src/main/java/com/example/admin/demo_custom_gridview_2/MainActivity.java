package com.example.admin.demo_custom_gridview_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[]ten={"android","apple","blogger",
            "chrome","dell","facebook",
            "firefox","twitter","ie",
            "microsoft","hp","xbox","1","2"};

    int[]hinh={R.drawable.android,R.drawable.apple,R.drawable.blogger
            ,R.drawable.chrome,R.drawable.dell,R.drawable.facebook
            ,R.drawable.firefox,R.drawable.twitter,R.drawable.ie
            ,R.drawable.microsoft,R.drawable.hp,R.drawable.xbox,R.drawable.h1,R.drawable.h2};


    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=(GridView)findViewById(R.id.gridView);

        MyAdapter adapter=new MyAdapter();
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,gridView.getItemAtPosition(position)+"" +gridView.getItemIdAtPosition(position)
                        ,Toast.LENGTH_SHORT).show();
            }
        });
    }


    public static class View_Mot_O
    {
        public ImageView imageView;
        public TextView textView;
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
            LayoutInflater layoutInflate=getLayoutInflater();
            View_Mot_O mot_o = null;
            if(convertView==null) {
                mot_o = new View_Mot_O();//neu ban dau chua co du lieu thi khoi tao
                convertView = layoutInflate.inflate(R.layout.custom_gridview, null);
                mot_o.imageView = (ImageView) convertView.findViewById(R.id.imageView);
                mot_o.textView = (TextView) convertView.findViewById(R.id.textView);
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
