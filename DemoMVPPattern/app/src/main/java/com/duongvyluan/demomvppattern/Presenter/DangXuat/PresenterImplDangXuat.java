package com.duongvyluan.demomvppattern.Presenter.DangXuat;

import com.duongvyluan.demomvppattern.Model.DangXuat.SinhVien.SinhVien;

import java.util.List;

/**
 * Created by JohnDuong on 22-Aug-17.
 */

public interface PresenterImplDangXuat {
    void XuLyDangXuat();
    void CreateData();
    void onLoadSucess(List<SinhVien>listSinhVien);
    void itemClickHandle(int position);
}
