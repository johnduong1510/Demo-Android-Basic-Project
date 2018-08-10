package com.duongvyluan.demo_realm_database;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by JohnDuong on 02-Oct-17.
 */

public class SinhVien extends RealmObject{
    //Set id as a primary key


    private String name;
    public SinhVien(){}
    public SinhVien(int id,String name){this.id=id;this.name=name;}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PrimaryKey
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
