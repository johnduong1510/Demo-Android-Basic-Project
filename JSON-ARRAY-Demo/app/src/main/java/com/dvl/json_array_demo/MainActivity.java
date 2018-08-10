package com.dvl.json_array_demo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvKhoaHoc;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvKhoaHoc=(ListView)findViewById(R.id.listViewKhoaHoc);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJSON().execute("http://khoapham.vn/KhoaPhamTraining/laptrinhios/jSON/demo3.json");
            }
        });
    }

    class ReadJSON extends AsyncTask<String,Integer,String>
    {

        @Override
        protected String doInBackground(String... params) {
            String chuoi=getJsonFromURL(params[0]);
            return chuoi;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject root=new JSONObject(s);
                JSONArray mang=root.getJSONArray("danhsach");
                ArrayList<String> array=new ArrayList<String>();
                for(int i=0;i<mang.length();i++)
                {
                    JSONObject son=mang.getJSONObject(i);
                    array.add(son.getString("khoahoc"));
                }
                adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,array);
                lvKhoaHoc.setAdapter(adapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String getJsonFromURL(String urlSring)
    {
        try {
            URL url=new URL(urlSring);
            HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection();
            urlConnection.connect();
            InputStream in=urlConnection.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(in,"UTF-8"));
            String data="",tam="";
            while((tam=reader.readLine())!=null)
            {
                data+=tam+"\n";
            }
            return data;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
