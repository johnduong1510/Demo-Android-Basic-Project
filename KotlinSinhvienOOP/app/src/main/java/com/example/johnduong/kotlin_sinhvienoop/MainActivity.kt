package com.example.johnduong.kotlin_sinhvienoop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var mangSinhVien:ArrayList<SinhVien> =ArrayList()
//        var sv1:SinhVien=SinhVien()
//        sv1.HoTen="luan"
//        sv1.DiaChi="7k"
//        sv1.NamSinh=1995
//        mangSinhVien.add()

        var sv1:SinhVien=SinhVien("luan","diachi",1)

        var phuongtien:PhuongTien =PhuongTien("xe dap",2)
        Log.d("test","phuong tien: ${phuongtien.ten} sobanh=${phuongtien.sobanh}")
    }
}
