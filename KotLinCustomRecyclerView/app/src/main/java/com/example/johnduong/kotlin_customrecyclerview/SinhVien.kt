package com.example.johnduong.kotlin_customrecyclerview

/**
 * Created by John Duong on 3/22/2018.
 */
class SinhVien {

    private var Ten:String =""
    private var DiaChi:String=""
    private var NamSinh:Int=0

    constructor()
    constructor(ten:String,diachi:String,namsinh:Int){
        this.Ten=ten
        this.DiaChi=diachi
        this.NamSinh=namsinh
    }

    fun setOfDiaChi(diachi:String) {DiaChi=diachi}
    fun setOfTen(ten:String) {Ten=ten}
    fun setOfNamSinh(namsinh:Int) {NamSinh=namsinh}

    fun getOfTen():String {return Ten}
    fun getOfDiaChi():String {return DiaChi}
    fun getOfNamSinh():Int {return NamSinh}
}