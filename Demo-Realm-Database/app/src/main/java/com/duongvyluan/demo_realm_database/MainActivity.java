package com.duongvyluan.demo_realm_database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.PrimaryKey;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeToDB();
        readFromDB();
    }
    public void writeToDB()
    {
        Realm myOherRealm=Realm.getInstance(getApplicationContext());
/*
        //Method 1
        //Begin transaction
        myOherRealm.beginTransaction();
        //Create an object
        SinhVien sinhVien=myOherRealm.createObject(SinhVien.class);
        //Set data
        sinhVien.setId(0); sinhVien.setName("John");
        //End transaction
        myOherRealm.commitTransaction();*/

        //Method 2 - Use this when model class has at least 1 primary key -
        SinhVien sinhVien2=new SinhVien(1,"Luan");
        myOherRealm.beginTransaction();
        SinhVien copySinhvien2=myOherRealm.copyToRealmOrUpdate(sinhVien2);
        myOherRealm.commitTransaction();

        //Method 2
        SinhVien sinhVien3=new SinhVien(2,"Luan2");
        myOherRealm.beginTransaction();
        SinhVien copySinhvien3=myOherRealm.copyToRealmOrUpdate(sinhVien3);
        myOherRealm.commitTransaction();
        //Method 2
        SinhVien sinhVien4=new SinhVien(3,"Luan3");
        myOherRealm.beginTransaction();
        SinhVien copySinhvien4=myOherRealm.copyToRealmOrUpdate(sinhVien4);
        myOherRealm.commitTransaction();
    }

    public void readFromDB()
    {
        Realm myOherRealm=Realm.getInstance(getApplicationContext());
        //RealmResults<SinhVien> realmResults=myOherRealm.where(SinhVien.class).findAll();
        RealmResults<SinhVien> realmResults=myOherRealm.where(SinhVien.class).findAll();
        for(SinhVien sv:realmResults) Log.v("LOG",sv.getId()+"-"+sv.getName());
    }


}
