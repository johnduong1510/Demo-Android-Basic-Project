package com.dvl.datepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button)findViewById(R.id.button);

        bt.setOnClickListener(new View.OnClickListener() {
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
                        Toast.makeText(MainActivity.this,dayOfMonth+"/"+(monthOfYear+1)+"/"+year,Toast.LENGTH_SHORT).show();
                        calendar.set(year,monthOfYear,dayOfMonth);
                        Toast.makeText(MainActivity.this,calendar.get(Calendar.DAY_OF_WEEK)+"",Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}
