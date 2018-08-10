package com.example.johnduong.kotlin_customrecyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.recyclerview_item.view.*

/**
 * Created by John Duong on 3/22/2018.
 */
class RecyclerViewAdapter (private val array:ArrayList<SinhVien>, private val context: Context) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private var mangSinhVien: ArrayList<SinhVien> = array

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerViewAdapter.ViewHolder {
        var view:View = LayoutInflater.from(context).inflate(R.layout.recyclerview_item,parent,false)
        return RecyclerViewAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mangSinhVien.size
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        holder.itemView.textViewTen.text=mangSinhVien.get(position).getOfTen()
        holder.itemView.textViewDiaChi.text=mangSinhVien.get(position).getOfDiaChi()
        holder.itemView.textViewNamSinh.text=mangSinhVien.get(position).getOfNamSinh().toString()

        //Catch Click Event
        holder.itemView.textViewTen.setOnClickListener{
            Toast.makeText(context,mangSinhVien.get(position).getOfTen(),Toast.LENGTH_SHORT).show()
        }
        holder.itemView.textViewDiaChi.setOnClickListener{
            Toast.makeText(context,mangSinhVien.get(position).getOfDiaChi(),Toast.LENGTH_SHORT).show()
        }
        holder.itemView.textViewNamSinh.setOnClickListener{
            Toast.makeText(context,mangSinhVien.get(position).getOfNamSinh().toString(),Toast.LENGTH_SHORT).show()
        }
    }

     class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var v:View=itemView
        init {
            v.textViewTen.text=""
            v.textViewDiaChi.text=""
            v.textViewNamSinh.text=""
        }

    }
}