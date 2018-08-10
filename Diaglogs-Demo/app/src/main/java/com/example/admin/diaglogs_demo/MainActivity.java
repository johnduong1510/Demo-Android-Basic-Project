package com.example.admin.diaglogs_demo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //tu tao 1 dialogs
        AlertDialog.Builder mydialog=new AlertDialog.Builder(this);
        mydialog.setTitle("Xac Nhan !");
        mydialog.setMessage("Co khoe khong?");
        mydialog.setIcon(R.drawable.qc);
        //

        //them nut va bat su kien
        mydialog.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.finish();//dong ACtivity
                dialog.cancel();//dong dialogs
            }
        });
        //
        mydialog.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        //hien thi dialogs
        AlertDialog alertDialog=mydialog.create();
        alertDialog.show();
        //
    }
}
