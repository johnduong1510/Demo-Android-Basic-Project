package com.duongvyluan.note_nodejs_postgressql.SummaryActivity.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.duongvyluan.note_nodejs_postgressql.SummaryActivity.Model.Object_Note;
import com.duongvyluan.note_nodejs_postgressql.R;

import java.util.List;

/**
 * Created by JohnDuong on 21-Sep-17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Object_Note> data;

    public RecyclerViewAdapter(Context context, List<Object_Note> data) {
        this.context = context;
        this.data = data;
    }
    public void setData(List<Object_Note> data) {this.data=data;}

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(context).inflate(R.layout.recyclerview_item_summary, parent, false);
        return new itemViewHolder_Summary(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //Catch events or set
        itemViewHolder_Summary viewHolder_summary = (itemViewHolder_Summary) holder;
        viewHolder_summary.edt_title.setText(data.get(position).getTitleNote());
        viewHolder_summary.edt_content.setText(data.get(position).getContentNote());
        viewHolder_summary.tv_id.setText(data.get(position).getID()+"");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class itemViewHolder_Summary extends RecyclerView.ViewHolder {
        private EditText edt_title, edt_content;
        private TextView tv_id;

        public itemViewHolder_Summary(View itemView) {
            super(itemView);
            tv_id=(TextView)itemView.findViewById(R.id.recyclerView_TextView_ID_Summary);
            edt_title = (EditText) itemView.findViewById(R.id.recyclerView_EditText_Title_Summary);
            edt_content = (EditText) itemView.findViewById(R.id.recyclerView_EditText_Content_Summary);
        }
    }

}
