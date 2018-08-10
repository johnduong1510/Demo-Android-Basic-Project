package com.example.admin.demo_quanlycongviec_database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    QuanLyCongViec quanLyCongViec;
    ArrayList<CongViec> ds_cv;
    MyAdapter adapter;
    private AdView adView;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_option, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add) {
            Intent i = new Intent(MainActivity.this, ThemSuaActivity.class);
            i.putExtra("mode", "add");
            startActivityForResult(i, 1);//request code =1 : them cong viec
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) //them cong viec
        {
            CongViec congViec = (CongViec) data.getExtras().get("congviec");
            quanLyCongViec.themCongViec(congViec);
            Toast.makeText(MainActivity.this, getString(R.string.add_success), Toast.LENGTH_SHORT).show();
            dodulieu();
        }
        if (requestCode == 2 && resultCode == RESULT_OK) {
            CongViec congViec_Edited = (CongViec) data.getExtras().get("congviec");
            quanLyCongViec.suaCongViec(congViec_Edited);
            dodulieu();
        }
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;

        //lay index tu vi tri nhan tren listview, tu do truy xuat vao vi tri ArrayList, lay ra id database
        //tu nguon du lieu (CACH 1)
        int id_db = ds_cv.get(index).id;

        //CACH 2 lay trong MyAdapter, co ham getItemId se tra ve id trong databse
        //int id_db=adapter.getItemId(index);


        if (item.getItemId() == R.id.edit) {
            Intent i = new Intent(MainActivity.this, ThemSuaActivity.class);
            CongViec congViec = ds_cv.get(index);
            i.putExtra("congviec", congViec);

            i.putExtra("mode", "edit");
            startActivityForResult(i, 2);//request code =2 la sua cong viec
        } else if (item.getItemId() == R.id.remove) {
            CongViec congViec = ds_cv.get(index);
            quanLyCongViec.xoaCongViec(congViec);
            Toast.makeText(MainActivity.this, getString(R.string.remove_success), Toast.LENGTH_SHORT).show();
            dodulieu();
        }
        return super.onContextItemSelected(item);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        quanLyCongViec = new QuanLyCongViec(MainActivity.this);//khoi tao database
        registerForContextMenu(listView);//khai bao su dung menu context
        dodulieu();
        adView = (AdView)this.findViewById(R.id.adView);
        adView.loadAd(new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("483D7773FD41661E08C39E08B56788C9")
                .build());




    }

    void dodulieu() {
        ds_cv = quanLyCongViec.xemdsCongViec();
        adapter = new MyAdapter(MainActivity.this, ds_cv);
        listView.setAdapter(adapter);
    }



}
