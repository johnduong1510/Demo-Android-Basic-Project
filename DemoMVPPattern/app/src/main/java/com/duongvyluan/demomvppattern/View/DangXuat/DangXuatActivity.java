package com.duongvyluan.demomvppattern.View.DangXuat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.duongvyluan.demomvppattern.Model.DangXuat.SinhVien.SinhVien;
import com.duongvyluan.demomvppattern.Presenter.DangXuat.PresenterLogicDangXuat;
import com.duongvyluan.demomvppattern.R;
import com.duongvyluan.demomvppattern.View.DangNhapActivity.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class DangXuatActivity extends AppCompatActivity implements ViewDangXuat {
    Button btn_Logout;
    ListView listViewSinhVien;
    PresenterLogicDangXuat presenterLogicDangXuat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_xuat);
        btn_Logout=(Button)findViewById(R.id.buttonLogout);
        listViewSinhVien=(ListView)findViewById(R.id.listViewSinhVien);

        presenterLogicDangXuat=new PresenterLogicDangXuat(this);
        presenterLogicDangXuat.CreateData();

        btn_Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterLogicDangXuat.XuLyDangXuat();
            }
        });

        listViewSinhVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                presenterLogicDangXuat.itemClickHandle(position);
            }
        });
    }

    @Override
    public void DangXuatThanhCong() {
        Toast.makeText(DangXuatActivity.this,"Dang xuat thanh cong",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ChuyenManHinh() {
        this.finish();
        startActivity(new Intent(DangXuatActivity.this, MainActivity.class));
    }

    @Override
    public void LoadListSinhVien(List<SinhVien> listSinhVien) {
        List<String>listSV=new ArrayList<>();
        for(int i=0;i<listSinhVien.size();i++) listSV.add(listSinhVien.get(i).toString());
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(DangXuatActivity.this,android.R.layout.simple_list_item_1,listSV);
        listViewSinhVien.setAdapter(arrayAdapter);
    }


    @Override
    public void LoadDataSucess() {
        Toast.makeText(DangXuatActivity.this,"Load Data Thanh Cong",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoadDataFailure() {
        Toast.makeText(DangXuatActivity.this,"Load Data That Bai",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void oniItemListViewClick(int position) {
        Toast.makeText(DangXuatActivity.this,position+"",Toast.LENGTH_SHORT).show();
    }
}
