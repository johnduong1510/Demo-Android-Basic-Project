package com.duongvyluan.demomvppattern.Model.DangXuat;

import com.duongvyluan.demomvppattern.Model.DangXuat.SinhVien.SinhVien;
import com.duongvyluan.demomvppattern.Presenter.DangXuat.PresenterImplDangXuat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JohnDuong on 22-Aug-17.
 */

public class ModelDangXuat {
    private PresenterImplDangXuat PresenterImplDangXuat;
    public ModelDangXuat(PresenterImplDangXuat PresenterImplDangXuat){this.PresenterImplDangXuat=PresenterImplDangXuat;}

    //Khoi tao du lieu
    public void createListData()
    {
        List<SinhVien> listSinhvien=new ArrayList<>();
        for(int i=0;i<10;i++){
            SinhVien sv=new SinhVien(i+"","123","0123",i+1.0f);
            listSinhvien.add(sv);
        }
        PresenterImplDangXuat.onLoadSucess(listSinhvien);
    }
}
