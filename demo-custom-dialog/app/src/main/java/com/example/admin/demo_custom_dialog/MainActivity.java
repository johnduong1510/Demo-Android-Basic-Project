package com.example.admin.demo_custom_dialog;

import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button bt1,bt2,bt3;
    String key;
    TextView tv,tv2;
    View v;
    int timer=0;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=(Button)findViewById(R.id.button);
        tv=(TextView)findViewById(R.id.textView2);
        tv2=(TextView)findViewById(R.id.textView3);
        bt2=(Button)findViewById(R.id.button2);
        bt3=(Button)findViewById(R.id.button3);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taoCustomDialog();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taoCustomDialog_2();
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer=0;
                progressBar.setMax(100);
                CountDownTimer countDownTimer=new CountDownTimer(10000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        timer+=10;
                        bt3.setText(timer+"%");
                        progressBar.setProgress(timer);
                    }

                    @Override
                    public void onFinish() {
                        timer+=10;
                        bt3.setText(timer+"%");
                        progressBar.setProgress(timer);
                    }
                };
                countDownTimer.start();
            }
        });
    }

    void taoCustomDialog_2()
    {
        final String[] color={"Do","Vang","Xanh"};
        AlertDialog.Builder mydialog=new AlertDialog.Builder(MainActivity.this);
        AlertDialog alertDialog=mydialog.create();
        mydialog.setCancelable(false);
        mydialog.setItems(color, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv2.setText(color[which]);
            }
        });
        mydialog.show();
    }




    void taoCustomDialog()
    {
        AlertDialog.Builder mydialog=new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater=this.getLayoutInflater();
        v=inflater.inflate(R.layout.layout_dialog,null);
        mydialog.setView(v);
        mydialog.setCancelable(false);
        mydialog.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText etuser=(EditText)v.findViewById(R.id.editText);
                EditText etpass=(EditText)v.findViewById(R.id.editText2);
                tv.setText(etuser.getText().toString()+"/"+etpass.getText().toString());
            }
        });

        mydialog.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        mydialog.show();
    }
}
