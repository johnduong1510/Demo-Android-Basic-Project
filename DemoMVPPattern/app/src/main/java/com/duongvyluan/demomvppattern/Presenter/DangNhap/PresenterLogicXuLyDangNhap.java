package com.duongvyluan.demomvppattern.Presenter.DangNhap;

import com.duongvyluan.demomvppattern.View.DangNhapActivity.ViewXuLyDangNhap;

/**
 * Created by JohnDuong on 22-Aug-17.
 */

public class PresenterLogicXuLyDangNhap implements PresenterImplXuLyDangNhap {
    ViewXuLyDangNhap viewXuLyDangNhap;

    public PresenterLogicXuLyDangNhap(ViewXuLyDangNhap viewXuLyDangNhap)
    {
        this.viewXuLyDangNhap=viewXuLyDangNhap;
    }
    @Override
    public void KiemTraDangNhap(String username, String password) {
        //Goi toi Model de lay du lieu
        if (username.equals("vyluan") && password.equals("123")) {
            //Tra ra View dang nhap thanh cong
            viewXuLyDangNhap.DangNhapThanhCong();
            viewXuLyDangNhap.ChuyenManHinh();
        }
        else {
            //Tra ra View dang nhap that bai
            viewXuLyDangNhap.DangNhapThatBai();
        }
    }

}
