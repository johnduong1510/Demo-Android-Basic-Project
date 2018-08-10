package com.dvl.tablayout_materialdesign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Admin on 12/8/2016.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

public class OneFragment extends Fragment {
    ListView listView;
    Button bt_Add;
    AdView adView;
    QuanLyCongViec quanLyCongViec=new QuanLyCongViec();
    ArrayList<CongViec> ds_cv;
    MyAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.onefragment, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        listView=(ListView)getActivity().findViewById(R.id.listView);
        bt_Add=(Button)getActivity().findViewById(R.id.button);
        adView = (AdView)getActivity().findViewById(R.id.adView);
        adView.loadAd(new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("483D7773FD41661E08C39E08B56788C9")
                .build());

        dodulieu();
        registerForContextMenu(listView);
        bt_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ThemSuaActivity.class);
                i.putExtra("mode","add");
                startActivityForResult(i, 1);//request code =1 : them cong viec
            }
        });
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater=getActivity().getMenuInflater();
        inflater.inflate(R.menu.menu_context,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
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
            Toast.makeText(getActivity(),getResources().getString(R.string.remove_success),Toast.LENGTH_SHORT).show();
            dodulieu();
        }
        else if(id==R.id.edit)
        {
            CongViec c=ds_cv.get(index);
            Intent i=new Intent(getActivity(),ThemSuaActivity.class);
            i.putExtra("congviec",c);
            i.putExtra("mode","edit");
            startActivityForResult(i, 2);//requestcode=2 la sua
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        getActivity();
        if(requestCode==1 && resultCode== Activity.RESULT_OK)
        {
            CongViec c=(CongViec)data.getExtras().get("congviec");
            quanLyCongViec.themCongViec(c);
            Toast.makeText(getActivity(),getResources().getString(R.string.add_success),Toast.LENGTH_SHORT).show();
            dodulieu();


        }
        //requestcode=2 la sua
        else getActivity();if(requestCode==2 && resultCode== Activity.RESULT_OK)
        {
            CongViec c=(CongViec)data.getExtras().get("congviec");
            quanLyCongViec.suaCongViec(c);
            Toast.makeText(getActivity(),getResources().getString(R.string.edit_success),Toast.LENGTH_SHORT).show();
            dodulieu();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.menu_option, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add) {
            Intent i = new Intent(getActivity(), ThemSuaActivity.class);
            i.putExtra("mode", "add");
            startActivityForResult(i, 1);//request code =1 : them cong viec
        }
        return super.onOptionsItemSelected(item);
    }


    void dodulieu() {
        ds_cv = quanLyCongViec.xemdsCongViec();
        adapter = new MyAdapter(getActivity(), ds_cv);
        listView.setAdapter(adapter);
    }

}