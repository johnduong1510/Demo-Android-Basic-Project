package com.dvl.demo_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Admin on 3/9/2016.
 */
public class MyService extends Service{

    MediaPlayer player;
    public Handler handler=new Handler();
    boolean isRunning=false;
    Runnable chay;
    int tang=0;

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "service duoc tao", Toast.LENGTH_SHORT).show();
        player=MediaPlayer.create(this,R.raw.casablanca);
        player.setLooping(true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
        Toast.makeText(this, "service bi huy",Toast.LENGTH_SHORT).show();
        handler.removeCallbacks(chay);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service chay",Toast.LENGTH_SHORT).show();
        player.start();
        isRunning=true;
        tangthoigian();

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void tangthoigian()
    {
        if(isRunning==true)
        {
            chay=new Runnable() {

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    tang++;
                    Toast.makeText(getApplicationContext(), "tang"+tang,Toast.LENGTH_SHORT).show();
                    tangthoigian();
                }
            };
            handler.postDelayed(chay,5000);
        }
    }


}
