package com.duongvyluan.demomvppattern.Model.DangXuat.SinhVien;

/**
 * Created by JohnDuong on 22-Aug-17.
 */

public class SinhVien {
    private String ten,mssv,sodt;
    private float dtb;

    public SinhVien(){}
    public SinhVien(String ten,String mssv,String sodt,float dtb){
        this.ten=ten;
        this.mssv=mssv;
        this.sodt=sodt;
        this.dtb=dtb;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public void setDtb(float dtb) {
        this.dtb = dtb;
    }

    public String getTen() {

        return ten;
    }

    public String getMssv() {
        return mssv;
    }

    public String getSodt() {
        return sodt;
    }

    public float getDtb() {
        return dtb;
    }
    public String toString(){
        return ten+mssv+dtb;
    }
}
