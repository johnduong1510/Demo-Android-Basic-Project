package com.duongvyluan.demomvppattern.Presenter.DangXuat;

import android.util.Log;

import com.duongvyluan.demomvppattern.Model.DangXuat.ModelDangXuat;
import com.duongvyluan.demomvppattern.Model.DangXuat.SinhVien.SinhVien;
import com.duongvyluan.demomvppattern.View.DangXuat.ViewDangXuat;

import java.util.List;

/**
 * Created by JohnDuong on 22-Aug-17.
 */

public class PresenterLogicDangXuat implements PresenterImplDangXuat {

    ViewDangXuat viewDangXuat;

    public PresenterLogicDangXuat(ViewDangXuat viewDangXuat) {
        this.viewDangXuat = viewDangXuat;
    }

    @Override
    public void XuLyDangXuat() {
        viewDangXuat.DangXuatThanhCong();
        viewDangXuat.ChuyenManHinh();
    }


    @Override
    public void CreateData() {
        ModelDangXuat modelDangXuat=new ModelDangXuat(this);
        modelDangXuat.createListData();
    }

    @Override
    public void onLoadSucess(List<SinhVien> listSinhVien) {
        viewDangXuat.LoadListSinhVien(listSinhVien);
        Log.v("list sinh vien",listSinhVien+"");
        viewDangXuat.LoadDataSucess();
    }

    @Override
    public void itemClickHandle(int position) {
        viewDangXuat.oniItemListViewClick(position);
    }
}
