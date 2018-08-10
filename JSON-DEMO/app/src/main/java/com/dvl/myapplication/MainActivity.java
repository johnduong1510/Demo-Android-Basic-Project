package com.dvl.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import it.sephiroth.android.library.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    TextView MonHoc,NoiHoc,Website,FanPage;
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MonHoc=(TextView)findViewById(R.id.textViewMonHoc);
        NoiHoc=(TextView)findViewById(R.id.textViewNoiHoc);
        Website=(TextView)findViewById(R.id.textViewWebsite);
        FanPage=(TextView)findViewById(R.id.textViewFanPage);
        logo=(ImageView)findViewById(R.id.logo);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                /* json binh thuong*/
                new ReadJSON().execute("http://khoapham.vn/KhoaPhamTraining/android/json/demo3.json");
            }
        });
    }

    class ReadJSON extends AsyncTask<String, Integer, String>
    {

        @Override
        protected String doInBackground(String... params) {
            String chuoi=getStringFromURL(params[0]);
            return chuoi;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
            try {
                JSONObject root=new JSONObject(s);
                MonHoc.setText(root.getString("monhoc"));
                NoiHoc.setText(root.getString("noihoc"));
                Website.setText(root.getString("website"));
                FanPage.setText(root.getString("fanpage"));
                Picasso.with(MainActivity.this).load(root.getString("logo")).into(logo);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String getStringFromURL(String urlString)
    {

        try {
            URL url=new URL(urlString);
            HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();
            urlConnection.connect();
            InputStream in=urlConnection.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(in,"UTF-8"));
            String data = "",tam="";
            while ((tam = reader.readLine()) != null){
                data += tam + "\n";
            }
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
