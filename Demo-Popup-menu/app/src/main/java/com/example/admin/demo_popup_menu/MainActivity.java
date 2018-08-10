package com.example.admin.demo_popup_menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bt,bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button)findViewById(R.id.button);
        bt2=(Button)findViewById(R.id.button2);

       bt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               PopupMenu popupMenu=new PopupMenu(MainActivity.this,bt2);
               MenuInflater menuInflater=getMenuInflater();
               menuInflater.inflate(R.menu.menu_popup,popupMenu.getMenu());
               popupMenu.show();
               popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                   @Override
                   public boolean onMenuItemClick(MenuItem item) {
                       if(item.getItemId()==R.id.item1)
                       {
                           Toast.makeText(MainActivity.this,"Item 1",Toast.LENGTH_SHORT).show();
                       }
                       else Toast.makeText(MainActivity.this,"Item 2",Toast.LENGTH_SHORT).show();
                       return false;
                   }
               });
           }
       });

    }
}
