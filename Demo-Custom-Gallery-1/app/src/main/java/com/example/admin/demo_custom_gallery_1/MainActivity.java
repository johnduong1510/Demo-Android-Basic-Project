package com.example.admin.demo_custom_gallery_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Gallery gallery;
    ImageView imageView;
    int[] hinh=new int[]{R.drawable.car01,R.drawable.car02,R.drawable.car03,R.drawable.car04,R.drawable.car05,R.drawable.car06};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gallery=(Gallery)findViewById(R.id.gallery);
        myadapter adapter=new myadapter();
        imageView=(ImageView)findViewById(R.id.imageView);
        gallery.setAdapter(adapter);
        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    imageView.setImageResource(hinh[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    class myadapter extends BaseAdapter{

        @Override
        public int getCount() {
            return hinh.length;//quan trong
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
            ImageView iv=new ImageView(MainActivity.this);
            iv.setImageResource(hinh[position]);
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            return iv;
        }
    }
}
