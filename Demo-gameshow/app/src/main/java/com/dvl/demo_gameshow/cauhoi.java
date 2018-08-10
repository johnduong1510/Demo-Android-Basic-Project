package com.dvl.demo_gameshow;

/**
 * Created by Admin on 31/7/2016.
 */
public class cauhoi {
    private   int _id;
    private   String cauhoi,cau_a,cau_b,cau_c,cau_d,dapan;

    public cauhoi()
    {

    }

    public cauhoi(int _id,String cauhoi,String cau_a,String cau_b,String cau_c,String cau_d,String dapan)
    {
        this._id=_id;
        this.cauhoi=cauhoi;
        this.cau_a=cau_a;
        this.cau_b=cau_b;
        this.cau_c=cau_c;
        this.cau_d=cau_d;
        this.dapan=dapan;
    }

    public int get_id()
    {
        return _id;
    }

    public String get_cauhoi()
    {
        return cauhoi;
    }

    public String get_cau_a()
    {
        return cau_a;
    }
    public String get_cau_b()
    {
        return cau_b;
    }
    public String get_cau_c()
    {
        return cau_c;
    }
    public String get_cau_d()
    {
        return cau_d;
    }
    public String get_dapan()
    {
        return dapan;
    }
}
