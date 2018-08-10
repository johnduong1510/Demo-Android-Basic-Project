package com.duongvyluan.note_nodejs_postgressql.SummaryActivity.View;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.duongvyluan.note_nodejs_postgressql.DetailsActivity.View.Main2Activity_Details;
import com.duongvyluan.note_nodejs_postgressql.SummaryActivity.Model.Client_Summary;
import com.duongvyluan.note_nodejs_postgressql.SummaryActivity.Model.Object_Note;
import com.duongvyluan.note_nodejs_postgressql.SummaryActivity.Presenter.PresenterLogicSummary;
import com.duongvyluan.note_nodejs_postgressql.R;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class MainActivity_Summary extends AppCompatActivity implements com.duongvyluan.note_nodejs_postgressql.SummaryActivity.View.View {

    FloatingActionButton fab_new;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    PresenterLogicSummary presenterLogicSummary;
    String baseUrlLink = "http://192.168.1.5:3000/";
    //String baseUrlLink="https://demo-webservice-nodejs.herokuapp.com/";
    String readNotesUrlLink = baseUrlLink + "readNotes";
    String addUserUrlLink = baseUrlLink + "addUser";

    //String readNotesUrlLink=baseUrlLink + "readNotes";
    List<Object_Note> data;
    //Todo: create a database class
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab_new = (FloatingActionButton) findViewById(R.id.fab_new);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_Note);
        presenterLogicSummary = new PresenterLogicSummary(this, getApplicationContext());
        //Set Recycler Adapter
        data = new ArrayList<>();
        recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext(), data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
        //Starting load data from database
        //Todo: Load data from Database instead loading from server
        presenterLogicSummary.sendPost(readNotesUrlLink,"username","user","","");


        fab_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Main2Activity_Details.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu_summary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_about_summary:
                Toasty.info(getApplicationContext(), "Author: Duong Vy Luan", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_sync_summary:
                SharedPreferences sharedPreferences = this.getSharedPreferences("login", Context.MODE_PRIVATE);
                if (sharedPreferences == null) showRegisterDialogs();
                else {
                    //Todo: call Sync() data
                }
                break;
            case R.id.menu_login_summary:
                sharedPreferences = this.getSharedPreferences("login", Context.MODE_PRIVATE);
                if (sharedPreferences.getString("username","").isEmpty()) showLoginDialogs();
                else Toasty.info(getApplicationContext(),"Da luu username - Khong can login",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    public void showRegisterDialogs() {
        LayoutInflater layoutInflater = getLayoutInflater();
        View viewDialog = layoutInflater.inflate(R.layout.custom_register_dialogs, null);
        final EditText edt_Username = (EditText) viewDialog.findViewById(R.id.Custom_Register_EditText_Username);
        final EditText edt_Password = (EditText) viewDialog.findViewById(R.id.Custom_Register_EditText_Password);
        final EditText edt_PasswordAgain = (EditText) viewDialog.findViewById(R.id.Custom_Register_EditText_PasswordAgain);
        final CheckBox checkBox = (CheckBox) viewDialog.findViewById(R.id.Custom_Register_Checkbox_Password);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    edt_Password.setTransformationMethod(null);
                    edt_PasswordAgain.setTransformationMethod(null);
                } else {
                    edt_Password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    edt_PasswordAgain.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Register");
        builder.setView(viewDialog);
        builder.setCancelable(false);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("Register", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("login", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String username = edt_Username.getText().toString().trim();
                String password = edt_Password.getText().toString().trim();
                String passwordagain = edt_PasswordAgain.getText().toString().trim();
                if (password.equalsIgnoreCase(passwordagain)) {
                    editor.putString("username", username);
                    editor.putString("password", password);
                    editor.apply();
                    //Todo: if register successfully, begin to sync()
                } else
                    Toasty.error(getApplicationContext(), "Password not match", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialogs = builder.create();
        dialogs.show();
    }

    public void showLoginDialogs() {
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.custom_login_dialogs, null);
        final EditText edt_username = (EditText) view.findViewById(R.id.Custom_Login_EditText_Username);
        final EditText edt_password = (EditText) view.findViewById(R.id.Custom_Login_EditText_Password);
        final CheckBox checkBox = (CheckBox) view.findViewById(R.id.Custom_Login_Checkbox_Password);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    edt_password.setTransformationMethod(null);
                } else {
                    edt_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Login");
        builder.setView(view);
        builder.setCancelable(false);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("login", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String username = edt_username.getText().toString().trim();
                String password = edt_password.getText().toString().trim();
                editor.putString("username", username);
                editor.putString("password", password);
                editor.apply();
                //Todo: After log in successfully, begin to sync()
            }
        });
        AlertDialog dialogs = builder.create();
        dialogs.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerView.scrollToPosition(data.size() - 1);
    }

    @Override
    public void addDataRecyclerView(List<Object_Note> data) {
        this.data=data;
        recyclerViewAdapter.setData(data);
        refreshRecyclerView();
    }

    @Override
    public void refreshRecyclerView() {
        recyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPOSTFailure(String message) {
        Toasty.error(getApplicationContext(), "Error: " + message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPOSTSuccess(String message) {
        Toasty.success(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }


}
