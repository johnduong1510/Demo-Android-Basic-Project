package com.dvl.tablayout_materialdesign;

import java.io.Serializable;

/**
 * Created by Admin on 24/7/2016.
 */
public class CongViec implements Serializable {
    public int id;
    public String noidung;
    public String thoigian;

    public CongViec(String nd, String tg) //ham tao danh cho viec them
    {
        this.noidung=nd;
        this.thoigian=tg;
    }

    public CongViec(int id,String nd,String tg)
    {
        this.id=id;
        this.noidung=nd;
        this.thoigian=tg;
    }

}
