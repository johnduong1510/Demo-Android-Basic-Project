package com.example.admin.class_hinhchunhat_bai1;

/**
 * Created by Admin on 1/7/2016.
 */
public class hinhvuong extends HinhChuNhat {
    public int canh;

    hinhvuong()
    {
        super();
    }

    hinhvuong(int x)
    {
        super(x,x);
    }

    public int getCanh()
    {
       // return this.getDai();
        return super.getDai();

    }

    public void setCanh(int canh)
    {
      //  this.setDai(canh);
       // this.setRong(canh);
        super.setDai(canh);
        super.setRong(canh);
    }

    public String getInfo()
    {
        return (super.getInfo());

    }
}
