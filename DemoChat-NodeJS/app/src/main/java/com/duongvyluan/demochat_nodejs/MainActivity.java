package com.duongvyluan.demochat_nodejs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Socket mSocket;
    {
        try {
            mSocket = IO.socket("http://192.168.1.12:3484");
        } catch (URISyntaxException e) {
            Log.v("URISyntaxException",e+"");}
    }
    EditText edt_username;
    Button btn_dangky;
    ListView lv_chat,lv_online;

    ArrayList<String>mangUsername;
    ArrayAdapter<String> adapterUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_username=(EditText)findViewById(R.id.edt_username);
        btn_dangky=(Button)findViewById(R.id.btn_dangky);
        lv_chat=(ListView)findViewById(R.id.lv_chat);
        lv_online=(ListView)findViewById(R.id.lv_online);
        //Tao ket noi
        mSocket.connect();
        mSocket.on("ketquaDangKyUn",onNewMessage_DangKyUsername);
        mSocket.on("server-gui-username",onNewMessage_DanhSachUsername);

        //mangUsername.add("Ti");mangUsername.add("Teo");mangUsername.add("Tun");mangUsername.add("Luan");mangUsername.add("Han");


        btn_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=edt_username.getText().toString().trim();
                if(text.isEmpty()) return;
                mSocket.emit("client-gui-username",text);
                edt_username.setText("");
            }
        });
    }

    private Emitter.Listener onNewMessage_DangKyUsername = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject data = (JSONObject) args[0];
                    String noidung;
                    try {
                        noidung = data.getString("noidung");
                        if(noidung.equalsIgnoreCase("true")) Toast.makeText(MainActivity.this,"Dang ky thanh cong",Toast.LENGTH_SHORT).show();
                        else Toast.makeText(MainActivity.this,"Dang ky that bai",Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        return;
                    }
                }
            });
        }
    };

    private Emitter.Listener onNewMessage_DanhSachUsername = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject data = (JSONObject) args[0];
                    JSONArray noidung;
                    try {
                        noidung = data.getJSONArray("danhsach");
                        mangUsername=new ArrayList<>();
                        for(int i=0;i<noidung.length();i++) mangUsername.add(noidung.getString(i));
                        adapterUsername=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,mangUsername);
                        lv_online.setAdapter(adapterUsername);
                    } catch (JSONException e) {
                        return;
                    }
                }
            });
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSocket.disconnect();
        mSocket.off();
    }
}
