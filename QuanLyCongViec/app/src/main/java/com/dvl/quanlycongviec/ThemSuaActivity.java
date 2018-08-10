package com.dvl.quanlycongviec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
            et_noidung.setError("Empty");
        }
        else et_thoigian.setError("Empty");
        return false;
    }

}
