package com.example.johnduong.kotlin_sinhvienoop

/**
 * Created by John Duong on 3/21/2018.
 */
class SinhVien  {
    private var HoTen:String=""
    private var DiaChi:String=""
    private var NamSinh:Int=0

    constructor() {}
    constructor(hoten:String,diachi:String,namsinh:Int){
        this.HoTen=hoten
        this.DiaChi=diachi
        this.NamSinh=namsinh
    }
}