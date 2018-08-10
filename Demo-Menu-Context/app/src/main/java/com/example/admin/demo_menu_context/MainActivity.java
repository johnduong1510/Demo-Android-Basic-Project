package com.example.admin.demo_menu_context;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    String mang[]=new String[]{"item1","item2","item3"};

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_ngucanh,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        int position=info.position;
        if(item.getItemId()==R.id.Sub1)
        {
            Toast.makeText(MainActivity.this,"Sub1 cua " + mang[position],Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.Sub2)
        {
            Toast.makeText(MainActivity.this,"Sub2 cua " + mang[position],Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.Sub3)
        {
            Toast.makeText(MainActivity.this,"Sub3 cua " + mang[position],Toast.LENGTH_SHORT).show();
        }



        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,mang);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
        lv.setAdapter(arrayAdapter);
        this.registerForContextMenu(lv);


    }
}
