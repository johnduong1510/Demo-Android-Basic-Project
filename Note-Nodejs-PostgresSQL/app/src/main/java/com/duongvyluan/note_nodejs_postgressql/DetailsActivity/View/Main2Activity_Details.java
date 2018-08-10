package com.duongvyluan.note_nodejs_postgressql.DetailsActivity.View;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.duongvyluan.note_nodejs_postgressql.DetailsActivity.Presenter.PresenterLogic_Details;
import com.duongvyluan.note_nodejs_postgressql.R;

import es.dmoral.toasty.Toasty;

public class Main2Activity_Details extends AppCompatActivity implements View_Details {
    Toolbar toolbar;
    EditText edt_title,edt_content;
    int count=0;
    FloatingActionButton fab_save;
    PresenterLogic_Details presenterLogic_details;
    String baseUrlLink="http://192.168.1.12:3000";
   // String baseUrlLink="https://demo-webservice-nodejs.herokuapp.com";
    String addNoteLink=baseUrlLink+ "/addNote";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_details);
        toolbar=(Toolbar)findViewById(R.id.toolbar_details);
        edt_title=(EditText)findViewById(R.id.editText_Title_Details);
        edt_content=(EditText)findViewById(R.id.editText_Content_Details);
        fab_save=(FloatingActionButton)findViewById(R.id.fab_save);
        setSupportActionBar(toolbar);
        //Không hiện tiêu đề
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //Hiện nút back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        presenterLogic_details=new PresenterLogic_Details(this,getApplicationContext());

        fab_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=edt_title.getText().toString().trim();
                String content=edt_content.getText().toString().trim();
                if(title.isEmpty() || content.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Chưa điền đầy đủ",Toast.LENGTH_SHORT).show();
                    return;
                }
                presenterLogic_details.sendNote(addNoteLink,"title",title,"content",content);
            }
        });
    }

    //Bat su kien cho nut Back tren Toolbar
    //Neu sau 3s ke tu lan dau Back => tra ve trang thai ban dau
    @Override
    public boolean onSupportNavigateUp() {
        count++;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    count=0;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        if(count==2)
            finish();
        else Toasty.info(getApplicationContext(),"Click one more time to get back",Toast.LENGTH_SHORT).show();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        count++;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    count=0;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        if(count==2) super.onBackPressed();
        else Toasty.info(getApplicationContext(),"Click one more time to get back",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void saveSuccess() {

    }

    @Override
    public void saveFailure() {

    }

    @Override
    public void onPostSuccess(String message) {
        Toasty.success(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onPostFailure(String message) {
       Toasty.error(getApplicationContext(),"Error: "+message,Toast.LENGTH_SHORT).show();
    }

}
