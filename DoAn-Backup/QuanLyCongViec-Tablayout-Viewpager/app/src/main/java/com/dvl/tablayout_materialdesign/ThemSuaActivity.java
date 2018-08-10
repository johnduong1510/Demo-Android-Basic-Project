package com.dvl.tablayout_materialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;

import java.util.Calendar;

public class ThemSuaActivity extends AppCompatActivity {
    EditText et_noidung, et_thoigian;
    Button btThemSua, btHuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sua);
        et_noidung = (EditText) findViewById(R.id.editText);
        et_thoigian = (EditText) findViewById(R.id.editText2);
        btThemSua = (Button) findViewById(R.id.button2);
        btHuy = (Button) findViewById(R.id.button3);

        final String mode = getIntent().getExtras().getString("mode");
        final CongViec congViec = (CongViec) getIntent().getExtras().get("congviec");
        if (mode.equalsIgnoreCase("add")) {
            btThemSua.setText(getString(R.string.add_bt));
        } else if (mode.equalsIgnoreCase("edit")) {
            btThemSua.setText(getString(R.string.edit_bt));
            et_noidung.setText(congViec.noidung);
            et_thoigian.setText(congViec.thoigian);
        }

        et_thoigian.setFocusable(false);
        et_thoigian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar= Calendar.getInstance();
                int ngay=calendar.get(Calendar.DAY_OF_MONTH);
                int thang=calendar.get(Calendar.MONTH);
                int nam=calendar.get(Calendar.YEAR);

                CalendarDatePickerDialogFragment cdp=new CalendarDatePickerDialogFragment();
                cdp.setFirstDayOfWeek(Calendar.MONDAY);
                cdp.setPreselectedDate(nam,thang,ngay);
                cdp.setDateRange(null,null);
                cdp.setThemeLight();
                cdp.show(getSupportFragmentManager(),"datepicker");


                cdp.setOnDateSetListener(new CalendarDatePickerDialogFragment.OnDateSetListener() {
                    @Override
                    public void onDateSet(CalendarDatePickerDialogFragment dialog, int year, int monthOfYear, int dayOfMonth) {
                        calendar.set(year,monthOfYear,dayOfMonth);
                        String chuoi="Th"+calendar.get(Calendar.DAY_OF_WEEK)+" "+dayOfMonth+"/"+monthOfYear+"/"+year;
                        et_thoigian.setText(chuoi);
                    }
                });
            }
        });




        btThemSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mode.equalsIgnoreCase("add")) {
                    Intent i = new Intent();
                    CongViec congViec;
                    String noidung = et_noidung.getText().toString();
                    String thoigian = et_thoigian.getText().toString();
                    if (check_blank(noidung, thoigian)) {
                        congViec = new CongViec(noidung, thoigian);
                        i.putExtra("congviec", congViec);
                        setResult(RESULT_OK, i);
                        finish();
                    }

                } else if (mode.equalsIgnoreCase("edit")) {
                    int id = congViec.id;
                    String noidung = et_noidung.getText().toString();
                    String thoigian = et_thoigian.getText().toString();
                    CongViec congViecEdited = new CongViec(id, noidung, thoigian);
                    Intent i = new Intent();
                    i.putExtra("congviec", congViecEdited);
                    setResult(RESULT_OK, i);
                    finish();
                }
            }
        });


        btHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    Boolean check_blank(String noidung, String thoigian) {
        if (!noidung.isEmpty() && !thoigian.isEmpty()) {
            return true;
        }
        else if(noidung.isEmpty())
        {
            et_noidung.setError(getResources().getString(R.string.error_empty));
        }
        else et_thoigian.setError(getResources().getString(R.string.error_empty));
        return false;
    }

}