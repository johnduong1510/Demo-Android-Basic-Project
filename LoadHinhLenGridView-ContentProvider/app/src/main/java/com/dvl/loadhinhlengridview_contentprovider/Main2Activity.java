package com.dvl.loadhinhlengridview_contentprovider;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    ImageView imageView;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView=(ImageView)findViewById(R.id.imageView);
        bt=(Button)findViewById(R.id.button);

        final String src=getIntent().getExtras().getString("src");
        imageView.setImageURI(Uri.parse(src));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap= BitmapFactory.decodeFile(src);
                WallpaperManager wallpaperManager=WallpaperManager.getInstance(Main2Activity.this);
                try {
                    wallpaperManager.setBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finish();
            }
        });
    }

}
