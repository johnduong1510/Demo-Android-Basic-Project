package com.example.admin.dialog_list_radiobutton_progress_demo;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    Button btList,btRadio,btProgress,btMultiChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btList=(Button)findViewById(R.id.button);
        btRadio=(Button)findViewById(R.id.button2);
        btProgress=(Button)findViewById(R.id.button3);
        btMultiChoice=(Button)findViewById(R.id.button4);

        btList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mydialog=new AlertDialog.Builder(MainActivity.this);
                mydialog.setTitle("Xac nhan");
                CharSequence[] mau={"Do","Vang","Xanh"};
                mydialog.setItems(mau, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertDialog=mydialog.create();
                alertDialog.show();
            }
        });

        btRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mydialog=new AlertDialog.Builder(MainActivity.this);
                mydialog.setTitle("Xac nhan");
                CharSequence[] mau={"Do","Xanh","Vang"};
                mydialog.setSingleChoiceItems(mau, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertDialog=mydialog.create();
                alertDialog.show();
            }
        });
        btMultiChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mydialog=new AlertDialog.Builder(MainActivity.this);
                mydialog.setTitle("Xac nhan");
                CharSequence[] mau={"Do","Xanh","Vang"};
                boolean[] mang_check={false,false,false};
                mydialog.setMultiChoiceItems(mau, mang_check, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                });
                AlertDialog alertDialog=mydialog.create();
                alertDialog.show();
            }
        });

        btProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }
}
