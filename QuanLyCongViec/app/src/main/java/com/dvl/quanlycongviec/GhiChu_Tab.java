package com.dvl.quanlycongviec;

import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class GhiChu_Tab extends Activity {
    EditText et;
    LineEditText lineEditText;
    Button bt4;
    QuanLyCongViec quanLyCongViec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghi_chu);
        et = (EditText) findViewById(R.id.note);
        bt4=(Button)findViewById(R.id.button4);
        dodulieu();
        //kt co nhan Shift Enter (trong paragraph thi xuong hang), con khong se goi lai ham
        //OnDraw de ve gach duoi
        et.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event!=null)
                {
                    // if shift key is down, then we want to insert the '\n' char in the TextView;
                    // otherwise, the default action is refresh the onDraw()
                    if(!event.isShiftPressed())
                    {
                        lineEditText=new LineEditText(GhiChu_Tab.this);
                        lineEditText.postInvalidate();
                    }
                    else
                    {
                        et.append("\n");
                    }
                }
                return false;
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_GhiChu();
                dodulieu();
            }
        });


    }

    private void save_GhiChu() {
        SharedPreferences ghi=getPreferences(MODE_APPEND);
        SharedPreferences.Editor editor=ghi.edit();
        editor.putString("noidung",et.getText().toString());
        editor.commit();
    }

    private void dodulieu()
    {
        SharedPreferences doc=getPreferences(MODE_APPEND);
        String chuoi=doc.getString("noidung","");
        et.setText(chuoi);
    }

}
