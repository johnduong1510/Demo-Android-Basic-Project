package com.example.admin.lich_lam_viec;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button btNhap, btTim;
    String Date="";
    TextView thongbao;
    Calendar calendar = Calendar.getInstance();
    View v;
    TextView hienthi_ngay;
    TextView pickDate;
    TextView content;
    String chuoi="";
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btNhap = (Button) findViewById(R.id.button2);
        btTim = (Button) findViewById(R.id.button3);
        thongbao = (TextView) findViewById(R.id.textView2);
        thongbao.setText("");
        load_info();


        btNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                my_adding_dialog();
            }
        });
        btTim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialogTim();

            }
        });
    }

    void load_info()
    {
        SharedPreferences data=getPreferences(MODE_APPEND);
        Map<String,?> info=data.getAll();
        if(info.entrySet().isEmpty()) return;
        for (Map.Entry<String, ?> entry : info.entrySet()) {
            chuoi = entry.getKey() + "\n" +  "\n" + entry.getValue() + "\n" + "------------------------------"+"\n";
            thongbao.append(chuoi + "\n");
        }

    }

    void update_info()
    {
        SharedPreferences data=getPreferences(MODE_APPEND);
        thongbao.append(Date+"\n"+ "\n" + data.getString(Date,null)+ "\n" + "------------------------------"+"\n");
    }

    void alertDialogTim()
    {
        AlertDialog.Builder mydialog=new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater=getLayoutInflater();
        View v=inflater.inflate(R.layout.find_custom_layout,null);
        mydialog.setView(v);
        pickDate=(TextView)v.findViewById(R.id.textViewFind);
        content=(TextView)v.findViewById(R.id.textViewContent);
        content.setText("");
        mydialog.setPositiveButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        pickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=1;
                my_date_dialog();
            }
        });
        ////
        mydialog.setNegativeButton("Xóa tất cả dữ liệu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AlertDialog.Builder sure=new AlertDialog.Builder(MainActivity.this);
                sure.setTitle("Xác nhận");
                sure.setMessage("Bạn có muốn xóa hết dữ liệu không ?");
                sure.setPositiveButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                sure.setNegativeButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences data=getPreferences(MODE_APPEND);
                        SharedPreferences.Editor editor=data.edit();
                        editor.clear();
                        editor.apply();
                        thongbao.setText("");

                    }
                });
                AlertDialog alertDialog2=sure.create();
                alertDialog2.show();
            }
        });
        mydialog.show();
    }

    void my_date_dialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + (year);
                        if(flag==1)
                        {
                            try {
                                pickDate.setText(Date);
                                flag=0;
                                SharedPreferences data = getPreferences(MODE_APPEND);
                                content.setText(data.getString(Date, "Không có dữ liệu"));
                            }
                            catch (Exception e){}
                        }
                        else hienthi_ngay.setText(Date);

                    }
                }
                , calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    void my_adding_dialog() {
        AlertDialog.Builder mydialog = new AlertDialog.Builder(MainActivity.this);
        mydialog.setCancelable(false);
        LayoutInflater inflater = getLayoutInflater();
        v= inflater.inflate(R.layout.add_custom_dialog, null);
        mydialog.setView(v);
        hienthi_ngay=(TextView)v.findViewById(R.id.textViewAdd);
        mydialog.setNegativeButton("Nhập", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText noidung=(EditText)v.findViewById(R.id.editText);
                SharedPreferences data = getPreferences(MODE_APPEND);
                SharedPreferences.Editor editor = data.edit();
                if(Date.equals("") || (noidung.getText().toString().isEmpty()));
                else  {
                    editor.putString(Date,noidung.getText().toString());
                    editor.apply();
                    update_info();
                }
            }

        });
        mydialog.setPositiveButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        hienthi_ngay.setText("Chọn ngày");
        hienthi_ngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                my_date_dialog();
            }
        });

        mydialog.show();
    }
}