package com.dvl.loadhinhlengridview_contentprovider;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    Cursor cursor;
    ContentResolver contentResolver;
    String[] cot = new String[]{MediaStore.Images.Thumbnails._ID, MediaStore.Images.Thumbnails.DATA};
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridView);

        contentResolver = getContentResolver();
        cursor = contentResolver.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI,
                cot,//lay du lieu tu nhung cot nao: kieu String[]
                null, null, null);

        adapter = new MyAdapter();
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cursor.moveToPosition(position);
                int idcot = cursor.getColumnIndexOrThrow(MediaStore.Images.Thumbnails.DATA);
                String src = cursor.getString(idcot);
                Toast.makeText(MainActivity.this, src, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                i.putExtra("src", src);
                startActivity(i);
            }
        });
        registerForContextMenu(gridView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = new MenuInflater(MainActivity.this);
        menuInflater.inflate(R.menu.layout_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if (R.id.remove == item.getItemId()) {
            String idhinhduocchon = (String) gridView.getItemAtPosition(info.position);
            Toast.makeText(MainActivity.this, "id hinh duoc chon: " + idhinhduocchon, Toast.LENGTH_SHORT).show();
            ContentResolver contentResolver = this.getContentResolver();
            try {
                contentResolver.delete(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, MediaStore.Images.Thumbnails._ID + "=?"
                        , new String[]{idhinhduocchon});
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
            adapter=new MyAdapter();
            gridView.setAdapter(adapter);
            //cap nhap lai adapter, cap nhap adapter cho gridview
        } else if (R.id.setwallpaper == item.getItemId()) {

        }
        return super.onContextItemSelected(item);
    }

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return cursor.getCount();
        }

        @Override
        public Object getItem(int position) {
            cursor.moveToPosition(position);
            int cot = cursor.getColumnIndex(MediaStore.Images.Thumbnails._ID);
            String src = cursor.getString(cot);
            return src;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(MainActivity.this);
                cursor.moveToPosition(position);
                int idcot = cursor.getColumnIndex(MediaStore.Images.Thumbnails.DATA);
                String src = cursor.getString(idcot);
                imageView.setImageURI(Uri.parse(src));
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setPadding(2, 8, 8, 8);
                imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            } else {
                imageView = (ImageView) convertView;
            }
            return imageView;


        }

    }

}
