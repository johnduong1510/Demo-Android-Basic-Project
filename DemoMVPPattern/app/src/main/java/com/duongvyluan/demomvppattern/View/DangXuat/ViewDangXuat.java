package com.duongvyluan.demomvppattern.View.DangXuat;

import com.duongvyluan.demomvppattern.Model.DangXuat.SinhVien.SinhVien;

import java.util.List;

/**
 * Created by JohnDuong on 22-Aug-17.
 */

public interface ViewDangXuat {
    void DangXuatThanhCong();
    void ChuyenManHinh();
    void LoadListSinhVien(List<SinhVien> listSinhVien);
    void LoadDataSucess();
    void LoadDataFailure();
    void oniItemListViewClick(int position);
}
