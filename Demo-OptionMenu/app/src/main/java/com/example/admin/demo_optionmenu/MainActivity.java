package com.example.admin.demo_optionmenu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] mang=new String[]{"Xoa","Sua","Them"};
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_option,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.accept)
        {
            Toast.makeText(MainActivity.this,"Accept",Toast.LENGTH_SHORT).show();
            finish();
        }
        else if(item.getItemId()==R.id.call)
        {
            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:")));
        }
        else
        {
            if(item.getItemId()==R.id.option1)
            {
                startActivity(new Intent("android.media.action.IMAGE_CAPTURE"));
            }
            else if(item.getItemId()==R.id.option2)
            {
                Intent i=new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:123456"));
               // i.setData(Uri.parse("sms:"));//chi goi chuong trinh tin nhan
                i.putExtra("sms_body","testing");
                startActivity(i);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
