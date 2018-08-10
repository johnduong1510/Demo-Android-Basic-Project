package com.example.admin.arraylist_bai1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView kq;
    Button bt;
    EditText input;
    Random rd = new Random();
    ArrayList<Integer> daymay;
    ArrayList<Integer> daynguoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button) findViewById(R.id.button);
        input = (EditText) findViewById(R.id.editText);
        kq = (TextView) findViewById(R.id.textView2);
        kq.setText("");


        daymay = new ArrayList<Integer>();
        daynguoi = new ArrayList<Integer>();


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kq.setText("");
                daymay.clear();
                for (int i = 0; i < 4; i++) {
                    int so = rd.nextInt(6) + 1;
                    daymay.add(so);
                }
                try {
                    String chuoidaynguoi = input.getText().toString();
                    String[] mangchuoi = chuoidaynguoi.split(" ");
                    daynguoi.clear();//xoa toan bo phan tu
                    for (int i = 0; i < mangchuoi.length; i++) {
                        daynguoi.add(Integer.parseInt(mangchuoi[i]));
                    }
                }
                catch (Exception e){}


                int coso = 0;
                int dungsodungvitri = 0;
                int vitritrungnhau[] = new int[daynguoi.size()];
                //kiem tra xem daynguoi co trùng với daymay khong
                for (int i = 0; i < daynguoi.size(); i++) {
                    if (daymay.contains(daynguoi.get(i)) == true) coso++;
                }
                for (int i = 0; i < daynguoi.size(); i++) {
                    if (daymay.get(i) == daynguoi.get(i)) {
                        dungsodungvitri++;
                        vitritrungnhau[i] = 1;
                    }
                }

                //duyet mang
                String chuoi = "Dãy máy là: ";
                for (Integer item : daymay) {
                    chuoi += item + " ,";
                }
                chuoi+="\nDãy người : ";
                for(Integer item: daynguoi)
                {
                    chuoi+=item+" ,";
                }
                chuoi+="\nPhần tử người nhập nằm trong phần tử máy :"+coso;
                chuoi+="\nCó "+dungsodungvitri+" đúng số đúng vị trí";

                kq.setText(chuoi);

            }

        });

    }
}
