package com.dvl.notificationpendingintent;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bt;
    NotificationManager notiManager;
    Notification.Builder notiBuilder;
    Notification noti;
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button)findViewById(R.id.button);

        notiManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        notiBuilder=new Notification.Builder(MainActivity.this);
        notiBuilder.setContentTitle("Tieu de Noti");
        notiBuilder.setContentText("Noi dung Noti");
        notiBuilder.setSmallIcon(R.mipmap.ic_launcher);
        notiBuilder.setAutoCancel(true);


        //Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.zing.vn"));
        Intent i=new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent pe=PendingIntent.getActivity(getApplicationContext(),0,i,PendingIntent.FLAG_ONE_SHOT);
        notiBuilder.setContentIntent(pe);
        noti=notiBuilder.build();


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notiManager.notify(0,noti);
            }
        });
    }
}
