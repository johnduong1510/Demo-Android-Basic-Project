package com.dvl.listview_multiselect_singleselect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewMultiSelection extends AppCompatActivity {

    private static final String TAG = "ListViewMultiple";
    private ListView lvMultipleSelection;
    private Button btnGetItemsChecked;
    private CheckBox cbCheckAll;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_multi_selection);

        lvMultipleSelection = (ListView) findViewById(R.id.lv_multiple_selection);
        btnGetItemsChecked = (Button) findViewById(R.id.btn_get_item_selected);
        cbCheckAll = (CheckBox) findViewById(R.id.cb_check_all);

        final List<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("Item " + i);
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, data);
        lvMultipleSelection.setAdapter(adapter);
        lvMultipleSelection.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        btnGetItemsChecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SparseBooleanArray sparseBooleanArray = lvMultipleSelection.getCheckedItemPositions();

                String itemsSelected = "";
                Log.e(TAG, "Total Number Selected: " + lvMultipleSelection.getCheckedItemCount());
                for (int i = 0; i < sparseBooleanArray.size(); i++) {
                    int position = sparseBooleanArray.keyAt(i);
                    itemsSelected += "item " + position + ",";
                }

                Toast.makeText(ListViewMultiSelection.this, itemsSelected, Toast.LENGTH_SHORT).show();
            }
        });

        cbCheckAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.e(TAG, "onCheckedChanged: " + isChecked);
                for (int i = 0; i < adapter.getCount(); i++) {
                    lvMultipleSelection.setItemChecked(i, isChecked);
                }
            }
        });
    }
}