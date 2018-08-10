package com.dvl.quanlycongviec;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class QuanLyCongViec_Tab extends Activity {
    ListView listView;
    Button bt_Add;
    QuanLyCongViec quanLyCongViec=new QuanLyCongViec();
    ArrayList<CongViec> ds_cv;
    MyAdapter adapter;
    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_cong_viec);
        listView=(ListView)findViewById(R.id.listView);
        bt_Add=(Button)findViewById(R.id.button);

        registerForContextMenu(listView);

        adView = (AdView)this.findViewById(R.id.adView);
        adView.loadAd(new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("483D7773FD41661E08C39E08B56788C9")
                .build());
        dodulieu();

        bt_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuanLyCongViec_Tab.this, ThemSuaActivity.class);
                i.putExtra("mode","add");
                startActivityForResult(i, 1);//request code =1 : them cong viec
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_option, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add) {
            Intent i = new Intent(QuanLyCongViec_Tab.this, ThemSuaActivity.class);
            i.putExtra("mode", "add");
            startActivityForResult(i, 1);//request code =1 : them cong viec
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode==1 && resultCode==RESULT_OK)
        {
            CongViec c=(CongViec)data.getExtras().get("congviec");

            quanLyCongViec.themCongViec(c);
            dodulieu();


        }
        //requestcode=2 la sua
        else if(requestCode==2 && resultCode==RESULT_OK)
        {
            CongViec c=(CongViec)data.getExtras().get("congviec");
            quanLyCongViec.suaCongViec(c);
            dodulieu();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_context,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id=item.getItemId();
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        int index=info.position;
        //co index tren listview lay ra doi tuong congviec trong database tu cong viec lay id trong database (tu nguon du lieu)
        int id_db=ds_cv.get(index).id;
        //lay id trong database (tu adapter, vi adapter co ham dua vao index tren listview tra ve id trong database)
        //int id_db=adapter.getItemId(index);
        if(id==R.id.remove)
        {
            quanLyCongViec.xoaCongViec(id_db);
            dodulieu();
        }
        else if(id==R.id.edit)
        {
            CongViec c=ds_cv.get(index);
            Intent i=new Intent(QuanLyCongViec_Tab.this,ThemSuaActivity.class);
            i.putExtra("congviec",c);
            i.putExtra("mode","edit");
            startActivityForResult(i, 2);//requestcode=2 la sua
        }
        return super.onContextItemSelected(item);
    }

    void dodulieu() {
        ds_cv = quanLyCongViec.xemdsCongViec();
        adapter = new MyAdapter(QuanLyCongViec_Tab.this, ds_cv);
        listView.setAdapter(adapter);
    }
}
