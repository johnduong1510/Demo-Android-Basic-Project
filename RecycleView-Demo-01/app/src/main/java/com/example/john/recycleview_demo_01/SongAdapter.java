package com.example.john.recycleview_demo_01;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by John on 1/29/2017.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private static final String TAG="SongAdapter";
    private List<Song> mSongs;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public SongAdapter(Context context,List<Song> data)
    {
        mContext=context;
        mSongs=data;
        mLayoutInflater=LayoutInflater.from(mContext);
    }

    public void addItem(int position, String item)
    {
        mSongs.add(position,new Song("temp",item,item,item));
        notifyItemInserted(position);
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate view from item_row_song
        View itemView=mLayoutInflater.inflate(R.layout.item_row_song,null,false);
        return new SongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        Song song=mSongs.get(position);

        //bind data
        holder.tv_mCode.setText(song.getmCode());
        holder.tv_mTitle.setText(song.getmTitle());
        holder.tv_mLycric.setText(song.getmLycric());
        holder.tv_mArtist.setText(song.getmArtist());

    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }

    class SongViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_mCode;
        private TextView tv_mTitle;
        private TextView tv_mLycric;
        private TextView tv_mArtist;
        public SongViewHolder(final View itemView) {
            super(itemView);
            tv_mCode=(TextView)itemView.findViewById(R.id.tv_Code);
            tv_mTitle=(TextView)itemView.findViewById(R.id.tv_Title);
            tv_mLycric=(TextView)itemView.findViewById(R.id.tv_Lycric);
            tv_mArtist=(TextView)itemView.findViewById(R.id.tv_Artist);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext,tv_mCode.getText().toString(),Toast.LENGTH_SHORT).show();
                    Toast.makeText(mContext,tv_mTitle.getText().toString(),Toast.LENGTH_SHORT).show();

                }
            });
        }

    }
}
