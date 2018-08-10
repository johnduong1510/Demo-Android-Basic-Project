package com.dvl.demo_gameshow;

import android.content.Intent;
import android.database.Cursor;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView tv_cauhoi;
    Button btNext;
    RadioButton rd_caua,rd_caub,rd_cauc,rd_caud;
    int socaudung=0;
    cauhoi cauhientai;
    int index=0;
    int socau=4;
    List<cauhoi>ds_cauhoi;
    String cautraloi="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_cauhoi = (TextView) findViewById(R.id.textView);
        btNext=(Button)findViewById(R.id.button);
        rd_caua=(RadioButton)findViewById(R.id.radioButton);
        rd_caub=(RadioButton)findViewById(R.id.radioButton2);
        rd_cauc=(RadioButton)findViewById(R.id.radioButton3);
        rd_caud=(RadioButton)findViewById(R.id.radioButton4);

        //------------------------------------
        //khoi tao database = copy Assets vao databases
        quanlycauhoi db = new quanlycauhoi(MainActivity.this);
        try {
            db.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        db.close();
        db = new quanlycauhoi(MainActivity.this);
        //---------------------------------
        //lay tat ca cau hoi dem ra textview (testing)
        /*
        Cursor cursor=db.getAllQuestions();
        cursor.moveToFirst();
        String chuoi="";
        do {
            chuoi+=cursor.getString(0)+" ";
            chuoi+=cursor.getString(1)+"\n";
        }while(cursor.moveToNext());
        tv_cauhoi.setText(chuoi);
        //
        */
    /*
        String chuoi="";
        ds_cauhoi=new ArrayList<cauhoi>();
        ds_cauhoi=db.layNNgauNhien(2);
        for(cauhoi x: ds_cauhoi)
        {
            chuoi+=x.get_cauhoi()+"\n";
        }
        tv_cauhoi.setText(chuoi);
    */


        ds_cauhoi=new ArrayList<cauhoi>();
        ds_cauhoi=db.layNNgauNhien(socau);
        hienthi(index);

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rd_caua.isChecked()) cautraloi="a";
                else if(rd_caub.isChecked()) cautraloi="b";
                else if(rd_cauc.isChecked()) cautraloi="c";
                else if(rd_caud.isChecked()) cautraloi="d";
                else cautraloi="khongco";
                if(cauhientai.get_dapan().equalsIgnoreCase(cautraloi)) {
                    socaudung++;
                    Toast.makeText(MainActivity.this,"Dung roi !"+"\n"+"So cau dung hien tai: "+socaudung,Toast.LENGTH_SHORT).show();
                }
                else if(cautraloi.equalsIgnoreCase("khongco"))
                {
                    Toast.makeText(MainActivity.this,"Chua chon cau tra loi",Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(MainActivity.this,"Sai roi !!"+"\n"+"So cau dung hien tai: "+socaudung,Toast.LENGTH_SHORT).show();

                final String finalCautraloi = cautraloi;
                new CountDownTimer(3000,300) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        btNext.setClickable(false);
                    }

                    @Override
                    public void onFinish() {
                        if(!cautraloi.equalsIgnoreCase("khongco"))index++;
                        if(index<socau) {hienthi(index);}
                        else index=0;
                        btNext.setClickable(true);
                    }
                }.start();
            }
        });
    }

    void hienthi(int index)
    {
        cauhientai=ds_cauhoi.get(index);
        tv_cauhoi.setText(cauhientai.get_cauhoi());
        rd_caua.setText(cauhientai.get_cau_a());
        rd_caub.setText(cauhientai.get_cau_b());
        rd_cauc.setText(cauhientai.get_cau_c());
        rd_caud.setText(cauhientai.get_cau_d());
        rd_caua.setChecked(false);
        rd_caub.setChecked(false);
        rd_cauc.setChecked(false);
        rd_caud.setChecked(false);
    }
}
