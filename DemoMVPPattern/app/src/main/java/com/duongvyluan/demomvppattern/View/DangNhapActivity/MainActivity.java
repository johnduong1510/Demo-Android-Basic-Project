package com.duongvyluan.demomvppattern.View.DangNhapActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.duongvyluan.demomvppattern.R;
import com.duongvyluan.demomvppattern.Presenter.DangNhap.PresenterLogicXuLyDangNhap;
import com.duongvyluan.demomvppattern.View.DangXuat.DangXuatActivity;

public class MainActivity extends AppCompatActivity implements ViewXuLyDangNhap,View.OnClickListener {


    //To chuc theo huong chuc nang

    Button btn_Login;
    PresenterLogicXuLyDangNhap presenterLogicXuLyDangNhap;
    EditText edt_Username,edt_Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_Login=(Button)findViewById(R.id.buttonLogin);
        edt_Username=(EditText)findViewById(R.id.edt_Username);
        edt_Password=(EditText)findViewById(R.id.edt_Password);
        presenterLogicXuLyDangNhap=new PresenterLogicXuLyDangNhap(this);
        btn_Login.setOnClickListener(this);
    }

    @Override
    public void DangNhapThanhCong() {
        Toast.makeText(MainActivity.this,"Dang nhap thanh cong",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void DangNhapThatBai() {
        Toast.makeText(MainActivity.this,"Dang nhap that bai",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ChuyenManHinh() {
        this.finish();
        startActivity(new Intent(MainActivity.this, DangXuatActivity.class));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonLogin:
                String username=edt_Username.getText().toString();
                String password=edt_Password.getText().toString();
                presenterLogicXuLyDangNhap.KiemTraDangNhap(username,password);
                break;
            default:break;
        }
    }
}
