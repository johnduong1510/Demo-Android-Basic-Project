package com.dvl.demo_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class Main2Activity extends BroadcastReceiver {

    Context context;
    @Override
    public void onReceive(Context context, Intent intent) {
        this.context=context;
        // lay TELEPHONY MANAGER de dang ki lang nghe su kien
        TelephonyManager telephonyManager=(TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);

        //Tao Listner
        MyPhoneStateListener myPhoneStateListener=new MyPhoneStateListener();

        //DK listener cho listen call state
        telephonyManager.listen(myPhoneStateListener,PhoneStateListener.LISTEN_CALL_STATE);
    }


    class MyPhoneStateListener extends PhoneStateListener{
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            super.onCallStateChanged(state, incomingNumber);
            if(state==1) //chuong reng
            {
                String msg="New phone call. Incoming number: "+incomingNumber;
                Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
            }
        }
    }
}


