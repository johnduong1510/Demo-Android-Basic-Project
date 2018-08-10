package com.dvl.demo_service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by Admin on 3/9/2016.
 */
public class MyService_2nd extends Service {

    public Handler handler=new Handler();
    boolean isRunning=false;
    Runnable chay;
    int count=0;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"Service created",Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        isRunning=true;
        tangThoiGian();
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(chay);
        Toast.makeText(this,"Service destroyed",Toast.LENGTH_SHORT).show();

    }

    public void tangThoiGian()
    {
        if(isRunning) {
            chay=new Runnable() {
                @Override
                public void run() {
                    count++;
                    Toast.makeText(getApplicationContext(),count+"",Toast.LENGTH_SHORT).show();
                    tangThoiGian();
                }
            };
            handler.postDelayed(chay,500);
        }
    }

}
