package com.dvl.demo_multithreading_progessbar;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {
    Button bt;
    TextView tv,tv2;
    ProgressBar bar,bar2;
    Handler handler,handler2;
    AtomicBoolean isRunning=new AtomicBoolean(false);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button)findViewById(R.id.button);
        tv=(TextView)findViewById(R.id.textView);
        tv2=(TextView)findViewById(R.id.textView2);
        bar=(ProgressBar)findViewById(R.id.progressBar);
        bar2=(ProgressBar)findViewById(R.id.progressBar2);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doStart();
                doStart2();
            }
        });
        handler=new Handler(){
          public void handleMessage(Message msg){
              super.handleMessage(msg);
              //msg.arg1 là giá trị được trả về trong message
              //của tiến trình con
              bar.setProgress(msg.arg1);
              tv.setText(msg.arg1+"%");
          }
        };
        handler2=new Handler(){
          public void handleMessage(Message msg){
              super.handleMessage(msg);
              bar2.setProgress(msg.arg1);
              tv2.setText(msg.arg1+"%");
          }
        };

    }

    private void doStart2() {
        bar2.setProgress(0);
        isRunning.set(false);
        //tạo 1 tiến trình CON
        Thread th=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++)
                {
                    //cho tiến trình tạm ngừng 100 mili second
                    SystemClock.sleep(300);
                    //lấy message từ Main thread
                    Message msg=handler2.obtainMessage();
                    //gán giá trị vào cho arg1 để gửi về Main thread
                    msg.arg1=i+1;
                    //msg.arg2=i+1;
                    //gui laij Message cho MainThread
                    handler2.sendMessage(msg);
                }
            }
        });
        isRunning.set(true);
        //Kich hoat tien trinh
        th.start();
    }

    private void doStart() {
        bar.setProgress(0);
        isRunning.set(false);
        //tạo 1 tiến trình CON
        Thread th=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++)
                {
                    //cho tiến trình tạm ngừng 100 mili second
                    SystemClock.sleep(100);
                    //lấy message từ Main thread
                    Message msg=handler.obtainMessage();
                    //gán giá trị vào cho arg1 để gửi về Main thread
                    msg.arg1=i+1;
                    //msg.arg2=i+1;
                    //gui laij Message cho MainThread
                    handler.sendMessage(msg);
                }
            }
        });
        isRunning.set(true);
        //Kich hoat tien trinh
        th.start();
    }
}
