package com.example.admin.class_hinhchunhat_bai1;

import java.security.PublicKey;

/**
 * Created by Admin on 30/6/2016.
 */
public class HinhChuNhat {
    private int dai,rong;

    HinhChuNhat()
    {
        dai=1;
        rong=1;
    }
    HinhChuNhat(int cd,int cr)
    {
        this.dai=cd;
        this.rong=cr;

    }
    public int getDai()
    {
        return dai;
    }
    public int getRong()
    {
        return rong;
    }
    public void setDai(int cd)
    {
        dai=cd;
    }
    public void setRong(int cr)
    {
        rong=cr;
    }
    public int getDienTich()
    {
        return (dai*rong);
    }
    public int getChuVi()
    {
        return (dai+rong)*2;
    }
    public String getInfo()
    {
        return("Dien tich= "+getDienTich()+"\n"+"Chu vi= "+getChuVi());
    }

}
