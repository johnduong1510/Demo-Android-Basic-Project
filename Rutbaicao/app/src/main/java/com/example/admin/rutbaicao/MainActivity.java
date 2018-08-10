package com.example.admin.rutbaicao;

import android.media.Image;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView kq;
    Button bt;
    ImageView labai1,labai2,labai3;
    int manghinhbai[]={R.drawable.b1fv,R.drawable.c1,R.drawable.c2,R.drawable.c3
            ,R.drawable.c4,R.drawable.c5,R.drawable.c6,R.drawable.c7,
            R.drawable.c8,R.drawable.c9,R.drawable.c10,R.drawable.cj,R.drawable.ck
            ,R.drawable.cq,R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,
            R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,
            R.drawable.dj,R.drawable.dk,R.drawable.dq,R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,
            R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,
            R.drawable.hj,R.drawable.hk,R.drawable.hq,R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,
            R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,
            R.drawable.sj,R.drawable.sk,R.drawable.sq};

    int mangsonut[]={0,1,2,3,4,5,6,7,8,9,0,0,0,0,1,2,3,4,5,6,7,8,9,0,0,0,0,1,2,3,4,5,6,7,8,9,0,0,0,0,1,2,3,4,5,6,7,8,9,0,0,0,0};

    String mangtenbai[]={"rong","ach chuon","hai chuon","ba chuon","bon chuon","nam chuon",
            "sau chuon","bay chuon","tam chuon","chin chuon","muoi chuon",
            "boi chuon","dam chuon","gia chuon","ach ro","hai ro","ba ro","bon ro","nam ro",
            "sau ro","bay ro","tam ro","chin ro","muoi ro",
            "boi ro","dam ro","gia ro","ach co","hai co","ba co","bon co","nam co",
            "sau co","bay co","tam co","chin co","muoi cao",
            "boi co","dam co","gia co","ach bich","hai bich","ba bich","bon bich","nam bich",
            "sau bich","bay bich","tam bich","chin bich","muoi bich",
            "boi bich","dam bich","gia bich"};
    int vitri[]=new int[3];
    boolean batay=true;
    int darut=0;
    int sonut1;
    boolean start=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        labai1=(ImageView)findViewById(R.id.imageView);
        labai2=(ImageView)findViewById(R.id.imageView2);
        labai3=(ImageView)findViewById(R.id.imageView3);
        bt=(Button)findViewById(R.id.button);
        kq=(TextView)findViewById(R.id.textView);
        kq.setText("");

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    rutbai();
                }
                catch (Exception e) {}
                darut=0;
                sonut1=0;

                //bt.setVisibility(View.INVISIBLE);
                bt.setClickable(false);
                labai1.setImageResource(R.drawable.b1fv);
                labai2.setImageResource(R.drawable.b1fv);
                labai3.setImageResource(R.drawable.b1fv);

                //su dung timer
                CountDownTimer timer=new CountDownTimer(3050,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        kq.setText("");
                        try {
                            if (darut == 0) {
                                labai1.setImageResource(manghinhbai[vitri[0]]);
                                darut++;
                            } else if (darut == 1) {
                                labai2.setImageResource(manghinhbai[vitri[1]]);
                                darut++;
                            } else if (darut == 2) {
                                labai3.setImageResource(manghinhbai[vitri[2]]);
                                darut++;
                            }
                        }
                        catch (Exception e){}
                    }

                    @Override
                    public void onFinish() {
                        darut=0;
                        try {
                            sonut1 = (mangsonut[vitri[0]] + mangsonut[vitri[1]] + mangsonut[vitri[2]]) % 10;
                            if (sonut1 != 0) kq.setText("Số nút: " + sonut1);
                            else kq.setText("Bù HaHa");
                            if (batay) kq.setText(" Ba Cào !! Thắng tuyệt đối !");
                           // bt.setVisibility(View.VISIBLE);
                            bt.setClickable(true);
                        }
                        catch (Exception e){}

                    }

                };
                timer.start();
                //


                //
                /*
                try {
                    labai1.setImageResource(manghinhbai[vitri[0]]);
                    labai2.setImageResource(manghinhbai[vitri[1]]);
                    labai3.setImageResource(manghinhbai[vitri[2]]);
                    sonut1=(mangsonut[vitri[0]]+mangsonut[vitri[1]]+mangsonut[vitri[2]])%10;
                    if(sonut1!=0) kq.setText("Số nút: "+sonut1);
                    else kq.setText("Bù HaHa");
                    if(batay) kq.setText(" Ba Cào !! Thắng tuyệt đối !");
                }
                catch (Exception e){}
                */





            }
        });

    }


    void rutbai()
    {
        Random rd=new Random();
        int x;
        for(int i=0;i<vitri.length;i++)
        {
            x=rd.nextInt(53)+1;
            vitri[i]=x;
            for(int j=i-1;j>=0;j--)
            {
                while(vitri[i]==vitri[j])
                {
                    x=rd.nextInt(53)+1;
                    vitri[i]=x;
                }
            }
        }
        for(int i=0;i<vitri.length;i++)
        {
            try {
               if(mangsonut[vitri[i]]<10 && mangsonut[vitri[i]]>0) {batay=false;break;}
            }
            catch (Exception e){}
        }

    }
}
